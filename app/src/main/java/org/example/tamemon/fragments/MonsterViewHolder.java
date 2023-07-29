package org.example.tamemon.fragments;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.example.tamemon.R;

public class MonsterViewHolder extends RecyclerView.ViewHolder {
    TextView title, details;
    ImageView editImage, removeImage;

    public MonsterViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.txtTitle);
        details = itemView.findViewById(R.id.txtDetails);
        removeImage = itemView.findViewById(R.id.btnRemoveItem);
        editImage = itemView.findViewById(R.id.btnEditInfo);
    }
}
