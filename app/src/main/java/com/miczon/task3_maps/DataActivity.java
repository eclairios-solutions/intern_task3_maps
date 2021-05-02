package com.miczon.task3_maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

   private Dbhelper dbhelper;
   private Adapter adapter;
   private RecyclerView recyclerView;
   private List<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        recyclerView = findViewById(R.id.recycleView);

        dbhelper = new Dbhelper(DataActivity .this );

          list =   dbhelper.getData();
          recyclerView.setAdapter(new Adapter(list,this));
    }
}