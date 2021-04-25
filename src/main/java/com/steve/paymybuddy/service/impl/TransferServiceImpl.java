package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.dao.RelationDao;
import com.steve.paymybuddy.dao.TransferDao;
import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.dto.ExternalTransferDto;
import com.steve.paymybuddy.dto.InternalTransferDto;
import com.steve.paymybuddy.dto.TransferDto;
import com.steve.paymybuddy.model.InternalTransfer;
import com.steve.paymybuddy.model.Relation;
import com.steve.paymybuddy.model.Transfer;
import com.steve.paymybuddy.service.TransferService;
import com.steve.paymybuddy.web.exception.DataNotExistException;
import com.steve.paymybuddy.web.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferDao transferDao;
    private final UserDao userDao;
    private final RelationDao relationDao;

    @Autowired
    public TransferServiceImpl(TransferDao transferDao, UserDao userDao, RelationDao relationDao) {
        this.transferDao = transferDao;
        this.userDao = userDao;
        this.relationDao = relationDao;
    }

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

    @Override
    public InternalTransferDto doInternalTransfer(InternalTransferDto internalTransferDto) {
        //recuperation de la relation entre les 2 users (sa nous check aussi leur existence)
        Relation relation = relationDao.findByOwner_EmailAndBuddy_Email(internalTransferDto.getEmailSender(),internalTransferDto.getEmailReceiver());
        // on verifie leur amitié
        if (relation == null) {
            throw new DataNotFoundException("les 2 users ne sont pas ami");
        }
        // on check si le sender à assez d'argent pour la transaction
        if (internalTransferDto.getAmount().compareTo(relation.getOwner().getBalance())>0) {
            throw new DataNotExistException("fonds insuffisants");
        }
        InternalTransfer internalTransfer = new InternalTransfer();
        internalTransfer.setUserSender(relation.getOwner());
        internalTransfer.setUserReceiver(relation.getBuddy());
        internalTransfer.setStatus("Completed");
        internalTransfer.setAmount(internalTransferDto.getAmount());
        internalTransfer.setDescription(internalTransferDto.getDescription());
        internalTransfer.setTransactionDate(Timestamp.valueOf(LocalDateTime.now()));
        transferDao.save(internalTransfer);
        internalTransferDto.setId(internalTransfer.getId());
        // on met a jours les balance des 2 users

        relation.getOwner().setBalance(relation.getOwner().getBalance().subtract(internalTransferDto.getAmount()));
        relation.getBuddy().setBalance(relation.getBuddy().getBalance().add(internalTransferDto.getAmount()));
        userDao.save(relation.getOwner());
        userDao.save(relation.getBuddy());

        return internalTransferDto;
    }

    @Override
    public ExternalTransferDto doExternalTransfer(ExternalTransferDto externalTransferDto) {
        // je recupere l'user par son email dans le dto
        // je check si il est present dans la base
        // je check si le
        String email = externalTransferDto.getEmailUser();
        if (!userDao.existsByEmail(email)) {
            throw new DataNotFoundException("email non present");
        }
//        if (externalTransferDto.getIbanUser()) {
//
        return null;
//        }
    }
}

