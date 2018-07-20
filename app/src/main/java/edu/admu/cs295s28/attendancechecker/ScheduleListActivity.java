package edu.admu.cs295s28.attendancechecker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_schedule_list)
public class ScheduleListActivity extends AppCompatActivity {
    Intent intent;
    Realm realm;
   // Context c;

    @ViewById(R.id.list)
    ListView list;

    @AfterViews
    public void init(){
        //generate the list of subject that he/she is enrolled or he/she teaches
    //c = this;

        realm = Realm.getDefaultInstance();
        RealmResults<ScheduleData> dat = realm.where(ScheduleData.class).findAll();

        final MyRealmAdapter adapter = new MyRealmAdapter(this, dat);
        //put adapter to list
        list.setAdapter(adapter);
    }
}
