package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoGalleristCar;
import com.emrebaspehlivan.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);

    public DtoGalleristCar deleteGalleristCar(Long id);

    public DtoGalleristCar updateGalleristCar(Long id, DtoGalleristCarIU dtoGalleristCarIU);
}
