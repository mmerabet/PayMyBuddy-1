package com.steve.paymybuddy;

import com.steve.paymybuddy.dao.ExternalTransferDao;
import com.steve.paymybuddy.dao.InternalTransferDao;
import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class PaymybuddyApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(PaymybuddyApplication.class, args);

        //Test connection JPA
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println("list des users " + userDao.findAll());

        //Test liaison entre user et bankAccount
        List<User> users = userDao.findAll();
//        System.out.println("iban1 : " + users.get(0).getBankAccounts().get(0).getIban());

        //test transfert
        ExternalTransferDao externalTransferDao = context.getBean(ExternalTransferDao.class);
        System.out.println("description 1er externaltransfer " + externalTransferDao.findAll().get(0).getDescription());

        InternalTransferDao internalTransferDao = context.getBean(InternalTransferDao.class);
        System.out.println("description 1er internaltransfer " + internalTransferDao.findAll().get(0).getDescription());

        //test relation
        System.out.println(userDao.findAll().get(0).getRelations().get(0));

    }
}
