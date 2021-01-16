package com.example.jirehapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity  extends Activity implements SensorEventListener{

    private long lastTime;
    private float speed;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float x, y, z;

    private static final int SHAKE_THRESHOLD = 800;
    private static final int DATA_X = SensorManager.DATA_X;
    private static final int DATA_Y = SensorManager.DATA_Y;
    private static final int DATA_Z = SensorManager.DATA_Z;

    private SensorManager sensorManager;
    private Sensor accelerormeterSensor;

    TextView dice1,dice2,result;
    int dicere1,dicere2;
    boolean check = true;
    ImageView d1,d2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        result = findViewById(R.id.result);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (accelerormeterSensor != null)
            sensorManager.registerListener(this, accelerormeterSensor,
                    SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (sensorManager != null)
            sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);
            if (gabOfTime > 300) {
                lastTime = currentTime;
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];

                speed = Math.abs(x + y + z - lastX - lastY - lastZ) / gabOfTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    if (check == true){
                        check = false;
                        result.setText(" \n ");
                        Random random = new Random();
                        dicere1 = random.nextInt(5);
                        dicere2 = random.nextInt(5);
                        if (dicere1 == dicere2){
                            int dicer1 = dicere1+1;
                            int dicer2 = dicere2+1;
                            final int diceresult = dicer1+dicer2;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dice1.setText(String.valueOf(dicere1+1));
                                    dice2.setText(String.valueOf(dicere2+1));
                                    switch (Integer.parseInt(String.valueOf(dice1.getText()))){
                                        case 1:
                                            d1.setBackgroundResource(R.drawable.d1);
                                            break;
                                        case 2:
                                            d1.setBackgroundResource(R.drawable.d2);
                                            break;
                                        case 3:
                                            d1.setBackgroundResource(R.drawable.d3);
                                            break;
                                        case 4:
                                            d1.setBackgroundResource(R.drawable.d4);
                                            break;
                                        case 5:
                                            d1.setBackgroundResource(R.drawable.d5);
                                            break;
                                        case 6:
                                            d1.setBackgroundResource(R.drawable.d6);
                                            break;
                                    }
                                    switch (Integer.parseInt(String.valueOf(dice2.getText()))){
                                        case 1:
                                            d2.setBackgroundResource(R.drawable.d1);
                                            break;
                                        case 2:
                                            d2.setBackgroundResource(R.drawable.d2);
                                            break;
                                        case 3:
                                            d2.setBackgroundResource(R.drawable.d3);
                                            break;
                                        case 4:
                                            d2.setBackgroundResource(R.drawable.d4);
                                            break;
                                        case 5:
                                            d2.setBackgroundResource(R.drawable.d5);
                                            break;
                                        case 6:
                                            d2.setBackgroundResource(R.drawable.d6);
                                            break;
                                    }
                                    result.setText("더블! 한번 더 던지세요!\n"+diceresult+"칸 전진");
                                    check = true;
                                }
                            },750);
                        }
                        else {
                            int dicer1 = dicere1+1;
                            int dicer2 = dicere2+1;
                            final int diceresult = dicer1+dicer2;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dice1.setText(String.valueOf(dicere1+1));
                                    dice2.setText(String.valueOf(dicere2+1));
                                    switch (Integer.parseInt(String.valueOf(dice1.getText()))){
                                        case 1:
                                            d1.setBackgroundResource(R.drawable.d1);
                                            break;
                                        case 2:
                                            d1.setBackgroundResource(R.drawable.d2);
                                            break;
                                        case 3:
                                            d1.setBackgroundResource(R.drawable.d3);
                                            break;
                                        case 4:
                                            d1.setBackgroundResource(R.drawable.d4);
                                            break;
                                        case 5:
                                            d1.setBackgroundResource(R.drawable.d5);
                                            break;
                                        case 6:
                                            d1.setBackgroundResource(R.drawable.d6);
                                            break;
                                    }
                                    switch (Integer.parseInt(String.valueOf(dice2.getText()))){
                                        case 1:
                                            d2.setBackgroundResource(R.drawable.d1);
                                            break;
                                        case 2:
                                            d2.setBackgroundResource(R.drawable.d2);
                                            break;
                                        case 3:
                                            d2.setBackgroundResource(R.drawable.d3);
                                            break;
                                        case 4:
                                            d2.setBackgroundResource(R.drawable.d4);
                                            break;
                                        case 5:
                                            d2.setBackgroundResource(R.drawable.d5);
                                            break;
                                        case 6:
                                            d2.setBackgroundResource(R.drawable.d6);
                                            break;
                                    }
                                    result.setText(diceresult+"칸 전진\n ");
                                    check = true;
                                }
                            },750);
                        }
                    }

                }

                lastX = event.values[DATA_X];
                lastY = event.values[DATA_Y];
                lastZ = event.values[DATA_Z];
            }

        }

    }
}