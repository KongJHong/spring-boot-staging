package com.hong.api;

import com.hong.common.bean.JsonResult;
import com.hong.common.utils.RedisUtil;
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

	private final RedisUtil redisUtil;

	public TestController(
			UserMapper userMapper,
			UserDao userDao,
			RedisUtil redisUtil
	) {
		this.userMapper = userMapper;
		this.userDao = userDao;
		this.redisUtil = redisUtil;
	}

	@GetMapping("/demo")
	public JsonResult<UserDTO> demo() {
		User user = userDao.selectById(2);
		UserDTO dto = userMapper.entityToDto(user);
		return JsonResult.success(dto);
	}

	@GetMapping("/redis")
	public JsonResult<String> redis() {
		redisUtil.set("hello","hello redis");
		String result = String.valueOf(redisUtil.get("hello"));
		return JsonResult.success(result);
	}
}
