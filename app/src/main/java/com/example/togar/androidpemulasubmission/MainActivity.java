package com.example.togar.androidpemulasubmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Esport>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(TeamEsport.getListData());

        setActionBarTitle("Team Esport");
        showCardView();
    }

    private void showCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewTeam cardViewPresidentAdapter = new CardViewTeam(this);
        cardViewPresidentAdapter.setListEsport(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
