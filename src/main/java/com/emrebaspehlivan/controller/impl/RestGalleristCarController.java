package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestGalleristCarController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoGalleristCar;
import com.emrebaspehlivan.dto.DtoGalleristCarIU;
import com.emrebaspehlivan.service.IGalleristCarService;

import jakarta.validation.Valid;

@RequestMapping("/rest/api/galleristcar")
@RestController
public class RestGalleristCarController extends RestBaseController implements IRestGalleristCarController {

    @Autowired
    private IGalleristCarService galleristCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
        return ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<Boolean> deleteGalleristCar(@PathVariable Long id) {
        galleristCarService.deleteGalleristCar(id);
        return ok(true);
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoGalleristCar> updateGalleristCar(@PathVariable Long id,
            @Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
        return ok(galleristCarService.updateGalleristCar(id, dtoGalleristCarIU));
    }

}
