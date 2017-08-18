package com.example.sandy.lyricstocode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

String s="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv1 = (TextView) findViewById(R.id.newtv);
        TextView tv2 = (TextView) findViewById(R.id.maintv);
        String puchuk1 = getIntent().getStringExtra("lala");
        String pachak = getIntent().getStringExtra("xoxo");
        String type = getIntent().getStringExtra("type");
        String puchuk = puchuk1.replaceAll("[\\t\\n\\r\\s]+"," ");
        String[] reval = puchuk.split(" ");
        for (String t : puchuk.split(" "))
        {
            s += t.charAt(0);
        }
        s = s.toUpperCase();

        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            if (((int) s.charAt(i)) >= 65 && ((int) s.charAt(i)) <= 72) {
                s1 = s1.concat("0");
            }

            if (((int) s.charAt(i)) >= 73 && ((int) s.charAt(i)) <= 80) {
                s1 = s1.concat("1");
            }

            if (((int) s.charAt(i)) >= 81 && ((int) s.charAt(i)) <= 90) {
                s1 = s1.concat("*");
            }
        }
        tv1.append("\n\n\n"+s1);

        switch(type) {
            case "n": {

                for (int index = s1.indexOf(pachak); index >= 0; index = s1.indexOf(pachak, index + 1)) {
                    tv2.append("\n\n" + index);
                    String key = s.substring(index, index + pachak.length());
                    tv2.append("\n"+key+"\n");
                    for (int j = index; j < (index + pachak.length()); j++) {
                        tv2.append(reval[j] + " ");
                    }
                }
            }
            ;

            case "l": {
                for (int index = s.indexOf(pachak); index >= 0; index = s.indexOf(pachak, index + 1)) {
                    tv2.append("\n\n" + index);
                    String key = s.substring(index, index + pachak.length());
                    tv2.append("\n"+key+"\n");
                    for (int j = index; j < (index + pachak.length()); j++) {
                        tv2.append(reval[j] + " ");
                    }
                }
            }
            ;
        }
    }



}
