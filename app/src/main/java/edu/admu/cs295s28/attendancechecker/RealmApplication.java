package edu.admu.cs295s28.attendancechecker;

import android.app.Application;
import io.realm.Realm;

public class RealmApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
