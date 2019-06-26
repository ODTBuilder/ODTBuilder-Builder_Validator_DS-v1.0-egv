package com.git.qaproducer.filestatus.service;

import com.git.qaproducer.filestatus.domain.FileStatus;

public interface FileStatusService {
	public FileStatus retrieveFileStatusById(int fid);

	public void createFileStatus(FileStatus fileStatus);

	public void updateFileStatus(FileStatus fileStatus);

	public boolean deleteFileStatus(FileStatus fs);
}
