package com.emrebaspehlivan.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoGallerist;
import com.emrebaspehlivan.dto.DtoGalleristCar;
import com.emrebaspehlivan.dto.DtoGalleristCarIU;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
import com.emrebaspehlivan.model.Car;
import com.emrebaspehlivan.model.Gallerist;
import com.emrebaspehlivan.model.GalleristCar;
import com.emrebaspehlivan.repository.CarRepository;
import com.emrebaspehlivan.repository.GalleristCarRepository;
import com.emrebaspehlivan.repository.GalleristRepository;
import com.emrebaspehlivan.service.IGalleristCarService;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private CarRepository carRepository;

    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

        Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
        if (optGallerist.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getGalleristId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getCarId().toString()));
        }

        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleristCarIU, galleristCar);
        galleristCar.setGallerist(optGallerist.get());
        galleristCar.setCar(optCar.get());

        return galleristCar;
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();
        DtoAddress dtoAddress = new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));

        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.getGallerist().setAddress(dtoAddress);
        dtoGalleristCar.setCar(dtoCar);

        return dtoGalleristCar;
    }

    @Override
    public DtoGalleristCar deleteGalleristCar(Long id) {

        Optional<GalleristCar> optGalleristCar = galleristCarRepository.findById(id);
        if (optGalleristCar.isPresent()) {
            GalleristCar galleristCar = optGalleristCar.get();
            DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
            BeanUtils.copyProperties(galleristCar, dtoGalleristCar);
            galleristCarRepository.deleteById(id);
            return dtoGalleristCar;
        } else {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
    }

    @Override
    public DtoGalleristCar updateGalleristCar(Long id, DtoGalleristCarIU dtoGalleristCarIU) {
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        Optional<GalleristCar> optGalleristCar = galleristCarRepository.findById(id);
        if (optGalleristCar.isPresent()) {
            GalleristCar galleristCar = optGalleristCar.get();
            BeanUtils.copyProperties(dtoGalleristCarIU, galleristCar);
            GalleristCar updatedGalleristCar = galleristCarRepository.save(galleristCar);
            BeanUtils.copyProperties(updatedGalleristCar, dtoGalleristCar);
            return dtoGalleristCar;
        }
        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
    }

}
