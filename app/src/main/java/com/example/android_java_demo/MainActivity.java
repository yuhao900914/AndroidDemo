package com.example.android_java_demo;

import android.os.Bundle;

//import com.amplitude.api.Amplitude;
import com.amplitude.api.PinnedAmplitudeClient;
//import com.amplitude.api.AmplitudeServerZone;
import com.amplitude.api.PinnedAmplitudeClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
//import com.amplitude.api.Identify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("%%%%%%%%%%%%%%%%");
        /**
         * For eu no pinned
        //PinnedAmplitudeClient client = PinnedAmplitudeClient.getInstance();
        //client.initialize( getApplicationContext(), "82b148f7211db7f9ccaff8048d0f7192").enableForegroundTracking(getApplication());
        Amplitude.getInstance().initialize( getApplicationContext(), "c0a948f5079f93613d53996b3c334191");
        Amplitude.getInstance().trackSessionEvents(true).enableForegroundTracking(getApplication());
        Amplitude.getInstance().setServerZone(AmplitudeServerZone.EU);
        // For earlier versions
        Amplitude.getInstance().setServerUrl("https://api.eu.amplitude.com");
        //client.setServerUrl("https://ssltest.amplitude.com/");
        Amplitude.getInstance().logEvent("app: main activity");
         */

        PinnedAmplitudeClient client = PinnedAmplitudeClient.getInstance();
        //82b148f7211db7f9ccaff8048d0f7192
        //c0a948f5079f93613d53996b3c334191
        client.initialize( getApplicationContext(), "123");
        client.trackSessionEvents(true).enableForegroundTracking(getApplication());
        //client.setServerZone(AmplitudeServerZone.EU);
        client.logEvent("event in load");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Amplitude.getInstance().logEvent("on click listner");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}