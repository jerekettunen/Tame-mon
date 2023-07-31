package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private TextView playHp, enemyHp, playName, enemyName, playLvl, enemyLvl, move1, move2, pStats, eStats;
    public static final Map<String, Integer> ITEM_MAP = new HashMap<String, Integer>();
    private List<Integer> positions = Arrays.asList(0,1,2);
    private Monster enemyActiveMonster;
    private List<Integer> playerStats, enemyStats;



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
        pStats = findViewById(R.id.playStats);
        eStats = findViewById(R.id.enemyStats);

        updater();

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
        System.out.println("test");
        if (id == R.id.btnAtkMove){
            System.out.println("attack");
            turnHandler(1);
        } else if (id == R.id.btnSpcMove) {
            System.out.println("special");
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
        System.out.println("Testi:" + (playerMove-1));
        Monster pMonster = playerMonsters.get(positions.get(0));
        if (playerMove == 0) {
            pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
        } else {
            if (pMonster.getModifiedStats().get(4) < enemyActiveMonster.getModifiedStats().get(4)){
                pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
                enemyActiveMonster.moveAction(pMonster.getStats(), pMonster.getMove(playerMove-1));
            } else {
                enemyActiveMonster.moveAction(pMonster.getStats(), pMonster.getMove(playerMove-1));
                pMonster.moveAction(enemyActiveMonster.getStats(), enemyActiveMonster.getMove(enemyMove-1));
            }
        }
        updater();
    }

    public void updater() {
        Monster pMonster = playerMonsters.get(positions.get(0));
        playerStats = pMonster.getModifiedStats();
        enemyStats = enemyActiveMonster.getModifiedStats();

        playHp.setText(Integer.toString(playerStats.get(0)));
        enemyHp.setText(Integer.toString(enemyStats.get(0)));
        playName.setText(pMonster.getName());
        enemyName.setText(enemyActiveMonster.getName());
        playLvl.setText(Integer.toString(pMonster.getLevel()));
        enemyLvl.setText(Integer.toString(pMonster.getLevel()));
        move1.setText(pMonster.getMove(0).getTitle());
        move2.setText(pMonster.getMove(1).getTitle());
        String pStatString = "atk:" + playerStats.get(1) +
                " def:" + playerStats.get(2)+
                " acc:" + playerStats.get(3)+
                " speed:" + playerStats.get(4);
        pStats.setText(pStatString);
        String eStatString = "atk:" + enemyStats.get(1) +
                " def:" + enemyStats.get(2)+
                " acc:" + enemyStats.get(3)+
                " speed:" + enemyStats.get(4);
        eStats.setText(eStatString);

        checkWin();
    }

    public void checkWin(){
        boolean finish = false;
        if (playerStats.get(0) <= 0 && enemyStats.get(0) > 0){
            PlayerStorage.getInstance().getActivePlayer().addLoss();
            finish = true;
        } else if (playerStats.get(0) > 0 && enemyStats.get(0) <= 0) {
            PlayerStorage.getInstance().getActivePlayer().addWin();
            finish = true;
        }

        if (finish){
            Intent intent = new Intent(this, PlayActivity.class);
            startActivity(intent);
            finish();
        }
    }

}