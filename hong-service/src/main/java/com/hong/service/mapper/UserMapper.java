package com.hong.service.mapper;

import com.hong.repository.entity.User;
import com.hong.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Description     :
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO entityToDto(User entity);

	User DtoToEntity(UserDTO dto);

	List<User> entityListToDtoList(List<UserDTO> dtos);

	List<UserDTO> dtoListToEntityList(List<User> entities);
}
