package edu.admu.cs295s28.attendancechecker;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_attendance_summary)
public class AttendanceSummary extends AppCompatActivity {

    @ViewById (R.id.list)
    ListView list;

    @AfterViews
    public void init (){


    }
}
