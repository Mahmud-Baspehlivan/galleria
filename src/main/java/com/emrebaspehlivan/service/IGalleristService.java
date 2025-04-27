package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoGallerist;
import com.emrebaspehlivan.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);

    public DtoGallerist deleteGallerist(Long id);

    public DtoGallerist updateGallerist(Long id, DtoGalleristIU dtoGalleristIU);
}
