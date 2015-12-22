package com.artem.zinchenko.dao.impl;

import com.artem.zinchenko.dao.IDao;
import com.artem.zinchenko.entity.Client;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDaoImpl implements IDao<Client> {

    private EntityManagerFactory emf;

    public ClientDaoImpl(EntityManagerFactory emf){
        this.emf=emf;
    }

    @Override
    public Client get( long id) {
     return emf.createEntityManager().find(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        TypedQuery namedQuery = emf.createEntityManager().createNamedQuery("Client.getAll",Client.class);
        return namedQuery.getResultList();
    }


}
