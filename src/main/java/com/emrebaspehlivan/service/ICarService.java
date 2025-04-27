package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);

    public DtoCar deleteCar(Long id);

    public DtoCar updateCar(Long id, DtoCarIU dtoCarIU);
}
