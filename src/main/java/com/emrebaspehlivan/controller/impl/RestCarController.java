package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestCarController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoCarIU;
import com.emrebaspehlivan.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarController extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<Boolean> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ok(true);
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoCar> updateCar(@PathVariable Long id,
            @Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.updateCar(id, dtoCarIU));
    }
}
