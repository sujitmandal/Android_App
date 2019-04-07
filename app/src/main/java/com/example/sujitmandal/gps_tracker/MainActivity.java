package com.example.sujitmandal.gps_tracker;

import android.Manifest;
import android.app.Activity;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGetloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetloc = (Button) findViewById(R.id.btnGetloc);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);

        btnGetloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker G = new GPStracker(getApplicationContext());
                Location L = G.getLocatioin();
                if(L != null){
                    double lat = L.getLatitude();
                    double lon = L.getLongitude();
                    Toast.makeText(getApplicationContext(),"LATITUDE: "+lat+"\nLONGITUDE: "+ lon,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
