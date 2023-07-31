package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.example.tamemon.Monsters.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleActivity extends AppCompatActivity implements View.OnClickListener {
    private Enemy enemy;
    private List<Monster> playerMonsters, enemyMonsters;
    private ImageView imgPlayer, imgEnemy;
    private LinearLayout switchContainer;
    private ImageButton switch1, switch2;
    private Button attack, special;
    private TextView playHp, enemyHp, playName, enemyName, playLvl, enemyLvl, move1, move2;
    public static final Map<String, Integer> ITEM_MAP = new HashMap<String, Integer>();
    private List<Integer> positions = Arrays.asList(0,1,2);
    private Monster enemyActiveMonster;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        imgPlayer = findViewById(R.id.imgPlayerMonster);
        imgEnemy = findViewById(R.id.imgEnemyMonster);
        enemy = Helper.getInstance().getEnemy();
        playerMonsters = Helper.getInstance().getBattleMonsters();
        enemyMonsters = enemy.getMonsterList();
        enemyActiveMonster = enemyMonsters.get(0);

        // Image init
        imgPlayer.setImageResource(playerMonsters.get(0).getIcon());
        imgEnemy.setImageResource(enemyActiveMonster.getIcon());

        // Button init
        attack = findViewById(R.id.btnAtkMove);
        attack.setOnClickListener(this);
        special = findViewById(R.id.btnSpcMove);
        special.setOnClickListener(this);

        playHp = findViewById(R.id.playerHp);
        enemyHp = findViewById(R.id.enemyHp);
        playName = findViewById(R.id.playName);
        enemyName = findViewById(R.id.enemyName);
        playLvl = findViewById(R.id.playLvl);
        enemyLvl = findViewById(R.id.enemyLvl);
        move1 = findViewById(R.id.txtMove1);
        move2 = findViewById(R.id.txtMove2);


        if (playerMonsters.size() > 1){
            switchContainer = findViewById(R.id.switchButtonLayout);

            LinearLayout.LayoutParams switchLayoutParam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            switchLayoutParam.gravity = Gravity.CENTER;
            if (playerMonsters.get(1) != null){
                switch1 = new ImageButton(this);
                int id = View.generateViewId();
                switch1.setId(id);
                ITEM_MAP.put("key1", id);
                switch1.setLayoutParams(switchLayoutParam);
                switch1.setImageResource(playerMonsters.get(1).getIcon());
                switch1.setOnClickListener(this);
                switchContainer.addView(switch1);
            } if (playerMonsters.get(2) != null){
                switch2 = new ImageButton(this);
                int id = View.generateViewId();
                switch2.setId(id);
                ITEM_MAP.put("key2", id);
                switch2.setLayoutParams(switchLayoutParam);
                switch2.setImageResource(playerMonsters.get(2).getIcon());
                switch2.setOnClickListener(this);
                switchContainer.addView(switch2);
            }

        }


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnAtkMove){
            //do something
            turnHandler(1);
        } else if (id == R.id.btnSpcMove) {
            //do something
            turnHandler(2);
        } else if (id == ITEM_MAP.get("key1")) {
            int temp = positions.get(0);
            positions.set(0, positions.get(1));
            positions.set(1,temp);
            imgPlayer.setImageResource(playerMonsters.get(positions.get(0)).getIcon());
            switch1.setImageResource(playerMonsters.get(positions.get(1)).getIcon());
            turnHandler(0);
        } else if (id == ITEM_MAP.get("key2")) {
            int temp = positions.get(0);
            positions.set(0, positions.get(2));
            positions.set(2,temp);
            imgPlayer.setImageResource(playerMonsters.get(positions.get(0)).getIcon());
            switch2.setImageResource(playerMonsters.get(positions.get(2)).getIcon());
            turnHandler(0);
        }
    }

    public void turnHandler(int playerMove) {
        int enemyMove = enemy.getMove();
        Monster pMonster = playerMonsters.get(positions.get(0));
        if (playerMove == 0) {
            pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
        } else {
            if (pMonster.getStats().get(5) < enemyActiveMonster.getStats().get(5)){
                pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
                enemyActiveMonster.moveAction(pMonster.getStats(), pMonster.getMove(enemyMove-1));
            } else {
                enemyActiveMonster.moveAction(pMonster.getStats(), pMonster.getMove(enemyMove-1));
                pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
            }
        }
    }

    public void updater() {

    }

}