package com.git.qaproducer.file.service;

import java.util.List;

import com.git.qaproducer.filestatus.domain.FileStatus;

public interface RequestService {
	public void requestFileQAList(List<FileStatus> files, int cid, String fileformat, String crs, String qaVer,
			String qaType, String bPrid, int prid);
}
