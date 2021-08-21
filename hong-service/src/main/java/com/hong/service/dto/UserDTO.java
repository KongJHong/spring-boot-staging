package com.hong.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description     :
 */
@Data
public class UserDTO {

	private String username;

	private String nickname;

	private String area;

	private Integer userLevel;

	private String lastOnlineTime;

	private String location;

	private String ip;

	private String ipChg;

	private Integer deleted;

	private LocalDateTime updateTime;

	private LocalDateTime createTime;
}
