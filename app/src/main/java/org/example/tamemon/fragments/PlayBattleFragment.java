package org.example.tamemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.example.tamemon.R;

import java.util.ArrayList;

public class PlayBattleFragment extends Fragment implements View.OnClickListener {
    private LinearLayout spinnerContainer;
    private ArrayList<String> dummyList;
    private ToggleButton battleType;
    private int opponentLvl = 1;
    private Button reduceLvl, increaseLvl;
    private Spinner spinner, spinner2, spinner3;
    private TextView txtOpponentLvl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_battle, container, false);

        spinnerContainer = view.findViewById(R.id.spinnerContainer);
        battleType = view.findViewById(R.id.toggleBattleType);
        reduceLvl = view.findViewById(R.id.btnReduceLvl);
        reduceLvl.setOnClickListener(this);
        increaseLvl = view.findViewById(R.id.btnIncreaseLvl);
        increaseLvl.setOnClickListener(this);
        txtOpponentLvl = view.findViewById(R.id.txtLvl);
        txtOpponentLvl.setText(Integer.toString(opponentLvl));

        dummyList = new ArrayList<>();

        dummyList.add("This");
        dummyList.add("Is");
        dummyList.add("A");
        dummyList.add("Test");

        LinearLayout.LayoutParams spinnerLayoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        spinnerLayoutParam.gravity = Gravity.CENTER;

        spinner = new Spinner(getContext());
        spinner2 = new Spinner(getContext());
        spinner3 = new Spinner(getContext());
        spinnerContainer.addView(spinner);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, dummyList);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

        battleType.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnIncreaseLvl) {
            if (opponentLvl <= 99) {
                opponentLvl++;
                txtOpponentLvl.setText(Integer.toString(opponentLvl));
            }
        } else if (id == R.id.btnReduceLvl) {
            if (opponentLvl > 1) {
                opponentLvl--;
                txtOpponentLvl.setText(Integer.toString(opponentLvl));
            }

        } else if (id == R.id.toggleBattleType) {
            if (battleType.isChecked()){
                spinnerContainer.removeView(spinner2);
                spinnerContainer.removeView(spinner3);
            } else {
                spinnerContainer.addView(spinner2);
                spinnerContainer.addView(spinner3);

            }
        }
    }
}