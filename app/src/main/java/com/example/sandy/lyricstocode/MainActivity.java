package com.example.sandy.lyricstocode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public String x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.numbers:
                if (checked)
                    x = "n";
                    break;
            case R.id.letters:
                if (checked)
                    x = "l";
                    break;
        }


        Button eval = (Button) findViewById(R.id.eval);

        eval.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText song = (EditText) findViewById(R.id.name_field);
                Editable s = song.getText();
                String songString = s.toString();

                EditText code = (EditText) findViewById(R.id.name_field1);
                Editable c = code.getText();
                String codeString = c.toString();

                Intent resultIntent = new Intent(MainActivity.this , ResultActivity.class);
                resultIntent.putExtra("lala",songString);
                resultIntent.putExtra("xoxo",codeString);
                resultIntent.putExtra("type",x);
                startActivity(resultIntent);
            }
        });


    }
}
