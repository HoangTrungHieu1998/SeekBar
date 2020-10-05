package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvRGB,mTvHex;
    SeekBar mskR,mskG,mskB,mskA;
    LinearLayout mBackGround;
    Integer rValue,gValue,bValue,aValue;
    String mRGB="";
    String mHex="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvRGB = findViewById(R.id.textviewRGB);
        mTvHex = findViewById(R.id.textviewHex);
        mskA = findViewById(R.id.seekbarAlpha);
        mskB = findViewById(R.id.seekbarBlue);
        mskG = findViewById(R.id.seekbarGreen);
        mskR = findViewById(R.id.seekbarRed);
        mBackGround = findViewById(R.id.linearBackGround);

        mskA.setOnSeekBarChangeListener(seekBarChangeListener);
        mskB.setOnSeekBarChangeListener(seekBarChangeListener);
        mskR.setOnSeekBarChangeListener(seekBarChangeListener);
        mskG.setOnSeekBarChangeListener(seekBarChangeListener);

    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            aValue = mskA.getProgress();
            rValue = mskR.getProgress();
            gValue = mskG.getProgress();
            bValue = mskB.getProgress();
            mBackGround.setBackgroundColor(Color.argb(aValue,rValue,gValue,bValue));
            mRGB = String.valueOf(aValue)+" "
                    +String.valueOf(rValue)+" "
                    +String.valueOf(gValue)+" "
                    +String.valueOf(bValue);
            mHex = String.format("#%02x %02x %02x %02x",aValue,rValue,gValue,bValue).toUpperCase();
            mTvRGB.setText("RGB: "+mRGB);
            mTvHex.setText("HEX: "+mHex);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };
}