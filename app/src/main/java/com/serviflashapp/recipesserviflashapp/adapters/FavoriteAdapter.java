package com.serviflashapp.recipesserviflashapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.serviflashapp.recipesserviflashapp.MainActivity;
import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.activities.RecipeActivity;
import com.serviflashapp.recipesserviflashapp.models.Recipe;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolderFavorite> {
    private ArrayList<Recipe> recipeList;
    private Context context;
    private MainActivity mainActivity;

    public FavoriteAdapter(ArrayList<Recipe> recipeList, Context context, MainActivity mainActivity) {
        this.recipeList = recipeList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewHolderFavorite onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, null, false);
        return new ViewHolderFavorite(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavorite holder, int position) {
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolderFavorite extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayoutCompat categotyLinear;

        public ViewHolderFavorite(@NonNull View itemView) {
            super(itemView);
            categotyLinear = itemView.findViewById(R.id.categoryLinear);
        }

        public void setOnClickListeners() {
            categotyLinear.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            switch (v.getId()) {
                case R.id.categoryLinear:
                    Intent intent = new Intent(context, RecipeActivity.class);
                    context.startActivity(intent);
                    Animatoo.animateWindmill(context);
                    break;
            }
        }
    }
}
