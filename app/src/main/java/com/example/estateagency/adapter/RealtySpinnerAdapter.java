package com.example.estateagency.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.estateagency.R;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.Realty;
import com.example.estateagency.nodb.NoDb;

import java.util.List;

public class RealtySpinnerAdapter extends ArrayAdapter<Realty> {
    public RealtySpinnerAdapter(@NonNull Context context, @NonNull List<Realty> objects) {
        super(context, R.layout.spinner_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_item, null);
        }

        ((TextView) convertView.findViewById(R.id.tv_spinner_item))
                .setText(NoDb.REALTY_LIST.get(position).getAddress());


        return convertView;
    }
}
