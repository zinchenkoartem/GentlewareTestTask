package com.artem.zinchenko.dao.impl;

import com.artem.zinchenko.dao.IDao;
import com.artem.zinchenko.entity.Account;
import com.artem.zinchenko.entity.Payment;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentDaoImpl implements IDao<Payment> {

    private EntityManagerFactory emf;

    public PaymentDaoImpl(EntityManagerFactory emf){
        this.emf=emf;
    }

    @Override
    public Payment get(long id) {
        return emf.createEntityManager().find(Payment.class, id);
    }

    @Override
    public List<Payment> getAll() {
        TypedQuery namedQuery = emf.createEntityManager().createNamedQuery("Payment.getAll",Payment.class);
        return namedQuery.getResultList();
    }
}
