package com.serviflashapp.recipesserviflashapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.serviflashapp.recipesserviflashapp.activities.NewRecipeActivity;
import com.serviflashapp.recipesserviflashapp.activities.ProfileActivity;
import com.serviflashapp.recipesserviflashapp.activities.SearchRecipeActivity;
import com.serviflashapp.recipesserviflashapp.activities.SuggestionActivity;
import com.serviflashapp.recipesserviflashapp.fragments.FavoritesFragment;
import com.serviflashapp.recipesserviflashapp.fragments.HomeFragment;
import com.serviflashapp.recipesserviflashapp.fragments.LatestsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ImageView search, reload;
    private Intent intent;
    private Dialog popupVersion, popupReload;
    private BottomNavigationView bottomNavigationView;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        search = toolbar.findViewById(R.id.nav_search);
        reload = toolbar.findViewById(R.id.nav_reload);
        setSupportActionBar(toolbar);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchRecipeActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(MainActivity.this);
            }
        });

        popupReload = MainActivity.createDialog(MainActivity.this, true, R.layout.popup_reload);
        popupVersion = MainActivity.createDialog(MainActivity.this, true, R.layout.popup_version);

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupReload.show();
            }
        });

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        changeFragment(new HomeFragment(MainActivity.this));

        //BOTTOM NAVIGATION
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        View header = navigationView.getHeaderView(0);
        back = (ImageButton) header.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    public static Dialog createDialog(Context context, boolean cancelable, int layout) {
        Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        return dialog;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.home:
                changeFragment(new HomeFragment(MainActivity.this));
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
            case R.id.about:
                popupVersion.show();
                break;
            case R.id.rate:
                try {
                    Intent intent2 = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(intent2);
                } catch (Exception e) {
                    Intent intent2 = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                    startActivity(intent2);
                }
                break;
            case R.id.share:
                shareApp();
                break;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(!item.isChecked()) {
                switch (item.getItemId()) {
                    case R.id.casa:
                        changeFragment(new HomeFragment(MainActivity.this));
                        break;
                    case R.id.favorites:
                        changeFragment(new FavoritesFragment(MainActivity.this));
                        break;
                    case R.id.latests:
                        changeFragment(new LatestsFragment(MainActivity.this));
                        break;
                }
            }
            return true;
        }
    };

    private void shareApp() {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String text = "Cocina Altoque App";
        String text2 = "\uD83C\uDF54\uD83E\uDD5E\uD83C\uDF5D\uD83E\uDD58\uD83E\uDD5D\uD83C\uDF45\uD83E\uDD51\uD83C\uDF68 Te comparto una excelente aplicación que contiene cientos de recetas que puedes preparar de forma fácil y rápida. Descárgala ya dando click en el enlace: \n" +
                "https://play.google.com/store/apps/details?id=" + getPackageName();
        myIntent.putExtra(Intent.EXTRA_SUBJECT, text);
        myIntent.putExtra(Intent.EXTRA_TEXT, text2);
        startActivity(Intent.createChooser(myIntent, "Compartiendo Cocina Altoque App"));
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit();
    }
}
