package com.git.qaproducer.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.git.qaproducer.filestatus.domain.FileStatus;
import com.git.qaproducer.user.domain.User;

public interface UploadService {
	public List<FileStatus> SaveFile(MultipartHttpServletRequest request, User loginUser) throws Exception;
	public void SaveErrorFile(MultipartHttpServletRequest request) throws Exception;
	
}
