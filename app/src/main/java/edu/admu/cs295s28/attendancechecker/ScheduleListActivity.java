package edu.admu.cs295s28.attendancechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_schedule_list)
public class ScheduleListActivity extends AppCompatActivity {

    @ViewById
    ListView list;

    @AfterViews
    public void init(){
        //generate the list of subject that he/she is enrolled or he/she teaches
    }
}
