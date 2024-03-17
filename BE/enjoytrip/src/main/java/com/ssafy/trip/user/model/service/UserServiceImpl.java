package com.ssafy.trip.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		return userMapper.login(userDto);
	}

	@Override
	public UserDto userInfo(String userId) throws Exception {
		return userMapper.userInfo(userId);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);

	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return userMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		userMapper.deleteRefreshToken(map);
	}

	@Override
	public void regist(UserDto userDto) throws Exception {	
		if(userDto.getEmail()=="") {
			userDto.setEmail(null);
			userDto.setEmailDomain(null);
		}
		userMapper.regist(userDto);
	}

	@Override
	public void withdrawal(String userId) throws Exception {
		userMapper.withdrawal(userId);
		
	}

}
