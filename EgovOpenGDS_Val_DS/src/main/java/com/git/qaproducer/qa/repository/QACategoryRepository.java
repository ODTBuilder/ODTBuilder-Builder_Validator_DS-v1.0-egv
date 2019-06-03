/**
 * 
 */
package com.git.qaproducer.qa.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.git.qaproducer.qa.domain.QACategory;
import com.git.qaproducer.qa.mapper.QACategoryMapper;

@Repository("qaCategoryRepository")
public class QACategoryRepository {

	@Resource(name = "qaCategoryMapper")
	private QACategoryMapper qaCategoryMapper;

	public QACategory retrieveQACategoryByIdx(int idx) {
		return qaCategoryMapper.retrieveQACategoryByIdx(idx);
	}
}
