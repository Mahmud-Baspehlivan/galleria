package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoGallerist;
import com.emrebaspehlivan.dto.DtoGalleristIU;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);

    public RootEntity<Boolean> deleteGallerist(Long id);

    public RootEntity<DtoGallerist> updateGallerist(Long id, DtoGalleristIU dtoGalleristIU);
}
