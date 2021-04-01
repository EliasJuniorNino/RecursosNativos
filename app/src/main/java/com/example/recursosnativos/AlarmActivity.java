package com.example.recursosnativos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {

    private static final int ALARM_PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == ALARM_PERMISSION_REQUEST) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != RESULT_OK && permissions[i].equals(Manifest.permission.SET_ALARM)) {
                    Toast.makeText(this, "Voce nao aceitou as permissoes", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            defineAlarm();
        }
    }

    public void btnDefineAlarm(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SET_ALARM) == PackageManager.PERMISSION_DENIED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.SET_ALARM
                }, ALARM_PERMISSION_REQUEST);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.SET_ALARM
                }, ALARM_PERMISSION_REQUEST);
            }
            Toast.makeText(this, "Sem permissão para isso!!", Toast.LENGTH_LONG).show();
            return;
        }

        defineAlarm();
    }

    private void defineAlarm() {
        EditText h = findViewById(R.id.horas_text);
        EditText m = findViewById(R.id.minuts_text);

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "App Recursos nativos")
                .putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(h.getText().toString()))
                .putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(m.getText().toString()))
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}