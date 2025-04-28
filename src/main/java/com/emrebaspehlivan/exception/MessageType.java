package com.emrebaspehlivan.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1001", "kayıt bulunamadı"),
	TOKEN_IS_EXPIRED("1002", "tokenın süresi bitmiştir"),
	USERNAME_NOT_FOUND("1003", "username bulunumadı"),
	USERNAME_OR_PASSWORD_INVALID("1004", "kullanıcı adı yada şifre hatalı"),
	REFRESH_TOKEN_NOT_FOUND("1005", "refresh token bulunamadı"),
	REFRESH_TOKEN_IS_EXPIRED("1006", "refresh tokenın süresi  bitmiştir"),
	CURRENCY_RATE_IS_OCCURED("1007", "döviz kuru alınamdı"),
	NOT_ENOUGH_MONEY("1008", "yetersiz bakiye"),
	CAR_STATUS_IS_ALREADY_SALED("1009", "araba zaten satılmış"),
	GENERAL_EXCEPTION("9999", "genel bir hata oluştu");

	private String code;
	private String message;

	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
