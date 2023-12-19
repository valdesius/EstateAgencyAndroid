package com.example.estateagency;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estateagency.adapter.DealAdapter;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.nodb.NoDb;
import com.example.estateagency.rest.EstateAgencyApiVolley;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDeal;
    private DealAdapter dealAdapter;

    private EstateAgencyApiVolley estateAgencyApiVolley;

    private ItemTouchHelper.SimpleCallback simpleCallback;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estateAgencyApiVolley = new EstateAgencyApiVolley(this);
        estateAgencyApiVolley.fillDeal();

        rvDeal = findViewById(R.id.rv_deal);
        dealAdapter = new DealAdapter(this, NoDb.DEAL_LIST);
        rvDeal.setAdapter(dealAdapter);

        simpleCallback = new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Deal deal = NoDb.DEAL_LIST.get(viewHolder.getAdapterPosition());
                if (direction == ItemTouchHelper.LEFT) {
                    estateAgencyApiVolley.deleteDeal(deal.getId());
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvDeal);


    }

    public void updateAdapter() {
        dealAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        int size = fragmentList.size();
        if (size > 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(size - 1))
                    .commit();
        } else {
            finish();
        }
    }
}