package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankAccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BankAccountService bankAccountService;

    @Test
    void getBankAccount() throws Exception {

        // Etape 1 : on envoie une requête GET
        // + on vérifie que le statut de la réponse est 200

        mockMvc.perform(MockMvcRequestBuilders.get("/BankAccount"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Etape 2 : on vérifie que le service a bien été appelé avec les bons
        // paramètres

        Mockito.verify(bankAccountService, Mockito.times(1)).findAll();

    }
}
