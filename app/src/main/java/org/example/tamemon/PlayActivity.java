package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        if (getIntent() != null) {
            player = PlayerStorage.getInstance().getPlayer(getIntent().getIntExtra("player", 0));
        }

        TextView title = findViewById(R.id.txtPlayerTitle);
        title.setText(player.getName());

    }
}