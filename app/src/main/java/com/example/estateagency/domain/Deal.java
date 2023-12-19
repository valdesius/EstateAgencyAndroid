package com.example.estateagency.domain;

import com.example.estateagency.domain.enums.DealEnum;

import java.io.Serializable;
import java.time.LocalDate;

public class Deal implements Serializable {

    private int id;

    private LocalDate date;

    private DealEnum type;

    private Client client;

    private Realtor realtor;

    private Realty realty;

    public Deal(LocalDate date, DealEnum type, Client client, Realtor realtor, Realty realty) {
        this.date = date;
        this.type = type;
        this.client = client;
        this.realtor = realtor;
        this.realty = realty;
    }

    public Deal(int id, LocalDate date, DealEnum type, Client client, Realtor realtor, Realty realty) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.client = client;
        this.realtor = realtor;
        this.realty = realty;
    }



    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public DealEnum getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public Realty getRealty() {
        return realty;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", date=" + date +
                ", type=" + type +
                ", client=" + client +
                ", realtor=" + realtor +
                ", realty=" + realty +
                '}';
    }
}
