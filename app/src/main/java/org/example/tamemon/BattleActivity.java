package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.lang.reflect.Modifier;

public class BattleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        ImageView img = findViewById(R.id.imageView);
        int icon = R.drawable.mon1_0;
        img.setImageResource(icon);
    }
}