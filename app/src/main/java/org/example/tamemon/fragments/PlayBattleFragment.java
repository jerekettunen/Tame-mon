package org.example.tamemon.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.example.tamemon.Monster;
import org.example.tamemon.PlayerStorage;
import org.example.tamemon.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayBattleFragment extends Fragment implements View.OnClickListener {
    private LinearLayout spinnerContainer;
    private ArrayList<String> monsterNameList;
    private List<Monster> monsterList;
    private List<Integer> selectedMonster = Arrays.asList(-1, -1, -1);
    private ToggleButton battleType;
    private int opponentLvl = 1;
    private Button reduceLvl, increaseLvl, startBattle;
    private Spinner spinner, spinner2, spinner3;
    private TextView txtOpponentLvl;
    ArrayAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_battle, container, false);

        // Initialize fields
        spinnerContainer = view.findViewById(R.id.spinnerContainer);
        battleType = view.findViewById(R.id.toggleBattleType);
        battleType.setOnClickListener(this);
        reduceLvl = view.findViewById(R.id.btnReduceLvl);
        reduceLvl.setOnClickListener(this);
        increaseLvl = view.findViewById(R.id.btnIncreaseLvl);
        increaseLvl.setOnClickListener(this);
        startBattle = view.findViewById(R.id.btnBattleStart);
        startBattle.setOnClickListener(this);
        txtOpponentLvl = view.findViewById(R.id.txtLvl);
        txtOpponentLvl.setText(Integer.toString(opponentLvl));

        // Get monster info and generate a name list
        monsterList = PlayerStorage.getInstance().getActivePlayer().getMonstersList();
        monsterNameList = new ArrayList<>();
        monsterNameList.add("");

        for (Monster monster : monsterList){
            monsterNameList.add(monster.getName());
        }

        // Set spinner workflow
        LinearLayout.LayoutParams spinnerLayoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        spinnerLayoutParam.gravity = Gravity.CENTER;

        spinner = new Spinner(getContext());
        spinner2 = new Spinner(getContext());
        spinner3 = new Spinner(getContext());
        spinnerContainer.addView(spinner);

        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, monsterNameList) {
            @Override
            public boolean isEnabled(int position) {
                if (selectedMonster.contains(position) && position > 0) {
                    return false;
                }
                return true;
            }
            // Change color item
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View mView = super.getDropDownView(position, convertView, parent);
                TextView mTextView = (TextView) mView;
                if (selectedMonster.contains(position) && position > 0) {
                    mTextView.setTextColor(Color.GREEN);
                } else {
                    mTextView.setTextColor(Color.BLACK);
                }
                return mView;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMonster.set(0, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedMonster.set(0, -1);
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMonster.set(1, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedMonster.set(1, -1);
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMonster.set(2, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedMonster.set(3, -1);
            }
        });

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
                spinner2.setAdapter(null);
                spinner3.setAdapter(null);
                selectedMonster.set(1, -1);
                selectedMonster.set(2, -1);
            } else {
                spinner2.setAdapter(adapter);
                spinner3.setAdapter(adapter);
                spinnerContainer.addView(spinner2);
                spinnerContainer.addView(spinner3);

            }
        } else if (id == R.id.btnBattleStart) {
            Intent intent = new Intent();
        }
    }
}