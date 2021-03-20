//package com.steve.paymybuddy.dao;
//
//import com.steve.paymybuddy.model.*;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Date;
//
//
//public class CreateUser {
//    public static void main(String[] args) {
//
//        // create session factory
//        SessionFactory factory1 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(BankAccount.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
////
//              // create session factory
//        SessionFactory factory2 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(ExternalTransfer.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
////
////              // create session factory
//        SessionFactory factory3 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(InternalTransfer.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
////
////              // create session factory
//        SessionFactory factory4 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Relation.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
////
////              // create session factory
//        SessionFactory factory5 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Transfer.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
////
//              // create session factory
//        SessionFactory factory6 = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();
//        System.out.println("Hibernate Configuration loaded");
//
//        // create session
//        Session session1 = factory1.getCurrentSession();
//        Session session2 = factory2.getCurrentSession();
//        Session session3 = factory3.getCurrentSession();
//        Session session4 = factory4.getCurrentSession();
//        Session session5 = factory5.getCurrentSession();
//        Session session6 = factory6.getCurrentSession();
//
//        try{
//
//            // create a student object
//            System.out.println("Creation du nouveau User object");
//            Date date = new Date();
////            User tempUser = new User("johnathan", "Soe", "jonathan@hotmail.com", "12345", 800.00, date);
////            Relation relation = new Relation(1,3);
////            Transfer transfer = new Transfer(20, "loyer", date, "COMPLETED");
////            BankAccount bankAccount = new BankAccount("ibanJoseh","BICFally","LaPoste", "compteEpargneJoseph",3);
////            InternalTransfer internalTransfer = new InternalTransfer(3, 2, 1);
////            ExternalTransfer externalTransfer = new ExternalTransfer(3,20.00, "ibanJoseh");
//            //start a transaction
//            session1.beginTransaction();
//            session2.beginTransaction();
//            session3.beginTransaction();
//            session4.beginTransaction();
//            session5.beginTransaction();
//            session6.beginTransaction();
//
//
////            //save the student  object
//            System.out.println("Saving the User ..");
//            session1.save(bankAccount);
//            session2.save(externalTransfer);
//            session3.save(internalTransfer);
//            session4.save(relation);
//            session5.save(transfer);
//            session6.save(tempUser);
//
//
//
////            //commit transaction
////            session1.getTransaction().commit();
////            session2.getTransaction().commit();
////            session3.getTransaction().commit();
////            session4.getTransaction().commit();
////            session5.getTransaction().commit();
//            session6.getTransaction().commit();
//            System.out.println("Done");
//        }
//        finally {
//            factory1.close();
//            factory2.close();
//            factory3.close();
//            factory4.close();
//            factory5.close();
//            factory6.close();
//        }
//    }
//}
