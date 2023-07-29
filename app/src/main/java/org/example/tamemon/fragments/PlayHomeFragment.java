
package org.example.tamemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.example.tamemon.PlayActivity;
import org.example.tamemon.R;


public class PlayHomeFragment extends Fragment {
private Button btnMonster;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_home, container, false);
        Button btnMonster = view.findViewById(R.id.btnMonsters);
        Button btnInventory = view.findViewById(R.id.btnInventory);

        btnMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MonsterFragment();
                ((PlayActivity) getActivity()).startFullFragment(fragment);
            }
        });


        return view;
    }
}