package com.pthlab.kaungmyat.vsda.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.pthlab.kaungmyat.vsda.Activity.GPSDetector;
import com.pthlab.kaungmyat.vsda.R;

public class LocationActivity extends AppCompatActivity {

    private View btnShowLocation, btnCheckLocation;
    private TextView longtitudeText;
    private TextView latutideText;
    private TextView resultText;
    private float longitude, latitude;

    // GPSTracker class
    private GPSDetector gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        btnCheckLocation = (Button) findViewById(R.id.btnCheckLocation);
        longtitudeText = (TextView)findViewById(R.id.txt_long);
        latutideText = (TextView)findViewById(R.id.txt_lat);
        resultText = (TextView) findViewById(R.id.txt_chkresult);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                getCurrentLocation();
            }
        });
        btnCheckLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();
                longitude = Float.parseFloat(String.valueOf(longtitudeText.getText()));
                latitude = Float.parseFloat(String.valueOf(latutideText.getText()));
                getCheckingResult(latitude,longitude);
            }
        });
    }



    private void getCurrentLocation () {
        // create class object
       // gps = new GPSDetector(MainActivity.class);

        // check if GPS enabled
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            //update data to textviews
            longtitudeText.setText(String.valueOf(longitude));
            latutideText.setText(String.valueOf(latitude));
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        gps.stopUsingGPS(); //stop using GPS service on pause
    }

    public void updateLocation() {
        getCurrentLocation();
    }

    private void getCheckingResult(float latitude1, float longitude1) {
        if(latitude1 > 0 && latitude1 <50 && longitude1 >50 && longitude1 <  100){
            resultText.setText("You are in valid area");
        }else{
            resultText.setText("Sorry, You are in invalid area");
        }

    }
}