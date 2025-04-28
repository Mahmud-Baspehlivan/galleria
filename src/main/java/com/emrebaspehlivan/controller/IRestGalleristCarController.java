package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoGalleristCar;
import com.emrebaspehlivan.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);

    public RootEntity<Boolean> deleteGalleristCar(Long id);

    public RootEntity<DtoGalleristCar> updateGalleristCar(Long id, DtoGalleristCarIU dtoGalleristCarIU);
}
