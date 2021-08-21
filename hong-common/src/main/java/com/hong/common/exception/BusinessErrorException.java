package com.hong.common.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * Description     :
 */
@Data
public class BusinessErrorException extends RuntimeException implements Serializable {
	private ExceptionEnum exceptionEnum;

	public BusinessErrorException(ExceptionEnum exceptionEnum) {
		this.exceptionEnum = exceptionEnum;
	}
}
