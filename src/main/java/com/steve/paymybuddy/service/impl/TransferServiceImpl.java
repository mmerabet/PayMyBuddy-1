package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.dao.TransferDao;
import com.steve.paymybuddy.dto.TransferDto;
import com.steve.paymybuddy.model.Transfer;
import com.steve.paymybuddy.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferDao transferDao;


    @Override
    public List<TransferDto> findAll() {

        List<TransferDto> transferDtos = new ArrayList<>();
        List<Transfer> transfers = transferDao.findAll();

        for (Transfer transfer : transfers) {
            TransferDto transferDto = new TransferDto();
            transferDto.setAmount(transfer.getAmount());
            transferDto.setDescription(transfer.getDescription());
            transferDto.setId(transfer.getId());
            transferDto.setStatus(transfer.getStatus());
            transferDto.setTransactionDate(transfer.getTransactionDate());

            transferDtos.add(transferDto);
        }
        return transferDtos;
    }
}
