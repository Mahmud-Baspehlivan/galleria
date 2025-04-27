package com.emrebaspehlivan.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoCarIU;
import com.emrebaspehlivan.model.Car;
import com.emrebaspehlivan.repository.CarRepository;
import com.emrebaspehlivan.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {

        DtoCar dtoCar = new DtoCar();

        Car savedCar = carRepository.save(createCar(dtoCarIU));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }

    @Override
    public DtoCar deleteCar(Long id) {
        carRepository.deleteById(id);
        DtoCar dtoCar = new DtoCar();
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            BeanUtils.copyProperties(car, dtoCar);
        }
        return dtoCar;
    }

    @Override
    public DtoCar updateCar(Long id, DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            BeanUtils.copyProperties(dtoCarIU, car);
            Car updatedCar = carRepository.save(car);
            BeanUtils.copyProperties(updatedCar, dtoCar);
        }
        return dtoCar;
    }

}
