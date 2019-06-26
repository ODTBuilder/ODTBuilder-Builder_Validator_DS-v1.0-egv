package com.git.qaproducer.file.service;

import com.git.qaproducer.user.domain.User;

public interface DeleteFileService {
	public boolean deleteErrorZipFile(User loginUser, String[] filenames) throws Exception;

	public boolean deleteOriginalZipFileWithPath(String user, String path) throws Exception;

	public boolean deleteOriginalZipFile(String user, int fid) throws Exception;

	public boolean deleteOriginalUnZipFile(String user, int fid) throws Exception;
}
