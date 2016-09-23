package com.cmpe277.farmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GetValueBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("poultry.farm.current.temperature")) {
            FarmManager.temperature = intent.getExtras().getInt("TEMPERATURE");
            Intent Farmintent = new Intent(context,FarmManager.class);
            Farmintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(Farmintent);

        }

    }
}
