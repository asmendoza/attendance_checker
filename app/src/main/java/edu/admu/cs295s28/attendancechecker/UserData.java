package edu.admu.cs295s28.attendancechecker;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserData extends RealmObject {
    //User Object

    @PrimaryKey
    private String user_id;

    private String name;
    private String contact_num;
    private String email;
    private String password;
    private String user_type;
    private String avatarpath;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getAvatarpath() {
        return avatarpath;
    }

    public void setAvatarpath(String avatarpath) {
        this.avatarpath = avatarpath;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", contact_num='" + contact_num + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_type='" + user_type + '\'' +
                ", avatarpath='" + avatarpath + '\'' +
                '}';
    }
}
