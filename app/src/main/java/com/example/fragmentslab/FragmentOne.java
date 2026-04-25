package com.example.fragmentslab;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView tv = view.findViewById(R.id.textOne);
        Button btn = view.findViewById(R.id.btnHello);

        btn.setOnClickListener(v -> {
            tv.setText("Bonjour depuis Fragment 1 !");
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentOne", "onPause()");
    }
}