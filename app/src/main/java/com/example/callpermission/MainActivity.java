package com.example.callpermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;

import android.Manifest;

import android.content.Context;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String[] Permissions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Permissions = new String[]{
                Manifest.permission.CALL_PHONE,
        };
        if (!hasPermissions(MainActivity.this, Permissions)) {
            ActivityCompat.requestPermissions(MainActivity.this, Permissions, 1);
        }
    }

    private boolean hasPermissions(Context context, String... Permissions) {

        if (context != null && Permissions != null) {

//For each string in array check permission

            for (String Permission : Permissions) {

// checks if permission is already given to the user

                if (ActivityCompat.checkSelfPermission(context, Permission) != PackageManager.PERMISSION_GRANTED) {

                    return false;

                }

            }

        }

        return true;

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//Check if request code is granted.

        if (requestCode == 1) {

//if permission is granted

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Calling Permission is granted", Toast.LENGTH_SHORT).show();

            }else {

                Toast.makeText(this, "Calling Permission is denied", Toast.LENGTH_SHORT).show();

            }

        }

    }

}

