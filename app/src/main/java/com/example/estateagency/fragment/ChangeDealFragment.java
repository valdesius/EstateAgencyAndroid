package com.example.estateagency.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.estateagency.R;
import com.example.estateagency.adapter.DealAdapter;
import com.example.estateagency.domain.Deal;

public class ChangeDealFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_deal, container, false);
        Deal deal = (Deal) getArguments().getSerializable(DealAdapter.DEAL_KEY);
        Toast.makeText(getContext(), deal.toString(), Toast.LENGTH_LONG).show();
        return view;


    }
}