/**
 * 
 */
package com.git.gdsbuilder.geogig.command.transaction;

import java.util.Base64;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.git.gdsbuilder.geogig.GeogigCommandException;
import com.git.gdsbuilder.geogig.type.GeogigTransaction;

/**
 * Geogig BeginTransaction Command 실행 클래스.
 * 
 * @author DY.Oh
 *
 */
public class BeginTransaction {

	/**
	 * geogig
	 */
	private static final String geogig = "geogig";
	/**
	 * 실행 command
	 */
	private static final String command = "beginTransaction";

	/**
	 * Geogig Repository의 새 트랜잭션을 시작하여 트랜잭션 ID를 생성하여 반환.
	 * <p>
	 * 트랜잭션 ID는 Geogig Repository를 수정할 때 부여되며 여러 사용자가 Geogig Repository를 수정할 수
	 * 있도록 지원함.
	 * <p>
	 * 트랜잭션 ID는 고유한 값을 가지며 트랜잭선 ID로 Command 요청 시 해당 트랜잭션만 수정됨.
	 * 
	 * @param baseURL
	 *            Geogig Repository가 위치한 Geoserver BaseURL
	 *            <p>
	 *            (ex. http://localhost:8080/geoserver)
	 * @param username
	 *            Geoserver 사용자 ID
	 * @param password
	 *            Geoserver 사용자 PW
	 * @param repository
	 *            Geogig Repository명
	 * @return Command 실행 성공 - 트랜잭선 ID 반환
	 *         <p>
	 *         Command 실행 실패 - error 반환
	 * 
	 * @author DY.Oh
	 */
	public GeogigTransaction executeCommand(String baseURL, String username, String password, String repository) {

		// restTemplate
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(5000);
		factory.setConnectTimeout(3000);
		CloseableHttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100).setMaxConnPerRoute(5).build();
		factory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(factory);

		// header
		HttpHeaders headers = new HttpHeaders();
		String user = username + ":" + password;
		String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(user.getBytes());
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.add("Authorization", encodedAuth);

		// url
		String url = baseURL + "/" + geogig + "/repos/" + repository + "/" + command;

		// request
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<GeogigTransaction> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, GeogigTransaction.class);
		} catch (HttpClientErrorException e) {
			throw new GeogigCommandException(e.getMessage(), e.getResponseBodyAsString(), e.getStatusCode().value());
		} catch (ResourceAccessException e) {
			throw new GeogigCommandException(e.getMessage());
		}
		return responseEntity.getBody();
	}
}
