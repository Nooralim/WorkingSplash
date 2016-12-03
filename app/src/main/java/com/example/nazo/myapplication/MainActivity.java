package com.example.nazo.myapplication;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    String[] pic_namees = {"Apples","Cat","Deadpool","Dog","Duck","Forest",
                            "Owl","Panda","Penguino","Pikachu","Sonic","Tiger"};

    int[] pic_pictures = {R.drawable.apples,R.drawable.cat,R.drawable.deadpool,R.drawable.dog,
                          R.drawable.duck,R.drawable.forest,R.drawable.owl,R.drawable.panda,
                          R.drawable.penguino,R.drawable.pikachu,R.drawable.sonic,R.drawable.tiger};

    Toolbar SearchBar;
    private Button mButton;

    RecyclerView mRecyclerView;
    RecyclerAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Country> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchBar = (Toolbar)findViewById(R.id.searchBar);
        setSupportActionBar(SearchBar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        int counter = 0;

        for(String name : pic_namees){

            mArrayList.add(new Country(name, pic_pictures[counter]));
            counter++;

        }//end of forloop

        mAdapter = new RecyclerAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_pictures,menu);
        MenuItem menuPicture = menu.findItem(R.id.searcher);   //use searcher here!!!
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuPicture);
        searchView.setOnQueryTextListener(this);


        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Country> newList = new ArrayList<>();

        for(Country country : mArrayList){

            String title = country.getName().toLowerCase();
                if(title.contains(newText))
                    newList.add(country);

        }//end of for loop
        mAdapter.setFilter(newList);
        return true;
    }
}
