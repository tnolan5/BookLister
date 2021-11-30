package com.example.booklister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

public class BookAdapter extends AppCompatActivity {
    RecyclerView.Adapter<BookAdapter.WordViewHolder>

    {

        private LayoutInflater mInflater;
        private LinkedList<String> mRecipeName;
        private LinkedList<String> mRecipeDesc;
        private Context context;

    public BookAdapter(Context context,
            LinkedList<String> titleList, LinkedList<String> descList) {
        mInflater = LayoutInflater.from(context);
        mRecipeName = titleList;
        mRecipeDesc = descList;
        this.context = context;
    }

        @NonNull
        @Override
        public WordViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        View mItemView = mInflater.inflate(R.layout.recipe_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

        @Override
        public void onBindViewHolder (@NonNull WordViewHolder holder,int position){
        String mNCurrent = mRecipeName.get(position);
        String mDCurrent = mRecipeDesc.get(position);
        holder.mRecipeNameView.setText(mNCurrent);
        holder.mRecipeDescView.setText(mDCurrent);
    }

        @Override
        //Set the number of items in the data source
        public int getItemCount () {
        return mBookTitle.size();
    }

        class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mRecipeNameView;
            private TextView mRecipeDescView;
            private BookAdapter mAdapter;

            public WordViewHolder(View itemView, BookAdapter adapter) {
                super(itemView);
                mBookTitleView = itemView.findViewById(R.id.bookTitle);
                mBookDescView = itemView.findViewById(R.id.bookDesc);
                this.mAdapter = adapter;
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                context.startActivity(intent);
            }
        }

    }

}