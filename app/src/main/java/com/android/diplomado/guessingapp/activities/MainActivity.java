package com.android.diplomado.guessingapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.diplomado.guessingapp.R;
import com.android.diplomado.guessingapp.adapter.CategoryAdapter;
import com.android.diplomado.guessingapp.adapter.OnItemClickListener;
import com.android.diplomado.guessingapp.models.Category;
import com.android.diplomado.guessingapp.utils.Util;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Category> categories;
    private RecyclerView recycler;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = Util.getDummyData();

        getRecyclerConfiguration();

        adapter = new CategoryAdapter(categories, R.layout.recycler_view_item, new OnItemClickListener() {
            @Override
            public void onItemClick(Category category, int position) {
                Toast.makeText(MainActivity.this, "You have selected " + category.getName(), Toast.LENGTH_SHORT).show();
            }

        });

        recycler.setAdapter(adapter);
    }

    private void getRecyclerConfiguration() {
        recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLayoutManager);
    }
}
