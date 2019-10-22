package com.apps.miringactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TiltDetector mDetector;
    private Sensor mAccelerometer;
    private SensorManager mManager;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mDetector = new TiltDetector(new TiltDetector.OnTiltedListener() {
            @Override
            public void leftTilted() {
                Log.d("TILT", "Left tilted!");
            }

            @Override
            public void rightTilted() {
                if (mView.getLeft() - 5 < 0)
                    mView.setLeft(0);
                else
                    mView.setLeft(mView.getLeft()-5);
            }
        });
    }
}
