package com.example.sanyam.counterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Switch s;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView2);
        s = (Switch) findViewById(R.id.switch1);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( s.isChecked() ){
                    s.setText("Enabled");
                }
                else{
                    s.setText("Disabled");
                }

            }
        });

    }
}