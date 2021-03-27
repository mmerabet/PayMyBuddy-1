package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.TransferDto;
import com.steve.paymybuddy.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping(value = "/Transfer")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferDto> transfer() {
        return transferService.findAll();
    }

}
