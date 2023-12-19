package com.example.estateagency.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.estateagency.R;
import com.example.estateagency.adapter.ClientSpinnerAdapter;
import com.example.estateagency.adapter.RealtorSpinnerAdapter;
import com.example.estateagency.adapter.RealtySpinnerAdapter;
import com.example.estateagency.domain.Client;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.nodb.NoDb;
import com.example.estateagency.rest.EstateAgencyApiVolley;


public class AddDealFragment extends Fragment {

    private AppCompatSpinner spClient, spRealtor, spRealty;
    private ClientSpinnerAdapter clientSpinnerAdapter;
    private RealtorSpinnerAdapter realtorSpinnerAdapter;
    private RealtySpinnerAdapter realtySpinnerAdapter;

    private EditText etDealDate;
    private AppCompatButton btnAdd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_deal, container, false);
        spClient = view.findViewById(R.id.sp_client);
        spRealtor = view.findViewById(R.id.sp_realtor);
        btnAdd = view.findViewById(R.id.btn_add);
        etDealDate = view.findViewById(R.id.et_deal_date);
        clientSpinnerAdapter = new ClientSpinnerAdapter(getContext(), NoDb.CLIENT_LIST);
        realtorSpinnerAdapter = new RealtorSpinnerAdapter(getContext(), NoDb.REALTOR_LIST);

        spClient.setAdapter(clientSpinnerAdapter);
        spRealtor.setAdapter(realtorSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EstateAgencyApiVolley(getContext()).addDeal(
                        new Deal(
                                etDealDate.getText().toString(),

                                ((Client) spClient.getSelectedItem()),
                                ((Realtor) spRealtor.getSelectedItem())
                        )
                );
            }
        });
        return view;
    }
}