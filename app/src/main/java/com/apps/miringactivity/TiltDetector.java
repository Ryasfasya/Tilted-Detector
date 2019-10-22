package com.apps.miringactivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class TiltDetector implements SensorEventListener {

    private OnTiltedListener mListener;
    interface OnTiltedListener {
        void leftTilted();
        void rightTilted();
    }

    public TiltDetector(OnTiltedListener listener) {
        mListener = listener;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (Math.abs(event.values[0])<2f) return;
        if (event.values[0] < 0) mListener.leftTilted();
        else
            mListener.rightTilted();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
