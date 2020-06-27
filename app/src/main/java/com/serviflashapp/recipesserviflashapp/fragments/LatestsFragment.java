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

public class LatestsFragment extends Fragment {

    private RecyclerView latestsRecycler;
    private ArrayList<Recipe> latestsList;
    private Activity context;
    private FavoriteAdapter latestsAdapter;
    private LinearLayoutManager latestsManager;
    private MainActivity mainActivity;

    public LatestsFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latests, container, false);

        context = getActivity();
        latestsList = new ArrayList<Recipe>();
        getLatests();
        latestsRecycler = view.findViewById(R.id.latestsRecycler);
        latestsAdapter = new FavoriteAdapter(latestsList, context, mainActivity);
        latestsRecycler.setAdapter(latestsAdapter);
        latestsManager = new GridLayoutManager(context, 1);
        latestsRecycler.setLayoutManager(latestsManager);

        return view;
    }

    private void getLatests() {
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
        latestsList.add(new Recipe());
    }
}
