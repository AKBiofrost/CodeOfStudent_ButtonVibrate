package com.example.codeofstudent_1_buttonvibrate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //declare Android Vibrator API
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        //System.out.println(c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time

        Toast.makeText(this, formattedDate, Toast.LENGTH_LONG).show();
        // iniciar UI Button

        //init UI Button
        Button vibrateBtn = findViewById(R.id.button);

        //init Android Vibrator API
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        //handle button click, vibrate phone for 1000 microsecs (1 second)
        vibrateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(1000);
                }
            }
        });




    }
}
