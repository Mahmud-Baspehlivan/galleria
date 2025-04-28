package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoSaledCar;
import com.emrebaspehlivan.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}