package com.git.qaproducer.filestatus.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.git.qaproducer.filestatus.domain.FileStatus;
import com.git.qaproducer.filestatus.mapper.FileStatusMapper;

@Repository("fileStatusRepository")
public class FileStatusRepository {

	@Resource(name = "fileStatusMapper")
	private FileStatusMapper fileStatusMapper;

	public FileStatus retrieveFileStatusById(int fid) {
		return fileStatusMapper.retrieveFileStatusById(fid);
	}

	public void createFileStatus(FileStatus fileStatus) {
		fileStatusMapper.createFileStatus(fileStatus);
	}

	public void updateFileStatus(FileStatus fileStatus) {
		fileStatusMapper.updateFileStatus(fileStatus);
	}

	public void deleteFileStatus(FileStatus fs) throws RuntimeException {
		fileStatusMapper.deleteFileStatus(fs);
	}
}
