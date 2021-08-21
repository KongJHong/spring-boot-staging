package com.hong.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author KongJHong
 * @since 2021-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

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
