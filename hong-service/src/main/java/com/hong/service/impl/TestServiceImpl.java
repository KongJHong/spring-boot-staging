package com.hong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.repository.dao.UserDao;
import com.hong.repository.entity.User;
import com.hong.service.dto.UserDTO;
import com.hong.service.mapper.UserMapper;
import com.hong.service.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description     :
 */
@Service
public class TestServiceImpl extends ServiceImpl<UserDao, User> implements TestService {

	private final UserMapper userMapper;


	public TestServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public int insertBatch(List<UserDTO> userDTOS) {
		List<User> users = userMapper.dtoListToEntityList(userDTOS);
		saveBatch(users);
		return 0;
	}
}
