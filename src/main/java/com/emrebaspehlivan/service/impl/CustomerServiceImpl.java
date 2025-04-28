package com.emrebaspehlivan.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoAccount;
import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoCustomer;
import com.emrebaspehlivan.dto.DtoCustomerIU;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
import com.emrebaspehlivan.model.Account;
import com.emrebaspehlivan.model.Address;
import com.emrebaspehlivan.model.Customer;
import com.emrebaspehlivan.repository.AccountRepository;
import com.emrebaspehlivan.repository.AddressRepository;
import com.emrebaspehlivan.repository.CustomerRepository;
import com.emrebaspehlivan.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {

        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
        }

        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if (optAccount.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCustomerIU, customer);
        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }

    @Override
    public DtoCustomer deleteCustomer(Long id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        if (optCustomer.isPresent()) {
            customerRepository.deleteById(id);
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(optCustomer.get(), dtoCustomer);
            return dtoCustomer;
        } else {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
    }

    @Override
    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        Optional<Customer> optCustomer = customerRepository.findById(id);
        if (optCustomer.isPresent()) {
            Customer customer = optCustomer.get();
            BeanUtils.copyProperties(dtoCustomerIU, customer);
            Customer updatedCustomer = customerRepository.save(customer);
            BeanUtils.copyProperties(updatedCustomer, dtoCustomer);
            return dtoCustomer;
        }
        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));

    }
}
