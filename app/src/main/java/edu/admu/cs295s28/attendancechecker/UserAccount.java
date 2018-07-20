package edu.admu.cs295s28.attendancechecker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

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

    @Extra
    String uid;

    @AfterViews
    public void init(){

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

    @Click(R.id.btnList)
    public void subjectList(){
        ScheduleListActivity_.intent(this).start();
    }
}
