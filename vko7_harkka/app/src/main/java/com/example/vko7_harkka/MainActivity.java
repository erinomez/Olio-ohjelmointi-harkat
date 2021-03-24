package com.example.vko7_harkka;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    //TextView text;
    //testi
    EditText inputText;
    TextView updateText;
    EditText enterUpdates;
    EditText file;
    EditText fileInput;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //text = (TextView) findViewById(R.id.teksti);
        //inputText = findViewById(R.id.input);
        //updateText = findViewById(R.id.teksti);
        enterUpdates = findViewById(R.id.input);
        //enterUpdates.setOnEditorActionListener(enterListener);
        file = findViewById(R.id.file);
        fileInput = findViewById(R.id.input);
        context = MainActivity.this;
    }

    public void load (View v) {
        String fileName = file.getText().toString();
        String input = "";
        try {
            InputStream iStream = context.openFileInput(fileName);
            BufferedReader buff = new BufferedReader(new InputStreamReader(iStream));
            String newLine;
            while ((newLine = buff.readLine()) != null) {
                input = input + newLine;
            }
            iStream.close();
            fileInput.setText(input);
        } catch (IOException e) {
            Snackbar.make(v, "Error: file not found", Snackbar.LENGTH_SHORT).show();
        }
    }

    public void save (View v) {
        String fileName = file.getText().toString();
        String input = fileInput.getText().toString();
        try {
            OutputStreamWriter oStream = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            oStream.write(input);
            Snackbar.make(v, "Input written to file", Snackbar.LENGTH_SHORT).show();
            oStream.close();
        } catch (IOException e) {
            Snackbar.make(v, "Error: file writing", Snackbar.LENGTH_SHORT).show();
        }
    }

    /*
    TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_ACTION_DONE) {
                String text = enterUpdates.getText().toString();
                updateText.setText(text);
                InputMethodManager manager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            return true;
        }
    }; */



        /*
    public void testFunction (View v) {
        //System.out.println("Hello World!");
        //text.setText("Hello World!");
        String text = inputText.getText().toString();
        updateText.setText(text);
    } */
}