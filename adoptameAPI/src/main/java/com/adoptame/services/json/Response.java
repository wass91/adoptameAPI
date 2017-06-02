package com.adoptame.services.json;

import java.io.Serializable;

public class Response implements Serializable{
	
	private static final long serialVersionUID = -3117073258272285221L;

	private Object items;
	
	private boolean success = true;
	
	private String message = null;

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
