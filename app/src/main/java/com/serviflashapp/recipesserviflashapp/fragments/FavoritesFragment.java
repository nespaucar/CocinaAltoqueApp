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
import com.serviflashapp.recipesserviflashapp.adapters.FavoriteAdapter;
import com.serviflashapp.recipesserviflashapp.models.Recipe;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private RecyclerView favoritesRecycler;
    private ArrayList<Recipe> favoritesList;
    private Activity context;
    private FavoriteAdapter favoriteAdapter;
    private LinearLayoutManager favoriteManager;
    private MainActivity mainActivity;

    public FavoritesFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        context = getActivity();
        favoritesList = new ArrayList<Recipe>();
        getFavorites();
        favoritesRecycler = view.findViewById(R.id.favoritesRecycler);
        favoriteAdapter = new FavoriteAdapter(favoritesList, context, mainActivity);
        favoritesRecycler.setAdapter(favoriteAdapter);
        favoriteManager = new GridLayoutManager(context, 1);
        favoritesRecycler.setLayoutManager(favoriteManager);

        return view;
    }

    private void getFavorites() {
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
        favoritesList.add(new Recipe());
    }
}
