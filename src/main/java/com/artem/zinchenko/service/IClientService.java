package com.artem.zinchenko.service;

import com.artem.zinchenko.entity.Account;
import com.artem.zinchenko.entity.Client;

import java.util.List;

public interface IClientService {
    double getClientBalance(Client client, List<Account> accounts);
    Client getClientWithMaxBalance(List<Account> accounts);
}

