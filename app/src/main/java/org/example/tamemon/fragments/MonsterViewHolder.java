package org.example.tamemon.fragments;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.example.tamemon.R;

public class MonsterViewHolder extends RecyclerView.ViewHolder {
    TextView title, hitPoints, atc, def, spd, acc, lvl;
    ImageView icon;

    public MonsterViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.txtTitle);
        hitPoints = itemView.findViewById(R.id.txtHitPoints);
        atc = itemView.findViewById(R.id.txtAtck);
        def = itemView.findViewById(R.id.txtDef);
        spd = itemView.findViewById(R.id.txtSpd);
        acc = itemView.findViewById(R.id.txtAcc);
        lvl = itemView.findViewById(R.id.rvtxtLvl);
        icon = itemView.findViewById(R.id.imgMonster);


    }
}
