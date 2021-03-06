package edu.admu.cs295s28.attendancechecker;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import static android.content.Context.MODE_PRIVATE;


@EActivity(R.layout.activity_main)
public class LoginActivity extends AppCompatActivity {
    Toast toast;
    Realm realm;
    Context c;
    RealmResults<UserData> user;
    String userID;
    String pword;
    SharedPreferences prefs;

    @ViewById(R.id.editText)
    EditText txtstudentID;
    @ViewById(R.id.editText2)
    EditText txtPassword;

    @ViewById(R.id.switch2)
    Switch rememberMe;

    @ViewById(R.id.button)
    Button login;
    @ViewById(R.id.button2)
    Button register;


    @AfterViews
    public void init() {
        c = this;
        prefs = getSharedPreferences("UserData",MODE_PRIVATE);
        if (prefs.getBoolean("RememberMe", false)) {
            txtstudentID.setText(prefs.getString("LastUser", null));
            txtPassword.setText(prefs.getString("LastPass", null));
            rememberMe.setChecked(true);
        }
    }

    @Click(R.id.button2)
    public void register(){
        RegisterActivity_.intent(this).start();
    }


    @Click(R.id.button)
    public void login(){
        if(txtstudentID.getText().toString().trim().length() <= 0){
            toast = Toast.makeText(c, "User ID is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }

        if(txtPassword.getText().toString().trim().length() <= 0){
            toast = Toast.makeText(c, "Password is required!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            return;
        }

        if(!MyRealm.isNetworkAvailable(this)) {
            Snackbar.make(login,"No internet connection detected. Try again later."
                    ,Snackbar.LENGTH_SHORT)
                    .show();
            return;
        }

        userID = txtstudentID.getText().toString();
        pword = txtPassword.getText().toString();

        SharedPreferences.Editor editor = prefs.edit();
        if (rememberMe.isChecked()) {
            editor.putString("LastUser", userID);
            editor.putString("LastPass", pword);
            editor.putBoolean("RememberMe", true);
            editor.apply();
        }
        else {
            editor.putBoolean("RememberMe", false);
            editor.commit();
        }

        try {
            if (SyncUser.current() != null) {
                MyRealm.logoutUser();
            }

            SyncCredentials credentials = SyncCredentials.usernamePassword(userID, pword, false);

            SyncUser.logInAsync(credentials, Constants.AUTH_URL, new SyncUser.Callback<SyncUser>() {
                @Override
                public void onSuccess(SyncUser result) {
                    Log.e("Login success","Login Successful!");

                    GoToNextScreen();
                }

                @Override
                public void onError(ObjectServerError error) {
                    Log.e("Login Error", error.toString());
                    toast = Toast.makeText(c, "The provided credentials are invalid or the user does not exist.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            });
        }catch(Exception e) {
            e.printStackTrace();
            toast = Toast.makeText(this, "Cannot login to the server!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        } finally {
            MyRealm.logoutUser();
        }
    }

    private void GoToNextScreen(){
        realm = MyRealm.getRealm(SyncUser.current());

        user = realm.where(UserData.class)
                .equalTo("user_id", userID)
                .and()
                .equalTo("password",pword)
                .findAllAsync();

        user.addChangeListener(new RealmChangeListener<RealmResults<UserData>>() {
            @Override
            public void onChange(RealmResults<UserData> userg) {
                Log.e("Updating User", "Changes detected.");

                Log.d("User Valid?",user.isValid() + "");
                boolean found = false;

                for(UserData u: userg) {
                    if (u.isValid()) {
                        switch (u.getUser_type()) {
                            case "Student":
                                UserAccount_.intent(c).uid(u.getUser_id()).start();
                                found = true;
                                break;
                            case "Teacher":
                                UserAccount_.intent(c).uid(u.getUser_id()).start();
                                found = true;
                                break;
                        }
                        if(found){
                            break;
                        }
                    }
                }

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        prefs = getSharedPreferences("UserData",MODE_PRIVATE);
        if (prefs.getBoolean("RememberMe", false)) {
            txtstudentID.setText(prefs.getString("LastUser", null));
            txtPassword.setText(prefs.getString("LastPass", null));
            rememberMe.setChecked(true);
        }
        else{
            txtstudentID.setText("");
            txtPassword.setText("");
            rememberMe.setChecked(false);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }
}
