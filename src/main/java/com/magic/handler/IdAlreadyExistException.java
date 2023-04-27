package com.magic.handler;

public class IdAlreadyExistException extends RuntimeException {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public IdAlreadyExistException(String msg) {
	   super(msg);
   }
}
