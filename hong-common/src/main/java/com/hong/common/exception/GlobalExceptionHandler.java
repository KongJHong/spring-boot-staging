package com.hong.common.exception;

import com.hong.common.bean.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description     : 全局异常处理类
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessErrorException.class)
	@ResponseStatus(value = HttpStatus.OK)
	public JsonResult<?> handleCustomException(BusinessErrorException ex) {
		return JsonResult.error(ex.getExceptionEnum());
	}


	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public JsonResult<?> handleHttpMessageNotReadableException(
			MissingServletRequestParameterException ex) {
		log.error("缺少请求参数：{}", ex.getMessage());
		return JsonResult.error(ExceptionEnum.PARAMETER_MISSING_EXCEPTION);
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public JsonResult<?> handleUnexpectedServer(Exception ex) {
		log.error("系统异常:", ex);
		return JsonResult.error(ExceptionEnum.UNEXPECTED_EXCEPTION);
	}
}
