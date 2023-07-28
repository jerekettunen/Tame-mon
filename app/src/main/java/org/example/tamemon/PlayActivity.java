package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class PlayActivity extends AppCompatActivity {
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        if (getIntent() != null) {
            player = PlayerStorage.getInstance().getPlayer(getIntent().getIntExtra("player", 0));
        }

        TabLayout tabLayout = findViewById(R.id.tabArea);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);

    }
}