package com.nanotricks.bt.broadcastiot;

import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ir";
    private static final int FREQ = 47000;
    private static final int[] SEQON = {123,339,23,54,23,14,23,16,21,14,21,16,21,14,23,16,21,16,21,14,23,53,23,15,22,16,21,54,23,14,23,16,21,16,21,54,23,54,23,53,23,54,23,14,23,54,23,14,23,54,22,54,23,16,21,16,21,14,23,14,23,16,21,16,21,54,23,54,23,15,22,15,22,14,23,14,23,14,23,14,23,53,23,54,23,14,23,14,23,16,21,54,23,14,23,16,21,14,23,16,21,14,23,16,21,14,23,53,23,53,23,54,23,54,23,2500};
    private static final int[] SEQOFF = {123,339,23,54,23,14,23,16,21,14,21,16,21,14,23,16,21,16,21,14,23,53,23,15,22,16,21,54,23,14,23,16,21,16,21,54,23,54,23,53,23,54,23,14,23,54,23,14,23,54,22,54,23,16,21,16,21,14,23,14,23,16,21,16,21,54,23,54,23,15,22,15,22,14,23,14,23,14,23,14,23,53,23,54,23,14,23,14,23,16,21,54,23,14,23,16,21,14,23,16,21,14,23,16,21,14,23,53,23,53,23,54,23,54,23,2500};
    String choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConsumerIrManager manager = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);
        Log.d("Works",":"+manager.hasIrEmitter());
        if(getIntent().hasExtra("dcall")) {
            choice = getIntent().getStringExtra("dcall");

        if(manager.hasIrEmitter()){
            if(choice.equals("on")) {
                manager.transmit(FREQ, SEQON);
                this.finish();

                Toast.makeText(getApplicationContext(), "Call on Going", Toast.LENGTH_LONG).show();
            }
            else
            {
                manager.transmit(FREQ, SEQOFF);
                this.finish();
                Toast.makeText(getApplicationContext(), "Continue Charging", Toast.LENGTH_LONG).show();
            }
        }
        else{
            this.finish();
        }
    }
    }
}
