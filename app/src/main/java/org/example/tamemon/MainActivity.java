package org.example.tamemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.tamemon.fragments.FragmentNewPlayer;
import org.example.tamemon.fragments.InfoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContinue = findViewById(R.id.btnContinue);
        Button btnNewPlay = findViewById(R.id.btnNewPlay);
        Button info = findViewById(R.id.btnInfo);

        btnContinue.setOnClickListener(listener);
        btnNewPlay.setOnClickListener(listener);
        info.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;
            int id = view.getId();
            if (id == R.id.btnNewPlay){
                fragment = new FragmentNewPlayer();
            } else if (id == R.id.btnInfo) {
                fragment = new InfoFragment();
            } else if (id == R.id.btnContinue) {
                Intent intent = new Intent(view.getContext(), PlayActivity.class);
                startActivity(intent);
                return;
            }
            
            getSupportFragmentManager().beginTransaction().setCustomAnimations(
                    R.anim.slide_in,  // enter
                    R.anim.fade_out,  // exit
                    R.anim.fade_in,   // popEnter
                    R.anim.slide_out  // popExit
                    )
                    .replace(R.id.frameStart, fragment)
                    .addToBackStack(null)
                    .commit();

        }
    };

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();
        System.out.println(count);

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }
}