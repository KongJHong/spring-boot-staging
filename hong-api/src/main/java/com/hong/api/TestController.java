package com.hong.api;

import com.hong.common.bean.JsonResult;
import com.hong.repository.dao.UserDao;
import com.hong.repository.entity.User;
import com.hong.service.dto.UserDTO;
import com.hong.service.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description     :
 */
@RestController
@RequestMapping("/test")
public class TestController {

	private final UserMapper userMapper;

	private final UserDao userDao;

	public TestController(
			UserMapper userMapper,
			UserDao userDao
	) {
		this.userMapper = userMapper;
		this.userDao = userDao;
	}

	@GetMapping("/demo")
	public JsonResult<?> demo() {
		User user = userDao.selectById(2);
		UserDTO dto = userMapper.entityToDto(user);
		return JsonResult.success(dto);
	}
}
