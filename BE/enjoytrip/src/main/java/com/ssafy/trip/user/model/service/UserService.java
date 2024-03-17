package com.ssafy.trip.user.model.service;

import com.ssafy.trip.user.model.UserDto;

public interface UserService {
	void regist(UserDto userDto) throws Exception;
	UserDto login(UserDto userDto) throws Exception;
	UserDto userInfo(String userId) throws Exception;
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleRefreshToken(String userId) throws Exception;
	void withdrawal(String userId) throws Exception;
	
}
