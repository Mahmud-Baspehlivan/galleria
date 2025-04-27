package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

    public RootEntity<Boolean> deleteCar(Long id);

    public RootEntity<DtoCar> updateCar(Long id, DtoCarIU dtoCarIU);
}
