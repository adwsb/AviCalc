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
 * Created by lets go on 16-Apr-16.
 */
public class Crosswind extends Activity {
    EditText achdg,windhdg,windvel;
    Button calc;
    TextView cw,hw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crosswind);

        achdg=(EditText)findViewById(R.id.cw_ac_hdg);
        windhdg=(EditText)findViewById(R.id.cw_wind_hdg);
        windvel=(EditText)findViewById(R.id.cw_wind_spd);
        calc=(Button)findViewById(R.id.cw_calc);
        cw=(TextView)findViewById(R.id.cw_cw);
        hw=(TextView)findViewById(R.id.cw_hw);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double vachdg,vwindhdg,vwindvel,vcw,vhw;
                DecimalFormat df = new DecimalFormat("00.0");

                vachdg=Double.parseDouble(achdg.getText().toString());
                vwindhdg=Double.parseDouble(windhdg.getText().toString());
                vwindvel=Double.parseDouble(windvel.getText().toString());

                if(vachdg>=0 && vachdg<=360 && vwindhdg>=0 && vwindhdg<=360){
                    vcw=Math.abs(vwindvel*Math.sin(Math.toRadians(vachdg-vwindhdg)));
                    vhw=vwindvel*Math.cos(Math.toRadians(vachdg-vwindhdg));

                    cw.setText(df.format(vcw));
                    hw.setText(df.format(vhw));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Heading(s)",Toast.LENGTH_SHORT).show();
                    cw.setText("");
                    hw.setText("");
                }
            }
        });

    }
}
