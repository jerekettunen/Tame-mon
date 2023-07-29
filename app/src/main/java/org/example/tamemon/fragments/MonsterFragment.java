package org.example.tamemon.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.example.tamemon.Monster;
import org.example.tamemon.Player;
import org.example.tamemon.PlayerStorage;
import org.example.tamemon.R;

import java.util.List;


public class MonsterFragment extends Fragment {
    private MonsterRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monster_list, container, false);
        Context context = view.getContext();
        Player player = PlayerStorage.getInstance().getActivePlayer();

        RecyclerView recyclerView = view.findViewById(R.id.rvMonsters);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MonsterRecyclerViewAdapter(getContext(), player.getMonsters());
        recyclerView.setAdapter(adapter);

        Button btnNewMonster = view.findViewById(R.id.btnNewMonster);
        btnNewMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.addMonster();
                recyclerView.setAdapter(new MonsterRecyclerViewAdapter(getContext(), player.getMonsters()));
            }

        });
        return view;
    }

}