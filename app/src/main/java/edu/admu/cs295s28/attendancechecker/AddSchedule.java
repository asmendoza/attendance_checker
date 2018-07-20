package edu.admu.cs295s28.attendancechecker;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import java.io.File;

@EActivity(R.layout.activity_add_schedule)
public class AddSchedule extends AppCompatActivity {

    Intent intent;
    Realm realm;
    Toast toast;
    Context c;

    @ViewById(R.id.txtSubject)
    EditText txtSubject;

    @ViewById(R.id.txtDesc)
    EditText txtDesc;

    @ViewById(R.id.txtTime)
    EditText txtTime;

    @ViewById(R.id.sprday)
    Spinner sprday;

    @ViewById(R.id.txtSY)
    EditText txtSY;

    @ViewById(R.id.txtLat)
    TextView txtLat;

    @ViewById(R.id.txtLong)
    TextView txtLong;

    @ViewById(R.id.btnAdd)
    Button btnAdd;

    @ViewById(R.id.btnCancel)
    Button btnCancel;

    @ViewById(R.id.btnMaps)
    Button btnMaps;

    @AfterViews
    public void init(){

    }

    @Click(R.id.btnMaps)
    public void maps(){
        //click to go to the maps then from the MapsActivity user will set the mark
        // and will go back to this class and lat and lon will appear to the TextView and will save to the DB
        MapsActivity_.intent(this).start();
    }

    @Click(R.id.btnAdd)
    public void add() {
       /* if (txtSubject.getText().toString().trim().length() <= 0) {
            toast = Toast.makeText(c, "Subject is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }

        if (txtDesc.getText().toString().trim().length() <= 0) {
            toast = Toast.makeText(c, "Subject Description is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }

        if (txtTime.getText().toString().trim().length() <= 0) {
            toast = Toast.makeText(c, "Time is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }


        if (txtSY.getText().toString().trim().length() <= 0) {
            toast = Toast.makeText(c, "S.Y. is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }


        if (!MyRealm.isNetworkAvailable(this)) {
            Snackbar.make(btnAdd, "No internet connection detected. Try again later."
                    , Snackbar.LENGTH_SHORT)
                    .show();
            return;
        }*/

        //not sure how it works
       /* final String subj = txtSubject.getText().toString();
        final String desc = txtDesc.getText().toString();
        final String time = txtTime.getText().toString();
        final String day = sprday.getSelectedItem().toString();
        final String sy = txtSY.getText().toString();
        final String lat = txtLat.getText.toString();
        final String lon = txtLong.getText.toString();

        realm = MyRealm.getRealm();

                    ScheduleData subject;
                    subject = new ScheduleData();
                    subject.setSubject_title(subj);
                    subject.setSubject_desc(desc);
                    subject.setSubject_time(time);
                    subject.setSubject_day(day);
                    subject.setSubject_sy(sy);
                    realm.beginTransaction();
                    realm.copyToRealm(subject);
                    realm.commitTransaction();

                    toast = Toast.makeText(c, "New subject has been saved", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    onBackPressed();
*/
    }
}



