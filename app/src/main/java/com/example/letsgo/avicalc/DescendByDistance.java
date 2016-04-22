package com.example.letsgo.avicalc;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;

/**
 * Created by lets go on 16-Apr-16.
 */
public class DescendByDistance extends Activity {
    EditText sa, ea, dist, gs;
    TextView da, dr;
    Button calc;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descendbydistance);

        sa = (EditText) findViewById(R.id.dbd_sa);
        ea = (EditText) findViewById(R.id.dbd_ea);
        dist = (EditText) findViewById(R.id.dbd_dist);
        gs = (EditText) findViewById(R.id.dbd_gs);
        calc = (Button) findViewById(R.id.dbd_calc);
        da = (TextView) findViewById(R.id.dbd_da);
        dr = (TextView) findViewById(R.id.dbd_ra);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double vsa, vea, vdist, vgs;
                DecimalFormat df = new DecimalFormat("##.##");
                DecimalFormat df2 = new DecimalFormat("####.##");

                vsa = Double.parseDouble(sa.getText().toString());
                vea = Double.parseDouble(ea.getText().toString());
                vdist = Double.parseDouble(dist.getText().toString());
                vgs = Double.parseDouble(gs.getText().toString());

                if (vsa > 0 && vea > 0 && vdist > 0 && vgs > 0) {
                    //to be corrected
                    da.setText(df.format((vsa - vea)/vdist/100));
                    dr.setText(df2.format(vgs/60*(vsa - vea)/vdist*100));

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Inputs", Toast.LENGTH_SHORT).show();
                    da.setText("");
                    dr.setText("");
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DescendByDistance Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.letsgo.avicalc/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DescendByDistance Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.letsgo.avicalc/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
