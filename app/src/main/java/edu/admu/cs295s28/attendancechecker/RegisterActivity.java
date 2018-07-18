package edu.admu.cs295s28.attendancechecker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.app.Activity.RESULT_CANCELED;

@EActivity (R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {
    Picasso picasso;
    File savedImage;
    Intent intent;
    Realm realm;

    @ViewById(R.id.imageView)
    ImageView imageView;

    @ViewById(R.id.btnAdd)
    Button btnAdd;

    @ViewById(R.id.btnCancel)
    Button btnCancel;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }*/

    @AfterViews
    public void init() {
        picasso = Picasso.get();
        refreshImageView(R.mipmap.ic_launcher);
    }

    @Click(R.id.btnAdd)
    public void add(){

    }

    @Click(R.id.btnCancel)
    public void cancel() {
        //close the screen back to the main screen
        intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Click(R.id.imageView)
   public void selectPic() {
       ImageActivity_.intent(this).startForResult(0);
   }

    public void onActivityResult(int requestCode, int responseCode, Intent data)
    {
        if (requestCode==0)
        {
            if (responseCode==100)
            {
                // save rawImage to file savedImage.jpeg
                // load file via picasso
                byte[] jpeg = data.getByteArrayExtra("rawJpeg");

                try {
                    savedImage = saveFile(jpeg);
                    //System.out.println(savedImage.getAbsolutePath());
                    refreshImageView(savedImage);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

    @NonNull
    private File saveFile(byte[] jpeg) throws IOException {
        File getImageDir = getExternalCacheDir();
        savedImage = new File(getImageDir, System.currentTimeMillis()+ ".jpeg");

        FileOutputStream fos = new FileOutputStream(savedImage);
        fos.write(jpeg);
        fos.close();
        return savedImage;
    }

    private void refreshImageView(File savedImage) {

        picasso.load(savedImage).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
    }

    private void refreshImageView(int savedImage) {

        picasso.load(savedImage).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
    }
/*    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            System.out.println("DESTROYED...");
            realm.close();
        }
    }*/
}
