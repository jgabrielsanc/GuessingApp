package com.android.diplomado.guessingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.diplomado.guessingapp.R;
import com.android.diplomado.guessingapp.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private int layout;
    private OnItemClickListener itemClickListener;

    public CategoryAdapter(List<Category> categories, int layout, OnItemClickListener itemClickListener) {
        this.categories = categories;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(categories.get(i), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView description;
        public ImageView image;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewCategoryName);
            description = itemView.findViewById(R.id.textViewCategoryDescription);
            image = itemView.findViewById(R.id.imageViewCategory);
        }

        public void bind(final Category category, final OnItemClickListener itemClickListener) {
            name.setText(category.getName());
            description.setText(category.getDescription());
            Picasso.get().load(category.getImage()).fit().into(image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(category, getAdapterPosition());
                }
            });
        }
    }
}
