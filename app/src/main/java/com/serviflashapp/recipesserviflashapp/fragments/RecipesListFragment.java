package com.serviflashapp.recipesserviflashapp.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serviflashapp.recipesserviflashapp.MainActivity;
import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.adapters.RecipeAdapter;
import com.serviflashapp.recipesserviflashapp.models.Recipe;

import java.util.ArrayList;

public class RecipesListFragment extends Fragment {

    private RecyclerView recipesRecycler;
    private ArrayList<Recipe> recipesList;
    private Activity context;
    private RecipeAdapter recipeAdapter;
    private LinearLayoutManager recipeManager;
    private MainActivity mainActivity;

    public RecipesListFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes_list, container, false);

        context = getActivity();
        recipesList = new ArrayList<Recipe>();
        getRecipes();
        recipesRecycler = view.findViewById(R.id.recipesRecycler);
        recipeAdapter = new RecipeAdapter(recipesList, context, mainActivity);
        recipesRecycler.setAdapter(recipeAdapter);
        recipeManager = new GridLayoutManager(context, 1);
        recipesRecycler.setLayoutManager(recipeManager);

        return view;
    }

    private void getRecipes() {
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
        recipesList.add(new Recipe());
    }
}
