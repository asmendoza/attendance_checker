package edu.admu.cs295s28.attendancechecker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.SyncCredentials;
import io.realm.SyncUser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



@EActivity(R.layout.activity_user_account)
public class UserAccount extends AppCompatActivity {

    /*@ViewById(R.id.btnGenerate)
    Button btnGenerate;
    @ViewById(R.id.btnScan)
    Button btnScan;*/

    @ViewById(R.id.imageView)
    ImageView imageView;

    @ViewById(R.id.txtuID)
    TextView txtuID;

    @ViewById(R.id.txtname)
    TextView txtname;

    @ViewById(R.id.txtemail)
    TextView txtemail;

    @ViewById(R.id.txtcontact)
    TextView txtcontact;

    @ViewById(R.id.btnUpdate)
    Button btnUpdate;

    @ViewById(R.id.btnList)
    Button btnList;

    @ViewById(R.id.btnSchedule)
    Button btnSchedule;

    @ViewById(R.id.btnScheduleList)
    Button btnScheduleList;

    Realm realm;
    Picasso picasso;
    File savedImage;
    Intent intent;
    Toast toast;
    Context c;
    boolean editMode;
    boolean hasSavedImage;
    @Extra
    String uid;
    UserData usr;

    @AfterViews
    public void init(){
        picasso = Picasso.get();

        realm = MyRealm.getRealm();
        usr = realm.where(UserData.class).equalTo("user_id", uid).findFirst();

        txtuID.setText(usr.getUser_id());
        txtname.setText(usr.getName());
        txtemail.setText(usr.getEmail());
        txtcontact.setText(usr.getContact_num());
        savedImage = new File(usr.getAvatarpath());

        if(savedImage.exists()){
            refreshImageView(savedImage);
        }

        switch (usr.getUser_type()) {
            case "Student":
                btnSchedule.setVisibility(View.GONE);
                break;
            case "Teacher":
                btnSchedule.setVisibility(View.VISIBLE);
                break;
        }

    }
   /* @Click(R.id.btnGenerate)
    public void generateQR(){
        GenerateQR_.intent(this).start();
    }

    public void readQr(View view){
        Intent intent=new Intent(this,QRScan.class);
        startActivity(intent);
    }*/

    @Click(R.id.btnUpdate)
    public void updateAccount(){

    }

    @Click(R.id.btnSchedule)
    public void addSched(){
        AddSchedule_.intent(this).start();
    }
    @Click(R.id.btnList)
    public void subjectList(){
        ScheduleListActivity_.intent(this).start();
    }
    @Click(R.id.btnScheduleList)
    public void studentsubjectList(){
        ScheduleListActivity_.intent(this).start();
    }

    private void refreshImageView(File savedImage) {

        picasso.load(savedImage).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
    }

    private void refreshImageView(int savedImage) {

        picasso.load(savedImage).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
    }
}
