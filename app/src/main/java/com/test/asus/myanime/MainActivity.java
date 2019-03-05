package com.test.asus.myanime;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTeam;
    private ArrayList<AnimeModelActivity> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rv_animelist);
        rvTeam.setHasFixedSize(true);
        list.addAll(AnimeDataActivity.getListData());

        showRecyclerList();

    }
    private void showRecyclerList() {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        AnimeAdapterActivity animAdapter = new AnimeAdapterActivity(this);
        animAdapter.setAnimlList(list);
        rvTeam.setAdapter(animAdapter);
    }

}
