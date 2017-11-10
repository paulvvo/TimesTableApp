package com.example.sleepy.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> timesTableList = new ArrayList<Integer>(asList(1,2,3,4,5,6,7,8,9,10,11,12));
        final ListView timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        final  ArrayAdapter arrAdapt = new ArrayAdapter(this,android.R.layout.simple_list_item_1,timesTableList);

        timesTableListView.setAdapter(arrAdapt);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                if(progress<1){
                    progress = min;
                    seekBar.setProgress(min);
                }

                Log.i("Info", Integer.toString(progress));

                for(int i=0; i<timesTableList.size(); i++){
                    timesTableList.set(i, i+1);
                    timesTableList.set(i, timesTableList.get(i)*progress);
                }
                timesTableListView.setAdapter(arrAdapt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*timesTableListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                timesTableList.set(0, 6);
                timesTableListView.setAdapter(arrAdapt);
            }
        });*/
    }
}
