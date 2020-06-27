package com.serviflashapp.recipesserviflashapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.navigation.NavigationView;
import com.serviflashapp.recipesserviflashapp.activities.NewRecipeActivity;
import com.serviflashapp.recipesserviflashapp.activities.ProfileActivity;
import com.serviflashapp.recipesserviflashapp.activities.SearchRecipeActivity;
import com.serviflashapp.recipesserviflashapp.activities.SuggestionActivity;
import com.serviflashapp.recipesserviflashapp.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ImageView search;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        search = toolbar.findViewById(R.id.nav_search);
        setSupportActionBar(toolbar);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchRecipeActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(MainActivity.this);
            }
        });

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        changeFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.home:
                changeFragment(new HomeFragment());
                break;
            case R.id.profile:
                intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(MainActivity.this);
                break;
            case R.id.suggestion:
                intent = new Intent(MainActivity.this, SuggestionActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(MainActivity.this);
                break;
            case R.id.new_recipe:
                intent = new Intent(MainActivity.this, NewRecipeActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(MainActivity.this);
                break;
        }
        return false;
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit();
    }
}
