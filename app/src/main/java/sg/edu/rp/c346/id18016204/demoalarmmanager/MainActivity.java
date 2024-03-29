package sg.edu.rp.c346.id18016204.demoalarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSetAlarm ;
    AlarmManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetAlarm = findViewById(R.id.btnAlarm);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                //create new pendingIntent and add it to the alarm manager
                Intent intent = new Intent(MainActivity.this, AlarmReceiverActivity.class);
                int reqCode =  12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, reqCode,intent, PendingIntent.FLAG_CANCEL_CURRENT);

                // get Alarm manager instance
                am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);

                // set the alarm
                am.set(AlarmManager.RTC_WAKEUP , cal.getTimeInMillis(), pendingIntent);
            }
        });
    }
}