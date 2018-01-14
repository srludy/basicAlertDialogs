package com.example.jose.test_dialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    Button btn_date, btn_time, btn_color;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView   txt_date, txt_hora, txt_color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_color = (Button) findViewById(R.id.btn_color);
        btn_time = (Button) findViewById(R.id.btn_time);
        btn_date = (Button) findViewById(R.id.btn_date);

        txt_date = (TextView) findViewById(R.id.textView);
        txt_hora = (TextView) findViewById(R.id.textView2);
        txt_color = (TextView) findViewById(R.id.textView3);


        datePickerDialog  = new DatePickerDialog(this);
        timePickerDialog  = new TimePickerDialog(this, this, 10, 30, true);



        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.updateDate(2018, 0, 6);
                datePickerDialog.show();

                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date;
                        date = year+"/";

                        if(String.valueOf(month).length() != 2){
                            date = date+0+(month+1)+"/";
                        }else{
                            date = date+(month+1)+"/";
                        }

                        if(String.valueOf(dayOfMonth).length() != 2){
                            date = date+0+dayOfMonth;
                        }else{
                            date = date+dayOfMonth;
                        }
                        txt_date.setText(date);
                    }
                });

            }
        });

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final String[] arrayColors = {
                        "Rojo",
                        "Verde",
                        "Amarillo",
                };
                AlertDialog.Builder colorsDialog = new AlertDialog.Builder(MainActivity.this);
                colorsDialog.create();
                colorsDialog.setTitle("Escoge un Color").setItems(arrayColors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                           String selected = arrayColors[which];
                           txt_color.setText(selected);
                    }
                });
                colorsDialog.show();
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String hour = "";
        Toast.makeText(getApplicationContext(),String.valueOf(hourOfDay),Toast.LENGTH_LONG).show();
        if(String.valueOf(hourOfDay).length() != 2){
            hour = "0"+hourOfDay+":";
        }else{
            hour = hourOfDay+":";
        }

        if(String.valueOf(minute).length() != 2){
            hour = hour+0+minute;
        }else{
            hour = hour+minute;
        }

        txt_hora.setText(hour);
    }
}
