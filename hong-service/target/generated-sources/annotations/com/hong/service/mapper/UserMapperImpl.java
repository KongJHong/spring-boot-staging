package com.hong.service.mapper;

import com.hong.repository.entity.User;
import com.hong.service.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO entityToDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername( entity.getUsername() );
        userDTO.setNickname( entity.getNickname() );
        userDTO.setArea( entity.getArea() );
        userDTO.setUserLevel( entity.getUserLevel() );
        userDTO.setLastOnlineTime( entity.getLastOnlineTime() );
        userDTO.setLocation( entity.getLocation() );
        userDTO.setIp( entity.getIp() );
        userDTO.setIpChg( entity.getIpChg() );
        userDTO.setDeleted( entity.getDeleted() );
        userDTO.setUpdateTime( entity.getUpdateTime() );
        userDTO.setCreateTime( entity.getCreateTime() );

        return userDTO;
    }

    @Override
    public User DtoToEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.getUsername() );
        user.setNickname( dto.getNickname() );
        user.setArea( dto.getArea() );
        user.setUserLevel( dto.getUserLevel() );
        user.setLastOnlineTime( dto.getLastOnlineTime() );
        user.setLocation( dto.getLocation() );
        user.setIp( dto.getIp() );
        user.setIpChg( dto.getIpChg() );
        user.setDeleted( dto.getDeleted() );
        user.setUpdateTime( dto.getUpdateTime() );
        user.setCreateTime( dto.getCreateTime() );

        return user;
    }

    @Override
    public List<User> entityListToDtoList(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( DtoToEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> dtoListToEntityList(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entities.size() );
        for ( User user : entities ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }
}
