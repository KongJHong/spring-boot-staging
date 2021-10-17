package com.hong.service.service;

import com.hong.service.dto.UserDTO;

import java.util.List;

/**
 * Description     :
 */
public interface TestService {

	public int insertBatch(List<UserDTO> userDTOS);
}
