package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoSaledCar;
import com.emrebaspehlivan.dto.DtoSaledCarIU;

public interface IRestSaledCarController {
    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
