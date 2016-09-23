package com.cmpe277.farmmanager;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FarmManager extends AppCompatActivity {

    public static int temperature;
    private Button turnFanOn;
    private Button turnFanSprinklerOn;
    private String FAN_ON = "FAN_ON";
    private String FAN_SPRINKLER_ON = "FAN_SPRINKLER_ON";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_manager);
        turnFanOn = (Button) findViewById(R.id.TurnFanOn);
        turnFanSprinklerOn = (Button) findViewById(R.id.turnFanSprinklerOn);

    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(FarmManager.this, "Now the temperature is :" + temperature,
                Toast.LENGTH_LONG).show();
        if(temperature >  70 && temperature < 90){
            turnFanSprinklerOn.setVisibility(View.GONE);
        }else if(temperature >90 && temperature <125){
            turnFanOn.setVisibility(View.GONE);
        }
    }

    public void onTurnFanOn(View v){
        Intent intent = new Intent("poultry.farm.on.fan.sprinkler");
        intent.putExtra("iotMode", FAN_ON);
        sendBroadcast(intent);
    }

    public void onTurnFanSprinklerOn(View v){
        Intent intent = new Intent("poultry.farm.on.fan.sprinkler");
        intent.putExtra("iotMode", FAN_SPRINKLER_ON);
        sendBroadcast(intent);
    }
}
