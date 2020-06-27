package com.serviflashapp.recipesserviflashapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.serviflashapp.recipesserviflashapp.R;

public class RecipeActivity extends AppCompatActivity {

    private ImageButton back, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        back = (ImageButton) findViewById(R.id.back);
        search = (ImageButton) findViewById(R.id.nav_search);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeActivity.this, SearchRecipeActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(RecipeActivity.this);
            }
        });
    }
}
