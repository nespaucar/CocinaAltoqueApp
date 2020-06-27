package com.serviflashapp.recipesserviflashapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.serviflashapp.recipesserviflashapp.R;

public class NewRecipeActivity extends AppCompatActivity {

    private ImageButton back;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        back = (ImageButton) findViewById(R.id.back);
        context = this;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}
