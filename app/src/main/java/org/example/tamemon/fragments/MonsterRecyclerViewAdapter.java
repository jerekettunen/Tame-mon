package org.example.tamemon.fragments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.example.tamemon.Monsters.Monster;
import org.example.tamemon.Monsters.MonsterStorage;
import org.example.tamemon.R;

import java.util.List;


public class MonsterRecyclerViewAdapter extends RecyclerView.Adapter<MonsterViewHolder> {

    private MonsterStorage monsters;
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
        Monster monster = monsterList.get(position);
        List <Integer> stats = monster.getStats();
        String setTxt;
        holder.title.setText(monster.getName());
        setTxt = "Attack: " + stats.get(1);
        holder.atc.setText(setTxt);
        setTxt = "Defense: " + stats.get(2);
        holder.def.setText(setTxt);
        setTxt = "Speed: " + stats.get(3);
        holder.spd.setText(setTxt);
        setTxt = "Accuracy: " + stats.get(4);
        holder.acc.setText(setTxt);
        setTxt = "HP: " + stats.get(0);
        holder.hitPoints.setText(setTxt);
        System.out.println(monster.getLevel());
        holder.lvl.setText(Integer.toString(monster.getLevel()));
        holder.icon.setImageResource(monster.getIcon());

        // holder.details.setText(monsters.get(position).getStats());

    }

    @Override
    public int getItemCount() {
        return monsterList.size();
    }

}

