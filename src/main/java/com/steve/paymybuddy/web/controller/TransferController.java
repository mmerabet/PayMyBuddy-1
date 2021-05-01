package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.ExternalTransferDto;
import com.steve.paymybuddy.dto.InternalTransferDto;
import com.steve.paymybuddy.dto.TransferDto;
import com.steve.paymybuddy.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

//@RestController
@Controller
public class TransferController {

    @Autowired
    TransferService transferService;
    @Autowired
    UserController userController;

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping(value = "/Transferu")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferDto> transfer() {
        return transferService.findAll();
    }

    @GetMapping("/transfer")
    public String helloa(Model model){
        model.addAttribute("transfers", transfer());
        model.addAttribute("users", userController.users());
        return "transfer";
    }

    @PostMapping(value = "/Transfer/internal")
    @ResponseStatus(HttpStatus.CREATED)
    public InternalTransferDto doInternalTransfer(@RequestBody InternalTransferDto internalTransferDto) {
       return transferService.doInternalTransfer(internalTransferDto);
    }

    @PostMapping(value= "/Transfer/external")
    @ResponseStatus(HttpStatus.CREATED)
    public ExternalTransferDto doExternalTransfer(@RequestBody ExternalTransferDto externalTransferDto) {
        return transferService.doExternalTransfer(externalTransferDto);
    }
}

