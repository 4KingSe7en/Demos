package com.demo.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * resp for page
 * @author Larry_lee
 * @since 2020-07-04
 * @param <T>
 *
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class PageResultEntity<T> extends PageSupport<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T data;
	
	private int total;
	
	public PageResultEntity() {
		
	}
	
	public PageResultEntity(T data ,int total) { 
		this.data = data;
		this.total = total;
	}
	
	public PageResultEntity(int pageNum,int pageSize,T data ,int total) { 
		this.data = data;
		this.total = total;
		this.setPageNum(pageNum);
		this.setPageSize(pageSize);
	}
	

}
