package edu.admu.cs295s28.attendancechecker;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.io.File;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

public class MyRealmAdapter extends RealmBaseAdapter<ScheduleData>  implements ListAdapter {

    OrderedRealmCollection<ScheduleData> realmResults;
    Activity activity;

   /* private ScheduleListActivity activity;
Realm realm;
ScheduleData d;*/


    public MyRealmAdapter(Activity activity, OrderedRealmCollection<ScheduleData> realmResults) {
        super(realmResults);
        this.activity = activity;
        this.realmResults = realmResults;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = null;
        if (convertView==null) {
            view = activity.getLayoutInflater().inflate(R.layout.row_usersched, null    );
        }
        else {
            view = convertView;
        }

        final TextView titleField = view.findViewById(R.id.txtSubject);
        final TextView descField = view.findViewById(R.id.txtDesc);

       ScheduleData sd = realmResults.get(position);

        Button btnGenerate = view.findViewById(R.id.btnGenerate);
        btnGenerate.setTag(sd);
        //btnEdit.setId(d.getId());
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnScan = view.findViewById(R.id.btnScan);
        //position of the data
        btnScan.setTag(sd);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        titleField.setText(sd.getSubject_title());
        descField.setText(sd.getSubject_desc());

        return view;
    }
}
