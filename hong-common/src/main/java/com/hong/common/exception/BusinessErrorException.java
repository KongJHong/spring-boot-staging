package com.hong.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Description     :
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessErrorException extends RuntimeException implements Serializable {
	private ExceptionEnum exceptionEnum;

	public BusinessErrorException(ExceptionEnum exceptionEnum) {
		this.exceptionEnum = exceptionEnum;
	}
}
