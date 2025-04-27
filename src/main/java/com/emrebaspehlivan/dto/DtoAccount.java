package com.emrebaspehlivan.dto;

import java.math.BigDecimal;

import com.emrebaspehlivan.enums.CurrencyType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class DtoAccount extends DtoBase {

	private String accountNo;

	private String iban;

	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
}
