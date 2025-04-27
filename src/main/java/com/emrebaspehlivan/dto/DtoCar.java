package com.emrebaspehlivan.dto;

import java.math.BigDecimal;

import com.emrebaspehlivan.enums.CarStatusType;
import com.emrebaspehlivan.enums.CurrencyType;

import lombok.Data;

@Data
public class DtoCar extends DtoBase{

	private String plaka;
	
	private String brand;
	
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	
	private CurrencyType currencyType;
	
	private BigDecimal damagePrice;
	
	private CarStatusType carStatusType;
}
