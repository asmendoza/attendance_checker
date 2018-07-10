package edu.admu.cs295s28.attendancechecker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_account)
public class UserAccount extends AppCompatActivity {

    @ViewById(R.id.button)
    Button login;

    @Click(R.id.button)
    public void generateQR(){
        GenerateQR_.intent(this).start();
    }
    @Click(R.id.button2)
    public void summary(){
        AttendanceSummary_.intent(this).start();
    }


   /* public void readQr(View view){
        Intent intent=new Intent(MainActivity.this,QrRead.class);
        startActivity(intent);
    }
    public void generateQr(View view){
        Intent intent=new Intent(this,GenerateQR.class);
        startActivity(intent);
    }*/
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
    }*/
}
