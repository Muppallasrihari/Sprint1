package com.cg.healthify.exceptions;

public class NoRecordFoundException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoRecordFoundException(String errMsg){
			super(errMsg);
		}
	 public NoRecordFoundException(){
			super();
		}
}
