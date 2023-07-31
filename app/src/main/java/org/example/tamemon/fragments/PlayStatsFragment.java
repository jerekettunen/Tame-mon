package org.example.tamemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.example.tamemon.Player;
import org.example.tamemon.PlayerStorage;
import org.example.tamemon.R;



public class PlayStatsFragment extends Fragment {

private TextView title, wins, losses;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_stats, container, false);
        Player player = PlayerStorage.getInstance().getActivePlayer();
        title = view.findViewById(R.id.txtPlayer);
        title.setText(player.getName());
        wins = view.findViewById(R.id.txtWins);
        wins.setText(Integer.toString(player.getWins()));
        losses = view.findViewById(R.id.txtLosses);
        losses.setText(Integer.toString(player.getLosses()));
        return view;
    }
}