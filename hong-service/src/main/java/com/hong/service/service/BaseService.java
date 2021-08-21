package com.hong.service.service;

/**
 * Description     :
 */
public interface BaseService {

	public default boolean insertBatch() {
		return false;
	}
}
