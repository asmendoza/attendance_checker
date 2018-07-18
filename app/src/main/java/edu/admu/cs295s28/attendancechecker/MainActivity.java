package edu.admu.cs295s28.attendancechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById(R.id.button)
    Button login;

    @ViewById(R.id.button2)
    Button register;

    @Click(R.id.button2)
    public void register(){
        RegisterActivity_.intent(this).start();
    }


    @Click(R.id.button)
    public void login(){
    UserAccount_.intent(this).start();
    }

    /*@ViewById(R.id.btnMaps)
    Button btnMaps;*/

   /* @Click(R.id.btnMaps)
    public void OpenMap(){
        MapsActivity_.intent(this).start();
    }*/
}
