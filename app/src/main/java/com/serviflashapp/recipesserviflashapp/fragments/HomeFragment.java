package com.serviflashapp.recipesserviflashapp.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.adapters.CategoryAdapter;
import com.serviflashapp.recipesserviflashapp.models.Category;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView categoriesRecycler;
    private ArrayList<Category> categoriesList;
    private Activity context;
    private CategoryAdapter categoryAdapter;
    private GridLayoutManager categoryManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        context = getActivity();
        categoriesList = new ArrayList<Category>();
        getCategories();
        categoriesRecycler = (RecyclerView) view.findViewById(R.id.categoriesRecycler);
        categoryAdapter = new CategoryAdapter(categoriesList, context);
        categoriesRecycler.setAdapter(categoryAdapter);
        categoryManager = new GridLayoutManager(context, 2);
        categoryManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(position){
                    case 0:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        categoriesRecycler.setLayoutManager(categoryManager);

        return view;
    }

    private void getCategories() {
        categoriesList.add(new Category(0, 10, "", R.drawable.aperitivos));
        categoriesList.add(new Category(-1, 10, "Aperitivos", R.drawable.aperitivos));
        categoriesList.add(new Category(1, 20, "Arroces", R.drawable.arroces));
        categoriesList.add(new Category(2, 50, "Aves", R.drawable.aves));
        categoriesList.add(new Category(3, 15, "Bebidas", R.drawable.bebidas));
        categoriesList.add(new Category(4, 56, "Bocadillos", R.drawable.bocadillos));
        categoriesList.add(new Category(5, 789, "Café", R.drawable.cafe));
        categoriesList.add(new Category(6, 45, "Carnes", R.drawable.carnes));
        categoriesList.add(new Category(7, 98, "Rápidas", R.drawable.rapidas));
        categoriesList.add(new Category(8, 123, "Ensaladas", R.drawable.ensaladas));
        categoriesList.add(new Category(9, 11, "Frutas", R.drawable.frutas));
        categoriesList.add(new Category(10, 111, "Huevos", R.drawable.huevos));
        categoriesList.add(new Category(11, 120, "Verduras", R.drawable.verduras));
        categoriesList.add(new Category(12, 456, "Postres", R.drawable.postres));
        categoriesList.add(new Category(13, 178, "Pastas", R.drawable.pastas));
        categoriesList.add(new Category(14, 965, "Patatas", R.drawable.patatas));
        categoriesList.add(new Category(15, 11, "Pescados", R.drawable.pescados));
        categoriesList.add(new Category(16, 45, "Suaves", R.drawable.suaves));
        categoriesList.add(new Category(17, 15, "Salsas", R.drawable.salsas));
        categoriesList.add(new Category(18, 17, "Sopas", R.drawable.sopas));
        categoriesList.add(new Category(19, 30, "Tortillas", R.drawable.tortillas));
        categoriesList.add(new Category(20, 34, "Chifa", R.drawable.chifa));
        categoriesList.add(new Category(21, 70, "Wok", R.drawable.wok));
        categoriesList.add(new Category(22, 90, "Sudados", R.drawable.sudados));
        categoriesList.add(new Category(23, 90, "Tortas", R.drawable.tortas));
    }
}
