package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Date;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    Date dateTest = new Date();

    String firstNameTest = "john";
    String lastNameTest = "wick";
    String emailTest = "john@gmail.com";
    String password = "123";
    BigDecimal balance;
    Date createDate = dateTest;
    User pierre  = new User();
    User stephane  = new User();

    @Test
    void getUsers() throws Exception {

        // Etape 1 : on envoie une requête GET
        // + on vérifie que le statut de la réponse est 200

        mockMvc.perform(MockMvcRequestBuilders.get("/Users"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Etape 2 : on vérifie que le service a bien été appelé avec les bons
        // paramètres

        Mockito.verify(userService, Mockito.times(1)).findAll();

    }

    @Test
    void getCountUsers() throws Exception{


        // Etape 1 : on envoie une requête GET
        // + on vérifie que le statut de la réponse est 200

        mockMvc.perform(MockMvcRequestBuilders.get("/UsersCount"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Etape 2 : on vérifie que le service a bien été appelé avec les bons
        // paramètres

        Mockito.verify(userService, Mockito.times(1)).countUsers();
    }

    @Test
    void getUserByEmail() throws Exception{


        // Etape 1 : on envoie une requête GET
        // + on vérifie que le statut de la réponse est 200

        mockMvc.perform(MockMvcRequestBuilders.get("/Users/"+emailTest))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Etape 2 : on vérifie que le service a bien été appelé avec les bons
        // paramètres

        Mockito.verify(userService, Mockito.times(1)).userByEmail(emailTest);
    }

}
