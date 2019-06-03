package com.git.qaproducer.qa.mapper;

import com.git.qaproducer.qa.domain.QACategory;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("qaCategoryMapper")
public interface QACategoryMapper {

	public QACategory retrieveQACategoryByIdx(int idx);

}
