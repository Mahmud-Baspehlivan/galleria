package com.emrebaspehlivan.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoCar;
import com.emrebaspehlivan.dto.DtoCarIU;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
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
        if (id == null) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Null ID provided"));
        }

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));

        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(car, dtoCar);

        carRepository.deleteById(id);

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
        } else {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        return dtoCar;
    }

}
