package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.TransferDto;

import java.util.List;

public interface TransferService {
    List<TransferDto> findAll();
}
