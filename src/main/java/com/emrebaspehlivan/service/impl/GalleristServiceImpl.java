package com.emrebaspehlivan.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoGallerist;
import com.emrebaspehlivan.dto.DtoGalleristIU;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
import com.emrebaspehlivan.model.Address;
import com.emrebaspehlivan.model.Gallerist;
import com.emrebaspehlivan.repository.AddressRepository;
import com.emrebaspehlivan.repository.GalleristRepository;
import com.emrebaspehlivan.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
        Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
        }
        Gallerist gallerist = new Gallerist();
        gallerist.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(optAddress.get());
        return gallerist;
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {

        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);

        return dtoGallerist;
    }

    @Override
    public DtoGallerist deleteGallerist(Long id) {
        Optional<Gallerist> optGallerist = galleristRepository.findById(id);
        if (optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist gallerist = optGallerist.get();
        BeanUtils.copyProperties(gallerist, dtoGallerist);
        BeanUtils.copyProperties(gallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);

        galleristRepository.deleteById(id);

        return dtoGallerist;
    }

    @Override
    public DtoGallerist updateGallerist(Long id, DtoGalleristIU dtoGalleristIU) {

        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Gallerist> optGallerist = galleristRepository.findById(id);
        if (optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        if (dtoGalleristIU.getAddressId() != null) {
            Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
            if (optAddress.isEmpty()) {
                throw new BaseException(
                        new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
            }
            optGallerist.get().setAddress(optAddress.get());
        }

        Gallerist gallerist = optGallerist.get();

        BeanUtils.copyProperties(dtoGalleristIU, gallerist, "addressId");

        Gallerist updatedGallerist = galleristRepository.save(gallerist);

        BeanUtils.copyProperties(updatedGallerist, dtoGallerist);
        BeanUtils.copyProperties(updatedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);

        return dtoGallerist;
    }

}
