package com.hong.repository.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description     : 基础bean
 */
@Data
public class BaseEntity {

	private Integer deleted;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
}
