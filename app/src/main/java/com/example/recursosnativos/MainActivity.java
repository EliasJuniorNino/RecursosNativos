package com.example.recursosnativos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonGaleriaOnClick(View view) {
        Intent intent = new Intent(this, GaleriaActivity.class);
        startActivity(intent);
    }

    public void buttonCameraOnClick(View view) {
        Intent intent = new Intent(this, CamActivity.class);
        startActivity(intent);
    }

    public void buttonVideoOnClick(View view) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }

    public void buttonMapasOnClick(View view) {
        Intent intent = new Intent(this, LocActivity.class);
        startActivity(intent);
    }

    public void buttonVibraOnClick(View view) {
        Intent intent = new Intent(this, VibraActivity.class);
        startActivity(intent);
    }

    public void buttonTelOnClick(View view) {
        Intent intent = new Intent(this, TelActivity.class);
        startActivity(intent);
    }

    public void buttonAlarmOnClick(View view) {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    public void buttonContactOnClick(View view) {
        Intent intent = new Intent(this, NumberActivity.class);
        startActivity(intent);
    }
}