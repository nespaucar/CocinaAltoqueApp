package com.serviflashapp.recipesserviflashapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.textview.MaterialTextView;
import com.serviflashapp.recipesserviflashapp.MainActivity;
import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.activities.RecipeActivity;
import com.serviflashapp.recipesserviflashapp.fragments.RecipesListFragment;
import com.serviflashapp.recipesserviflashapp.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolderCategory> {
    private ArrayList<Category> categoryList;
    private Context context;
    private MainActivity mainActivity;

    public CategoryAdapter(ArrayList<Category> categoryList, Context context, MainActivity mainActivity) {
        this.categoryList = categoryList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getItemViewType(int position) {
        return categoryList.get(position).getId();
    }

    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if(viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_days_recipe, null, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null, false);
        }
        return new ViewHolderCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        if(position != 0) {
            holder.nameText.setText(categoryList.get(position).getName());
            holder.cantText.setText(categoryList.get(position).getNumRecipes() + " Recetas");
            holder.categoryImage.setImageResource(categoryList.get(position).getImage());
        }
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolderCategory extends RecyclerView.ViewHolder implements View.OnClickListener {

        private MaterialTextView cantText, nameText;
        private ImageView categoryImage;
        private LinearLayoutCompat categoryLinear;

        public ViewHolderCategory(@NonNull View itemView) {
            super(itemView);
            cantText = itemView.findViewById(R.id.cantText);
            nameText = itemView.findViewById(R.id.nameText);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryLinear = itemView.findViewById(R.id.categoryLinear);
        }

        public void setOnClickListeners() {
            categoryLinear.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            switch (v.getId()) {
                case R.id.categoryLinear:
                    if(position == 0) {
                        Intent intent = new Intent(context, RecipeActivity.class);
                        context.startActivity(intent);
                        Animatoo.animateWindmill(context);
                    } else {
                        mainActivity.changeFragment(new RecipesListFragment(mainActivity));
                    }
                    break;
                case R.id.nav_reload:
                    break;
            }
        }
    }
}