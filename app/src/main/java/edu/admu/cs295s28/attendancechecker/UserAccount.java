package edu.admu.cs295s28.attendancechecker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_account)
public class UserAccount extends AppCompatActivity {

    @ViewById(R.id.button)
    Button generate;
    @ViewById(R.id.button2)
    Button scan;
    @ViewById(R.id.button3)
    Button update;
    @ViewById(R.id.button4)
    Button summary;

    @Extra
    String uid;

    @Click(R.id.button)
    public void generateQR(){
        GenerateQR_.intent(this).start();
    }

    public void readQr(View view){
        Intent intent=new Intent(this,QRScan.class);
        startActivity(intent);
    }

    @Click(R.id.button3)
    public void updateAccount(){

    }

    @Click(R.id.button4)
    public void summary (){
        AttendanceSummary_.intent(this).start();
    }
}
