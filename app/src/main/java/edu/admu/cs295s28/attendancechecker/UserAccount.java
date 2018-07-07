package edu.admu.cs295s28.attendancechecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_account)
public class UserAccount extends AppCompatActivity {

    @ViewById(R.id.button)
    Button login;

    @Click(R.id.button2)
    public void summary(){
        AttendanceSummary_.intent(this).start();
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
    }*/
}
