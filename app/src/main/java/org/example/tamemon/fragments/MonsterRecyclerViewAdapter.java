package org.example.tamemon.fragments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.example.tamemon.Monster;
import org.example.tamemon.MonsterStorage;
import org.example.tamemon.R;
import org.example.tamemon.databinding.FragmentMonsterBinding;

import java.util.HashMap;
import java.util.List;


public class MonsterRecyclerViewAdapter extends RecyclerView.Adapter<MonsterViewHolder> {

    private final MonsterStorage monsters;
    private Context context;
    private List<Monster> monsterList;

    public MonsterRecyclerViewAdapter(Context context, MonsterStorage monsters) {
        this.context = context;
        this.monsters = monsters;
        monsterList = monsters.getList();
    }

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MonsterViewHolder(LayoutInflater.from(context).inflate(R.layout.monster_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder holder, int position) {
        holder.title.setText(monsterList.get(position).getName());
        // holder.details.setText(monsters.get(position).getStats());
    }

    @Override
    public int getItemCount() {
        return monsterList.size();
    }

}

