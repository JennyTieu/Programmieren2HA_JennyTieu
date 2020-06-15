package de.haw_hamburg.dailymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private String currentDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,
                        AddEntryActivity.class);
                startActivity(intent);
            }
        });

        CalendarView calenderView = findViewById(R.id.calendarView);
        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                currentDate =dayOfMonth+"/"+month+"/"+year;
            }

        });
        Object obj = ReadService.readObject(MainActivity.this);
        if(obj != null){
            if (!(obj instanceof Event)){
                obj= (Event) obj;

                //Log.i("MainEntry",eventObject.toString());

            }
            calenderView.setDate(((Event)obj).getStartTime().getTimeInMillis());
            Log.i("MainEntry",obj.toString());
        }


    }
}
