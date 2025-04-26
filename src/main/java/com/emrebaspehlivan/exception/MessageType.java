package com.emrebaspehlivan.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1001","kayıt bulunamadı"),
	TOKEN_IS_EXPIRED("1002","tokenın süresi bitmiştir"),
	USERNAME_NOT_FOUND("1003","username bulunumadı"),
	GENERAL_EXCEPTION("9999" , "genel bir hata oluştu");
	
	private String code;
	private String message;

	

	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
