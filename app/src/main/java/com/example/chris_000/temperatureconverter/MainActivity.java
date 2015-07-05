package com.example.chris_000.temperatureconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    private EditText tempUserInput;
    private Button fbutton;
    private Button cbutton;
    private TextView result;

    DecimalFormat round = new DecimalFormat("0.0"); //round makes it so that only show one decimal point for double

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempUserInput = (EditText) findViewById(R.id.editTextId);
        fbutton = (Button) findViewById(R.id.fbuttonId);
        cbutton = (Button) findViewById(R.id.cbuttonId);
        result = (TextView) findViewById(R.id.convertedTextViewId);

        fbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String userInput = tempUserInput.getText().toString();
                int userInputvalue = 0;
                int fahrenheit = 0;
                if (userInput.isEmpty()) {
                    //enter text to notify user did not enter valid input
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else{
                    userInputvalue = Integer.parseInt(userInput);
                    fahrenheit = fahrenheitConverter(userInputvalue);
                    result.setText("Converted: " + round.format(fahrenheit) + " F"); //or make it = String.valueOf(fahrenheit); because you need the parameter to be type String
                    tempUserInput.setText("");
                }
            }
        });

        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = tempUserInput.getText().toString();
                int userInputvalue = 0;
                int celsius = 0;
                if (userInput.isEmpty()) {
                    //enter text to notify user did not enter valid input
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else{
                    userInputvalue = Integer.parseInt(userInput);
                    celsius = celsiusConverter(userInputvalue);
                    result.setText("Converted: " + celsius + " C"); //or make it = String.valueOf(celsius); because you need the parameter to be type String
                    tempUserInput.setText("");
                }
            }
        });
    }

    public int fahrenheitConverter(int num) {
        return (9/5)*num +32;
    }

    public int celsiusConverter(int num) {
        return (5/9)*(num-32);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
