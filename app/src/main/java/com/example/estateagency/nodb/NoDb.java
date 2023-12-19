package com.example.estateagency.nodb;

import com.example.estateagency.domain.Client;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.Realty;

import java.util.ArrayList;
import java.util.List;

public class NoDb {
    private NoDb(){

    }

    public static final List<Deal> DEAL_LIST = new ArrayList<>();
    public static final List<Client> CLIENT_LIST = new ArrayList<>();
    public static final List<Realtor> REALTOR_LIST = new ArrayList<>();
    public static final List<Realty> REALTY_LIST = new ArrayList<>();


}
