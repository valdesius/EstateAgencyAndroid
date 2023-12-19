package com.example.estateagency;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.estateagency.domain.Client;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.Realty;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.domain.enums.RealtyEnum;
import com.example.estateagency.rest.EstateAgencyApi;
import com.example.estateagency.rest.EstateAgencyApiVolley;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EstateAgencyApiVolley(this).fillDeal();
        new EstateAgencyApiVolley(this).addDeal(
                new Deal(LocalDate.now(), DealEnum.RENT,
                        new Client("Cname", "978978", "wlcwcc@q.ru"),
                        new Realtor("Rname", "76787", "cwcwcc@cc.ty"),
                        new Realty("address", RealtyEnum.APARTMENT, 36, 3000)));
    }
}