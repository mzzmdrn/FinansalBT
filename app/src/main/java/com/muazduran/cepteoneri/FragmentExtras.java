package com.muazduran.cepteoneri;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.github.florent37.androidslidr.Slidr;

import java.io.Serializable;

import lib.kingja.switchbutton.SwitchMultiButton;

public class FragmentExtras extends Fragment implements Serializable {
    public FragmentExtras() {}

    private TextView budgetTitle;
    private ImageView budgetPicture;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extras,container,false);

        // Budget Slider
        Slidr slidr = view.findViewById(R.id.slidr);
        slidr.setMax(5000);
        slidr.setTextFormatter(new Slidr.TextFormatter() {
            @Override
            public String format(float value){
                return (int)value +" ₺";
            }
        });

        //  Guarenty Toggle
        SwitchMultiButton mSwitchMultiButton = (SwitchMultiButton) view.findViewById(R.id.switch2);
        mSwitchMultiButton.setText("İthalatçı", "Distribütör").setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(getContext(), tabText, Toast.LENGTH_SHORT).show();
            }
        });

        return view;


    }




}
