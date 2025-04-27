package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestGalleristController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoGallerist;
import com.emrebaspehlivan.dto.DtoGalleristIU;
import com.emrebaspehlivan.service.IGalleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristController extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<Boolean> deleteGallerist(@PathVariable Long id) {
        galleristService.deleteGallerist(id);
        return ok(true);
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoGallerist> updateGallerist(@PathVariable Long id,
            @Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.updateGallerist(id, dtoGalleristIU));
    }
}
