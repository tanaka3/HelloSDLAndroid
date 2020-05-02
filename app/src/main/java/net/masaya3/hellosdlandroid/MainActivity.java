package net.masaya3.hellosdlandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //If we are connected to a module we want to start our SdlService
        if(BuildConfig.TRANSPORT.equals("MULTI") || BuildConfig.TRANSPORT.equals("MULTI_HB")) {
            SdlReceiver.queryForConnectedService(this);
        }else if(BuildConfig.TRANSPORT.equals("TCP")) {
            Intent proxyIntent = new Intent(this, SdlService.class);
            startService(proxyIntent);
        }
    }
}
