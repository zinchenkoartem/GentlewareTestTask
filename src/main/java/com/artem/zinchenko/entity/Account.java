package com.artem.zinchenko.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "account")
@NamedQuery(name = "Account.getAll", query = "SELECT  a  from Account a ")
public class Account  implements Serializable, Comparable<Account>{
    @Id
    @Column(name = "id")
    private long id_account;
    @Column(name = "id_client")
    private long id_client;
    @Column(name = "balance")
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_client", insertable =false, updatable = false)
    private Client client;

    @OneToMany(mappedBy ="from_account", fetch = FetchType.LAZY)
    private List<Payment> payment_from_accountList;

    @OneToMany(mappedBy ="to_account", fetch = FetchType.LAZY)
    private List<Payment> payment_to_accountList;


    public List<Payment> getPayment_to_accountList() {
        return payment_to_accountList;
    }

    public void setPayment_to_accountList(List<Payment> paymen_to_accountList) {
        this.payment_to_accountList = paymen_to_accountList;
    }

    public List<Payment> getPayment_from_accountList() {
        return payment_from_accountList;
    }

    public void setPayment_from_accountList(List<Payment> paymen_from_accountList) {
        this.payment_from_accountList = paymen_from_accountList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId_account() {
        return id_account;
    }

    public void setId_account(long id_account) {
        this.id_account = id_account;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id_account != account.id_account) return false;
        if (balance != account.balance) return false;
        if (id_client != account.id_client) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id_account ^ (id_account >>> 32));
    }

    @Override
    public String toString() {
        return "AccountID:" +getId_account()+ " Balance:" +getBalance() +" OwnerID:" +getId_client();
    }

    @Override
    public int compareTo(Account o) {
        return Double.compare(this.getBalance(), o.getBalance() );
    }
}
