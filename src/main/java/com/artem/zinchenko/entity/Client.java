package com.artem.zinchenko.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
@NamedQuery(name = "Client.getAll", query = "SELECT  cl  from Client cl ")
public class Client implements Serializable {

    @Id
    @Column(name = "id")
    private long id_client;
    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @OneToMany(mappedBy ="client", fetch = FetchType.LAZY)
    private List<Account> accountList;
    @OneToMany(mappedBy ="client", fetch = FetchType.LAZY)
    private List<Payment> paymentList;


    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return (int)((id_client >> 32) ^ id_client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id_client != client.id_client) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Client:"+getFirstName()+" " +getLastName()+".  ID:" +getId_client()+ "   \nAccounts:" +accountList
                + "\nPayments: "+paymentList;
    }
}
