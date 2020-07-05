package com.demo.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author Larry_lee
 * @since 2020-07-04
 */
@Data
public class PageSupport<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize;

	private int pageNum;
	

}
