package com.example.estateagency;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.estateagency.adapter.DealAdapter;
import com.example.estateagency.domain.Client;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.Realty;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.domain.enums.RealtyEnum;
import com.example.estateagency.nodb.NoDb;
import com.example.estateagency.rest.EstateAgencyApi;
import com.example.estateagency.rest.EstateAgencyApiVolley;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDeal;
    private DealAdapter dealAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EstateAgencyApiVolley(this).fillDeal();

        rvDeal = findViewById(R.id.rv_deal);
        dealAdapter = new DealAdapter(this, NoDb.DEAL_LIST);
        rvDeal.setAdapter(dealAdapter);


    }

    public void updateAdapter() {
        dealAdapter.notifyDataSetChanged();
    }
}