package com.hong.common.bean;

import com.hong.common.exception.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description     : 统一返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable {

	/**
	 * 返回信息
	 */
	private T data;

	/**
	 * 返回码
	 */
	private String code;

	/**
	 * 返回信息
	 */
	private String message;

	public static JsonResult<?> error(ExceptionEnum exception) {
		JsonResult<?> result = new JsonResult<>();
		result.setCode(exception.getCode());
		result.setData(null);
		result.setMessage(exception.getMsg());
		return result;
	}

	public static <T> JsonResult<T> success(T data) {
		return new JsonResult<>(data, "200", "成功");
	}
}
