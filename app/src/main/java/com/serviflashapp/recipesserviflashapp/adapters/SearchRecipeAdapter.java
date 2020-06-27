package com.serviflashapp.recipesserviflashapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.serviflashapp.recipesserviflashapp.MainActivity;
import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.activities.RecipeActivity;
import com.serviflashapp.recipesserviflashapp.models.Recipe;

import java.util.ArrayList;

public class SearchRecipeAdapter extends RecyclerView.Adapter<SearchRecipeAdapter.ViewHolderSearchRecipe> implements Filterable {
    private ArrayList<Recipe> searchRecipe;
    private ArrayList<Recipe> searchRecipeFull;
    private Context context;
    private MainActivity mainActivity;

    public SearchRecipeAdapter(ArrayList<Recipe> buscarservicio, Context context, MainActivity mainActivity) {
        this.searchRecipe = buscarservicio;
        this.searchRecipeFull = new ArrayList<Recipe>(buscarservicio);
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolderSearchRecipe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_recipe, null, false);
        return new ViewHolderSearchRecipe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRecipeAdapter.ViewHolderSearchRecipe holder, int position) {
    }

    @Override
    public int getItemCount() {
        return searchRecipe.size();
    }

    @Override
    public Filter getFilter() {
        return buscarServicioFilter;
    }

    private Filter buscarServicioFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Recipe> filteredList = new ArrayList<Recipe>();
            if (constraint == null && constraint.length() == 0) {
                filteredList.addAll(searchRecipeFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Recipe recipe : searchRecipeFull) {
                    if (recipe.getCategory().toLowerCase().contains(filterPattern) || recipe.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(recipe);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            searchRecipe.clear();
            searchRecipe.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolderSearchRecipe extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolderSearchRecipe(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            switch (v.getId()) {
                case R.id.searchLinear:
                    Intent intent = new Intent(context, RecipeActivity.class);
                    context.startActivity(intent);
                    Animatoo.animateWindmill(context);
                    break;
            }
        }
    }
}

