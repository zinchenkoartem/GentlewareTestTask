package com.artem.zinchenko.demo;

import com.artem.zinchenko.dao.IDao;
import com.artem.zinchenko.dao.impl.AccountDaoImpl;
import com.artem.zinchenko.dao.impl.ClientDaoImpl;
import com.artem.zinchenko.dao.impl.PaymentDaoImpl;
import com.artem.zinchenko.entity.Account;
import com.artem.zinchenko.entity.Client;
import com.artem.zinchenko.entity.Payment;
import com.artem.zinchenko.service.impl.ClientServiceImpl;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Demo {

    private ClientServiceImpl clientService;
    private EntityManagerFactory emf;
    private IDao<Account> accountIDao;
    private IDao<Client> clientIDao;
    private IDao<Payment> paymentIDao;
    private static final Logger logger = Logger.getLogger(Demo.class);

    public Demo(EntityManagerFactory emf){
        this.emf=emf;
        accountIDao = new AccountDaoImpl(emf);
        clientIDao = new ClientDaoImpl(emf);
        paymentIDao = new PaymentDaoImpl(emf);
    }

    public void run(){
        EntityManager em = emf.createEntityManager();
        logger.info("-------------------------");
        clientService = new ClientServiceImpl(clientIDao);
        Client clientWithMaxBalance = clientService.getClientWithMaxBalance(accountIDao.getAll());
        logger.info("Client With Max Balance:  " + clientWithMaxBalance);
        logger.info("-------------------------");

        logger.info(" ");
        logger.info("-------------------------");
        double clientBalance = clientService.getClientBalance(clientIDao.get(1), accountIDao.getAll());
        logger.info("Client ID1  Balance:  " + clientBalance);
        logger.info("-------------------------");


        em.close();
    }

}
