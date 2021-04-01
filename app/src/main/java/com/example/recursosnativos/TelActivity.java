package com.example.recursosnativos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelActivity extends AppCompatActivity {

    private static final int CALL_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            for(int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == RESULT_OK && permissions[i].equals(Manifest.permission.CALL_PHONE)) {
                    Toast.makeText(this, "Sem permissao para chamada", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            makeCall();
        }
    }

    public void btnDiscClick(View view) {
        EditText editText = findViewById(R.id.numberField);

        Uri uri = Uri.parse(
          "tel:"+editText.getText().toString()
        );

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void btnTelClick(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.CALL_PHONE
            }, CALL_PERMISSION_REQUEST_CODE);
            return;
        }

        makeCall();
    }

    private void makeCall() {
        EditText editText = findViewById(R.id.numberField);

        Uri uri = Uri.parse(
                "tel:"+editText.getText().toString()
        );

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}