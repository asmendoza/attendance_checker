package edu.admu.cs295s28.attendancechecker;

import java.util.UUID;
import io.realm.RealmObject;

import io.realm.annotations.PrimaryKey;

public class UserScheduleData extends RealmObject {
    @PrimaryKey
    private String user_sched_id = UUID.randomUUID().toString();

    private String uID;
    private String schedID;

    public String getUser_sched_id() {
        return user_sched_id;
    }

    public void setUser_sched_id(String user_sched_id) {
        this.user_sched_id = user_sched_id;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getSchedID() {
        return schedID;
    }

    public void setSchedID(String schedID) {
        this.schedID = schedID;
    }

    @Override
    public String toString() {
        return "UserScheduleData{" +
                "user_sched_id='" + user_sched_id + '\'' +
                ", uID='" + uID + '\'' +
                ", schedID='" + schedID + '\'' +
                '}';
    }
}
