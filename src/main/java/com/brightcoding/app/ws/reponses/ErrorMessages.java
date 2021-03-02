package com.brightcoding.app.ws.reponses;

public enum ErrorMessages {
	
	MISSING_REQUIERD_FIELD("missing required field"),
	
	RECORD_ALREADY_EXISTS("record already exists"),
	
	INTERNAL_SERVER_ERROR("internal server error"),
	
	NO_RECORD_FOUND("Record with provided id is not found");
	
	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	
	
}
