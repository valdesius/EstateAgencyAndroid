package com.example.estateagency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.estateagency.rest.EstateAgencyApi;
import com.example.estateagency.rest.EstateAgencyApiVolley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EstateAgencyApiVolley(this).fillDeal();
    }
}