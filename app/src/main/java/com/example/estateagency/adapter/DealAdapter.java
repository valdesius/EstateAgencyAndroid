package com.example.estateagency.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estateagency.R;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.fragment.ChangeDealFragment;
import com.example.estateagency.nodb.NoDb;

import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String DEAL_KEY = "Deal";
    private final Context context;
    private final LayoutInflater inflater;
    private final List<Deal> dealList;

    public DealAdapter(Context context, List<Deal> dealList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.dealList = dealList;
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvDate, tvClient, tvRealtor;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_deal_date);
            tvClient = itemView.findViewById(R.id.tv_client_name);
            tvRealtor = itemView.findViewById(R.id.tv_realtor_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.deal_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Deal deal = NoDb.DEAL_LIST.get(position);
        ((MyHolder) holder).tvDate.setText(deal.getDate().toString());
        ((MyHolder) holder).tvClient.setText(deal.getClient().getName());
        ((MyHolder) holder).tvRealtor.setText(deal.getRealtor().getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeDealFragment changeDealFragment = new ChangeDealFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(DEAL_KEY, deal);

                changeDealFragment.setArguments(bundle);

                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, changeDealFragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return NoDb.DEAL_LIST.size();
    }
}
