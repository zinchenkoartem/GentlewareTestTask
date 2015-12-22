package com.artem.zinchenko.service.impl;

import com.artem.zinchenko.dao.IDao;
import com.artem.zinchenko.entity.Account;
import com.artem.zinchenko.entity.Client;
import com.artem.zinchenko.service.IClientService;
import java.util.*;
import java.util.stream.Collectors;

public class ClientServiceImpl implements IClientService {

    private IDao<Client> clientDao;

    public ClientServiceImpl(IDao<Client> dao){
        clientDao=dao;
    }

    @Override
    public double getClientBalance(Client client, List<Account> accounts) {
        double balance=0;
        for(Account a: accounts) {
            if (client.getId_client() == a.getId_client()) {
                balance += a.getBalance();
            }
        }
        return balance;
    }

    @Override
    public Client getClientWithMaxBalance(List<Account> accounts) {

        HashSet<Long> id_client_set = new HashSet<>(); //множество всех Id клиентов
        HashMap<Long, Double> map = new HashMap<>(); //  ключ- id клиента, value - сумма всех его счетов
        id_client_set.addAll(accounts.stream().map(Account::getId_account).collect(Collectors.toList())); // выбираем все id клинтов из колекции
        for (Long id: id_client_set){
            List<Account> result = accounts.stream().filter(p -> p.getId_client()==id).collect(Collectors.toList()); // выбираем все счета для  каждого клиента
            Double  sum=0.0;
            for(Account a: result){  // суммируем все его счета
                sum+=a.getBalance();
            }
            map.put(id, sum);  //запоминаем
        }
        Long idClientMaxBalance = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey(); //находим  id c максимальной суммой
        clientDao.get(idClientMaxBalance);
        return clientDao.get(idClientMaxBalance);
    }

}
