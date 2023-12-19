package com.example.estateagency.domain;

import com.example.estateagency.domain.enums.RealtyEnum;

public class Realty {

    private int id;

    private String address;


    private RealtyEnum type;

    private int area;

    private int price;

    public Realty(String address, RealtyEnum type, int area, int price) {
        this.address = address;
        this.type = type;
        this.area = area;
        this.price = price;
    }

    public Realty(int id, String address, RealtyEnum type, int area, int price) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.area = area;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public RealtyEnum getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Realty{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
