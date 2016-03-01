package com.example.bashayer93.blue;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView tvUIDS;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUIDS = (TextView)findViewById(R.id.tv_uids);
        StringBuilder sb = new StringBuilder();

        TelephonyManager telMan = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);

        sb.append("IMEI:" + telMan.getDeviceId() + "\n");

        sb.append("Android ID" + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID + "\n"));

        WifiManager wm =(WifiManager) getSystemService(Context.WIFI_SERVICE);

        String mac_adr = wm.getConnectionInfo().getMacAddress();
        if(mac_adr != null) {

            sb.append("WLAN MAC Address:" + mac_adr + "\n");


        }
        else
        {
            sb.append("WLAN MAC Address: not supported on this device \n");
        }
        BluetoothAdapter ba =BluetoothAdapter.getDefaultAdapter();
        if(ba !=null){
            sb.append("blueTooth Adress:" + ba.getAddress() +"\n" );


        }else {   sb.append("blueTooth Adress: not supported by this device \n" );
        }

        tvUIDS.setText(sb.toString());
    }
}