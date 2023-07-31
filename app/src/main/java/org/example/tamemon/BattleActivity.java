package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.example.tamemon.Monsters.Monster;

import java.util.List;

public class BattleActivity extends AppCompatActivity {
    private Enemy enemy;
    private List<Monster> playerMonsters;
    ImageView imgPlayer;
    private LinearLayout switchContainer;
    Button switch1, switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        imgPlayer = findViewById(R.id.imageView);
        enemy = Helper.getInstance().getEnemy();
        playerMonsters = Helper.getInstance().getBattleMonsters();

        switchContainer = findViewById(R.id.switchButtonLayout);
        switch1 = new Button(this);

        LinearLayout.LayoutParams switchLayoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        switchLayoutParam.gravity = Gravity.CENTER;

        switch1 = new Button(this);
        switch2 = new Button(this);

        switchContainer.addView(switch1);
        switchContainer.addView(switch2);

    }


    public void printInfo(View view){
        System.out.println(enemy.getLevel());
        imgPlayer.setImageResource(playerMonsters.get(0).getIcon());
    }
}