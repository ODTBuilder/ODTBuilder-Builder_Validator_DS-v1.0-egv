package com.git.qaproducer.filestatus.mapper;

import com.git.qaproducer.filestatus.domain.FileStatus;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("fileStatusMapper")
public interface FileStatusMapper {

	FileStatus retrieveFileStatusById(int fid);

	void createFileStatus(FileStatus fileStatus);

	void updateFileStatus(FileStatus fileStatus);

	int deleteFileStatus(FileStatus fileStatus);
}
