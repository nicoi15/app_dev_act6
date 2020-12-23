package com.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView lbl_date, lbl_time;
    Spinner spin_version;
    Button btn_click;
    String ver = "", date_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbl_time = findViewById(R.id.lblTime);
        lbl_date = findViewById(R.id.lblDate);
        spin_version = findViewById(R.id.spinVersion);
        btn_click = findViewById(R.id.btnChoose);

        String[] android_version = getResources().getStringArray(R.array.version);
        ArrayAdapter<String> version_adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android_version);
        spin_version.setAdapter(version_adapter);

        String date = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(new Date());
        lbl_date.setText(date);

        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        date_time = time.format(calendar.getTime());


        btn_click.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btn_click) {
            ver = spin_version.getSelectedItem().toString();
            Toast.makeText(this, "Congrats!! You choose: " + ver, Toast.LENGTH_LONG).show();

        }
    }
}