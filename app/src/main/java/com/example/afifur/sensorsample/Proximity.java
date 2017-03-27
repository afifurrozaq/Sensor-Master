package com.example.afifur.sensorsample;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Proximity extends ActionBarActivity {
    SensorManager sm = null;
    TextView proxy = null;
    ImageView image = null ;
    List list;
    Button compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        /* Get a SensorManager instance */
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        proxy = (TextView) findViewById(R.id.search_src_text);
        image = (ImageView) findViewById(R.id.main_image_dial);
        list = sm.getSensorList(Sensor.TYPE_PROXIMITY);

        if (list.size() > 0) {
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(getBaseContext(), "Error: No Sensor gyroscope.", Toast.LENGTH_LONG).show();
        }

        compass = (Button) findViewById(R.id.button2);
        compass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), CompassActivity.class);
                view.getContext().startActivity(Intent);}
        });

    }

    SensorEventListener sel = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            if (values[0] == 0){
                proxy.setText(" Jarak benda dengan devices :    "+String.valueOf(values[0])+" cm");
                image.setImageResource(R.drawable.happy);
            }else{
                proxy.setText(" Jarak benda dengan devices :    "+String.valueOf(values[0])+" cm");
                image.setImageResource(R.drawable.smile);
            }
        }
    };
    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
    }
}
