package de.haw_hamburg.dailymanager;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Button;

import java.util.Date;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddEntryActivity extends AppCompatActivity {
    private static final String TAG ="AddEntry";
    private int pDay,pMonth,pYear;
    TimePickerDialog picker;
    EditText eText;
    String savedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Spinner spinner = findViewById(R.id.spinner);
        String[] arraySpinner = new String[] {
                "keine", "15 min vorher", "1 Stunde vorher", "morgens um 08:00", "1 Tag vorher"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        eText=(EditText) findViewById(R.id.editText2);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final Calendar cldr = Calendar.getInstance();
                int hour=cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                picker= new TimePickerDialog(AddEntryActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        if(sHour<10) {
                            if(sMinute>9) {
                                eText.setText("0" + sHour + ":" + sMinute);
                            }
                            else {
                                eText.setText("0"+sHour+":0"+sMinute);
                            }
                        }

                        else if(sHour>9){
                            if(sMinute>9){
                                eText.setText(sHour+":"+sMinute);
                            }
                            else{
                                eText.setText(sHour+":0"+sMinute);
                            }
                        }
                    }
                    },hour,minutes,true);
                picker.show();

            }

        });

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                pDay =dayOfMonth;
                pMonth=month;
                pYear=year;
            }
        });

        final Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                EditText time = findViewById(R.id.editText2);
                savedTime=time.getText().toString();
                String[] timeArray= savedTime.split(":");
                int pHour=Integer.parseInt(timeArray[0]);
                int pMinute=Integer.parseInt(timeArray[1]);

                EditText name = findViewById(R.id.editText5);
                String eventName=name.getText().toString();

                Event newEvent = new Event( pYear, pMonth, pDay,  pHour, pMinute, eventName);

                EditText location = findViewById(R.id.editText6);
                newEvent.setLocation(location.getText().toString());
                EditText note = findViewById(R.id.editText7);
                newEvent.setNote(note.getText().toString());
                Spinner spinner = findViewById(R.id.spinner);
                newEvent.setRemindOption(spinner.getSelectedItem().toString());


                Log.i("AddEntry",newEvent.toString());


                WriterService.writeObject(AddEntryActivity.this, newEvent);

                startActivity(intent);
            }
        });


        }

}
