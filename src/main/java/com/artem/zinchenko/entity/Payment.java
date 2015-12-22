package com.artem.zinchenko.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "payment")
@NamedQuery(name = "Payment.getAll", query = "SELECT  p  from Payment p ")
public class Payment  implements Serializable{
    @Id
    @Column(name = "id")
    private  long id_payment;

    @Column(name = "sum")
    private double sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="from_account")
    private Account from_account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="to_account")
    private Account to_account;

    public Account getTo_account() {
        return to_account;
    }

    public void setTo_account(Account to_account) {
        this.to_account = to_account;
    }

    public Account getFrom_account() {
        return from_account;
    }

    public void setFrom_account(Account from_account) {
        this.from_account = from_account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId_payment() {
        return id_payment;
    }

    public void setId_payment(long id_payment) {
        this.id_payment = id_payment;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (from_account != payment.from_account) return false;
        if (id_payment != payment.id_payment) return false;
        if (Double.compare(payment.sum, sum) != 0) return false;
        if (to_account != payment.to_account) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id_payment ^ (id_payment >>> 32));
    }

    @Override
    public String toString() {
        return "Payment:" +
                "ID: " + id_payment +
                ", From account: " + from_account +
                ", To account: " + to_account +
                ", Sum:" + sum;
    }
}
