/**
 * 
 */
package com.git.qaproducer.qa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.qaproducer.qa.domain.QACategory;
import com.git.qaproducer.qa.repository.QACategoryRepository;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("qaCategoryService")
@Transactional
public class QACategoryService extends EgovAbstractServiceImpl {

	@Resource(name = "qaCategoryRepository")
	private QACategoryRepository qaCategoryRepository;

	@Transactional(readOnly = true)
	public QACategory retrieveQACategoryByIdx(int idx) {
		return qaCategoryRepository.retrieveQACategoryByIdx(idx);
	}

}
