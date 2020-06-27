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

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.ViewHolderLatest> {
    private ArrayList<Recipe> recipeList;
    private Context context;
    private MainActivity mainActivity;

    public LatestAdapter(ArrayList<Recipe> recipeList, Context context, MainActivity mainActivity) {
        this.recipeList = recipeList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewHolderLatest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, null, false);
        return new ViewHolderLatest(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLatest holder, int position) {
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolderLatest extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayoutCompat categotyLinear;

        public ViewHolderLatest(@NonNull View itemView) {
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
