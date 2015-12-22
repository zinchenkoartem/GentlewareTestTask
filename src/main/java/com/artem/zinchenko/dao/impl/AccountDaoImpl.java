package com.artem.zinchenko.dao.impl;

import com.artem.zinchenko.dao.IDao;
import com.artem.zinchenko.entity.Account;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDaoImpl implements IDao<Account> {

    private EntityManagerFactory emf;
    public AccountDaoImpl (EntityManagerFactory emf){
        this.emf=emf;
    }


    @Override
    public Account get(long id) {
        return emf.createEntityManager().find(Account.class, id);
    }

    @Override
    public List<Account> getAll() {
        TypedQuery namedQuery = emf.createEntityManager().createNamedQuery("Account.getAll",Account.class);
        return namedQuery.getResultList();
    }

}
