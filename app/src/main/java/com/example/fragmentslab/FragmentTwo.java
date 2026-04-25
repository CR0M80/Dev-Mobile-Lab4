package com.example.fragmentslab;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private int progressValue = 0;

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView tv = view.findViewById(R.id.tvValue);
        SeekBar seekBar = view.findViewById(R.id.seekBar);

        if (savedInstanceState != null) {
            progressValue = savedInstanceState.getInt("progress");
            seekBar.setProgress(progressValue);
            tv.setText("🎚 Valeur : " + progressValue);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                tv.setText("🎚 Valeur : " + progress);

                // changer couleur selon valeur
                if (progress < 30) tv.setTextColor(Color.RED);
                else if (progress < 70) tv.setTextColor(Color.YELLOW);
                else tv.setTextColor(Color.GREEN);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("progress", progressValue);
        super.onSaveInstanceState(outState);
    }
}