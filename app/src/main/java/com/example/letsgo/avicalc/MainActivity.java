package com.example.letsgo.avicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Intent i1,i2,i3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView);

        i1=new Intent(this,Crosswind.class);
        i2=new Intent(this,DescendByDistance.class);
        i3=new Intent(this,Drift.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0: startActivity(i1);
                       break;
                   case 1: startActivity(i2);
                       break;
                   case 2:  startActivity(i3);
               }
            }
        });
    }
}
