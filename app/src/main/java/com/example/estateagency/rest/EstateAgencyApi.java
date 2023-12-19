package com.example.estateagency.rest;

import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.domain.enums.RealtyEnum;

import java.time.LocalDate;

public interface EstateAgencyApi {

    void fillDeal();

    void fillClient();

    void fillRealtor();

    void fillRealty();

    void addDeal(Deal deal);

    void updateDeal(
            int id,
            LocalDate date,
            DealEnum type,
            String clientName,
            String clientPhone,
            String clientEmail,
            String realtorName,
            String realtorPhone,
            String realtorEmail,
            String realtyAddress,
            RealtyEnum realtyType,
            int area,
            int price);

    void deleteDeal(int id);
}
