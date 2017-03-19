package com.example.sanyam.counterapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Switch s;
    TextView tv;
    Button b1,b2;
    int counterVar = 0;
    SharedPreferences sharedpreferences;
    static final String MyPREFERENCES = "MyPrefs" ;
    public static final String totalCount = "tc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView2);
        s = (Switch) findViewById(R.id.switch1);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //final String countt = "countt";



        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( s.isChecked() ){
                    s.setText("Enabled");
                    b1.setEnabled(true);
                }
                else{
                    s.setText("Disabled");
                    b1.setEnabled(false);
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterVar++;
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(totalCount,counterVar+"");
                tv.setText(counterVar+"");
                editor.commit();
            }
        });

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(totalCount,counterVar+"");
        tv.setText(counterVar+"");
        editor.commit();

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counterVar = 0;
                tv.setText(0+"");
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                Toast.makeText(MainActivity.this, "game", Toast.LENGTH_SHORT).show();
                //newGame();
                return true;
            case R.id.help:
                Toast.makeText(MainActivity.this, "help", Toast.LENGTH_SHORT).show();
                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}