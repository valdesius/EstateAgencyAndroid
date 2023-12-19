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
import com.example.estateagency.nodb.NoDb;

import java.util.List;

public class RealtorSpinnerAdapter extends ArrayAdapter<Realtor> {
    public RealtorSpinnerAdapter(@NonNull Context context, @NonNull List<Realtor> objects) {
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
                .setText(NoDb.REALTOR_LIST.get(position).getName());


        return convertView;
    }
}
