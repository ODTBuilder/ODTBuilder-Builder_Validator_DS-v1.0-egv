package com.git.qaproducer.user.service.impl;

import java.util.Map;


import com.git.qaproducer.user.domain.User;

public interface UserService {
	public User loginUserByInfo(Map<String, Object> infoMap);
	
	public User retrieveUserById(String uid);

	public User retrieveUserByIdx(int idx);

	public void createUser(User user);

	public User checkUserById(User user);

	public User checkUserByEmail(User user);

	public User checkDuplicatedById(String uid);

	public User checkDuplicatedByEmail(String email);

	public boolean setActiveUserById(User user);
}
