package com.demo.param;

import lombok.Data;

/**
 * 
 * @author Larry_lee
 * @since 2020-07-04
 */
@Data
public class PageSupport<T> {

	private int pageSize;

	private int pageNum;

}
