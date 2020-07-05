package com.demo.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * page search entity
 * @author Larry_lee
 * @since 2020-07-04
 * @param <T>
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class PageSearchEntity<T> extends PageSupport<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T condition;
}
