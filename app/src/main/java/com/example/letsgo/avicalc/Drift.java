package com.example.letsgo.avicalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by lets go on 17-Apr-16.
 */
public class Drift extends Activity{

    EditText tas,achdg,windhdg,windvel;
    TextView drift;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drift);

        tas=(EditText)findViewById(R.id.drift_tas);
        achdg=(EditText)findViewById(R.id.drift_ac_hdg);
        windhdg=(EditText)findViewById(R.id.drift_wind_hdg);
        windvel=(EditText)findViewById(R.id.drift_wind_spd);
        calc=(Button)findViewById(R.id.drift_calc);
        drift=(TextView)findViewById(R.id.drift_drift);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double vtas,vachdg,vwindhdg,vwindvel;

                vtas=Double.parseDouble(tas.getText().toString());
                vachdg=Double.parseDouble(achdg.getText().toString());
                vwindhdg=Double.parseDouble(windhdg.getText().toString());
                vwindvel=Double.parseDouble(windvel.getText().toString());

                if(vtas>0 && vachdg>=0 && vachdg<=360 && vwindhdg>=0 && vwindhdg<=360 && vwindvel>0){
                    double vcw,vdrift;
                    DecimalFormat df = new DecimalFormat("###.#");

                    vcw=Math.abs(vwindvel*Math.sin(Math.toRadians(vachdg-vwindhdg)));
                    vdrift=60/vtas*vcw;

                    drift.setText(df.format(vdrift));

                }else {
                    Toast.makeText(getApplicationContext(),"Invalid Input(s)",Toast.LENGTH_SHORT).show();
                    drift.setText("");
                }
            }
        });
    }
}
