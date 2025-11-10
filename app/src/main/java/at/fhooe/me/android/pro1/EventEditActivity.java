package at.fhooe.me.android.pro1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;

    private LocalTime time;
    private Spinner eventType;
    private String type;
    private String opponent;
    private String location;
    private String meetingpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Datum: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));


    }

    private void initWidgets() {
        eventType = findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.type,
                android.R.layout.simple_spinner_item // Standard Android-Layout
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eventType.setAdapter(adapter);
        eventType.setOnItemSelectedListener(this);

        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        type = eventType.getSelectedItem().toString();
        location = findViewById(R.id.event_locationTV).toString();
        meetingpoint = findViewById(R.id.event_meetingpointTV).toString();


        opponent = findViewById(R.id.event_opponentTV).toString();


    }

    public void saveEventAction(View view) {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time, opponent, type, meetingpoint, location);
       Event.eventsList.add(newEvent);

        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.type = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.type = "Training";
    }

    public void onClickBox(View view) {

        CheckBox box = findViewById(R.id.type_checkbox);

        if (box.isChecked()) {

            TextView opp = findViewById(R.id.event_opponent_slogan);
            TextView opptv = findViewById(R.id.event_opponentTV);
            TextView loc = findViewById(R.id.event_location_slogan);
            TextView loctv = findViewById(R.id.event_locationTV);
            TextView meet = findViewById(R.id.event_meetingpoint_slogan);
            TextView meettv = findViewById(R.id.event_meetingpointTV);
            if (type.equals("Spiel")) {
                opp.setVisibility(View.VISIBLE);
                opptv.setVisibility(View.VISIBLE);
                loc.setVisibility(View.VISIBLE);
                loctv.setVisibility(View.VISIBLE);
                meet.setVisibility(View.VISIBLE);
                meettv.setVisibility(View.VISIBLE);

            }

            if (type.equals("Training")) {
                opp.setVisibility(View.INVISIBLE);
                opptv.setVisibility(View.INVISIBLE);
                loc.setVisibility(View.INVISIBLE);
                loctv.setVisibility(View.INVISIBLE);
                meet.setVisibility(View.INVISIBLE);
                meettv.setVisibility(View.INVISIBLE);
            }
        }
    }
}