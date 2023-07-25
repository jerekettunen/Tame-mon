package org.example.tamemon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.example.tamemon.PlayActivity;
import org.example.tamemon.Player;
import org.example.tamemon.PlayerStorage;
import org.example.tamemon.R;

public class FragmentNewPlayer extends Fragment {
    EditText name;
    public FragmentNewPlayer() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_player, container, false);

        ImageButton back = view.findViewById(R.id.btnNewBack);
        Button startNew = view.findViewById(R.id.btnNewStart);
        name = view.findViewById(R.id.txtTamerName);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        startNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText() != null){
                    Player player = new Player(name.getText().toString());
                    PlayerStorage.getInstance().addPlayer(player);
                    int playerID = PlayerStorage.getInstance().getPosition(player);
                    Intent intent = new Intent(view.getContext(), PlayActivity.class);
                    intent.putExtra("player", playerID);
                    intent.putExtra("state", 0);

                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        return view;
    }

}