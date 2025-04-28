package com.emrebaspehlivan.dto;

import lombok.Data;

@Data
public class DtoSaledCar extends DtoBase {

    private DtoCustomer customer;

    private DtoCar car;

    private DtoGallerist gallerist;
}
