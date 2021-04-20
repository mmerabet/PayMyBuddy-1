package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.ExternalTransferDto;
import com.steve.paymybuddy.dto.InternalTransferDto;
import com.steve.paymybuddy.dto.TransferDto;

import java.util.List;

public interface TransferService {
    List<TransferDto> findAll();

    InternalTransferDto doInternalTransfer(InternalTransferDto internalTransferDto);

    ExternalTransferDto doExternalTransfer(ExternalTransferDto externalTransferDto);
}
