package edu.admu.cs295s28.attendancechecker;

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

public class MyRealmAdapter extends RealmBaseAdapter<UserScheduleData>  implements ListAdapter {
private ScheduleListActivity activity;
Realm realm;
UserScheduleData d;


    public MyRealmAdapter(ScheduleListActivity activity, OrderedRealmCollection<UserScheduleData> data) {
        super(data);
        this.activity = activity;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //if (convertView == null) {
        View view = activity.getLayoutInflater().inflate(R.layout.row_usersched,null);
        //viewHolder = new ViewHolder();

        final TextView titleField = view.findViewById(R.id.txtSubject);
        final TextView descField = view.findViewById(R.id.txtDesc);

        d = adapterData.get(position);

        Button btnGenerate = view.findViewById(R.id.btnGenerate);
        btnGenerate.setTag(d);
        //btnEdit.setId(d.getId());
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnScan = view.findViewById(R.id.btnScan);
        //position of the data
        btnScan.setTag(d);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       /* titleField.setText(d.gets());
        descField.setText(d.getPassword());*/

        return view;
    }
}
