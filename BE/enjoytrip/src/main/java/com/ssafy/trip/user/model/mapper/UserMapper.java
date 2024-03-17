package com.ssafy.trip.user.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.trip.user.model.UserDto;

public interface UserMapper {
	void regist(UserDto userDto) throws SQLException;
	UserDto login(UserDto userDto) throws SQLException;
	UserDto userInfo(String userId) throws SQLException;
	void saveRefreshToken(Map<String, String> map) throws SQLException;
	Object getRefreshToken(String userId) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	void withdrawal(String userId) throws SQLException;
}
