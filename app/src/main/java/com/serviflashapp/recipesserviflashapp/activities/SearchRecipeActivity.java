package com.serviflashapp.recipesserviflashapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;

import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.adapters.SearchRecipeAdapter;
import com.serviflashapp.recipesserviflashapp.models.Recipe;

import java.util.ArrayList;

public class SearchRecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;
    private SearchRecipeAdapter adapterRecipes;
    private RecyclerView.LayoutManager managerRecipes;
    private ArrayList<Recipe> listaRecipes;
    private ProgressBar progress;
    private Context este;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);
        este = this;

        listaRecipes = new ArrayList<Recipe>();
        recyclerRecipes = (RecyclerView) findViewById(R.id.recycler_recipes);
        progress = (ProgressBar) findViewById(R.id.changing);
        progress.setVisibility(View.GONE);
        recyclerRecipes.setVisibility(View.VISIBLE);
        getRecipes("");
    }

    private void getRecipes(final String filtro) {

        listaRecipes = new ArrayList<Recipe>();
        adapterRecipes = new SearchRecipeAdapter(listaRecipes, este);
        managerRecipes = new GridLayoutManager(this, 1);
        recyclerRecipes.setLayoutManager(managerRecipes);
        recyclerRecipes.setAdapter(adapterRecipes);

        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
        listaRecipes.add(new Recipe());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Busca una receta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //PARA ABRIR EL TECLADO AUTOMÁTICAMENTE
        searchView.setIconified(false);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                getRecipes(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        finish();
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
