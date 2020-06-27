package com.serviflashapp.recipesserviflashapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;

import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.adapters.SuggestionAdapter;
import com.serviflashapp.recipesserviflashapp.models.Suggestion;

import java.util.ArrayList;

public class SuggestionActivity extends AppCompatActivity {

    private RecyclerView recyclerSuggestions;
    private SuggestionAdapter adapterSuggestions;
    private RecyclerView.LayoutManager managerSuggestions;
    private ArrayList<Suggestion> listaSuggestions;
    private ProgressBar progress;
    private Context este;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        este = this;

        listaSuggestions = new ArrayList<Suggestion>();
        recyclerSuggestions = findViewById(R.id.recycler_suggestions);
        progress = findViewById(R.id.changing);
        progress.setVisibility(View.GONE);
        recyclerSuggestions.setVisibility(View.VISIBLE);

        listaSuggestions = new ArrayList<Suggestion>();
        getRecipes("");
        adapterSuggestions = new SuggestionAdapter(listaSuggestions, este, null);
        managerSuggestions = new GridLayoutManager(this, 1);
        recyclerSuggestions.setLayoutManager(managerSuggestions);
        recyclerSuggestions.setAdapter(adapterSuggestions);
    }

    private void getRecipes(final String filtro) {
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
        listaSuggestions.add(new Suggestion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Digita un ingrediente");
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
