package com.example.booklister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<String> mBooks = new LinkedList<>();
    private LinkedList<String> mDescriptions = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add list of books
        mBooks.add("Book1");
        mDescriptions.add("d1");
        mBooks.add("Book2");
        mDescriptions.add("d2");
        mBooks.add("Book3");
        mDescriptions.add("d3");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookAdapter(this, mBooks, mDescriptions);
        mRecyclerView.setAdapter(mAdapter);
    }
}