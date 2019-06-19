package vn.edu.poly.lab7_cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private EditText edtData, edtUser, edtPass;
    private CheckBox chkCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData = findViewById(R.id.edtData);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        chkCheck = findViewById(R.id.chkCheck);

    }

    public void createCacheFile(View view) {
        try {
            //lay du lieu tren edit text
            String data = edtData.getText().toString().trim();

            //lay duong dan cua cache file tren he thong
            File fileCacheDir = getCacheDir();

            //dat ten cho file cache
            String cacheFileName = "myfile.cache";

            //tao ra bien file cache de luu du lieu
            File newCacheFile = new File(fileCacheDir, cacheFileName);

            newCacheFile.createNewFile();
            FileOutputStream stream = new FileOutputStream(newCacheFile.getAbsoluteFile());

            stream.write(data.getBytes());
            stream.close();
            edtData.setText("");
            Toast.makeText(this, "Ghi thanh cong", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void runCacheFile(View view) {
        try {
            File fileCacheDir = getCacheDir();

            //dat ten cho file cache
            String cacheFileName = "myfile.cache";

            //tao ra bien file cache de luu du lieu
            File newCacheFile = new File(fileCacheDir, cacheFileName);

            Scanner sc = new Scanner(newCacheFile);

            String data = "";
            while (sc.hasNext()) {
                data = data + sc.nextLine() + "\n";
            }
            sc.close();

            // hien thi du lieu len edit text
            edtData.setText(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //=========================================================================================================
    public void savetoShare(View view) {
        // khoi tao doi tuong sharePref voi ten file laf myshare. mode private
        SharedPreferences sharedPreferences = getSharedPreferences("Myshare", Context.MODE_PRIVATE);

        // khoi tao doi tuong
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String user = edtUser.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();
        boolean chk = chkCheck.isChecked();


        if (!chk) {
            editor.clear();
        } else {
            // luu du lieu duoi dang cap key-value, key la data, value laf bien data
            editor.putString("user", user);
            editor.putString("pass", pass);
            editor.putBoolean("chk", chk);
        }
        //save
        editor.apply();

        edtUser.setText("");
        edtPass.setText("");
        chkCheck.setChecked(false);

    }

    public void loadfromShare(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Myshare", Context.MODE_PRIVATE);
        boolean chk = sharedPreferences.getBoolean("savestatus", false);

        if (!chk) {
            String user = sharedPreferences.getString("user", null);
            String pass = sharedPreferences.getString("pass", null);
            edtUser.setText(user);
            edtPass.setText(pass);
        }
        chkCheck.setChecked(chk);
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();


    }

    //=============================================================================================================


    public void writeData(View view) {
        String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myfile.txt";
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdcard));
            writer.write(edtData.getText()+"");
            writer.close();
            edtData.setText("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public void readData(View view) {

        // kiem tra thiet bi co sd card hay ko, co thi moi tien hanh doc ghi
        boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        boolean isSDSupportedDevice = Environment.isExternalStorageRemovable();

        if (isSDSupportedDevice && isSDPresent) {
            // yes SD-card is present
            Toast.makeText(this, "Sr may ban khong co the nho", Toast.LENGTH_SHORT).show();

        } else {
            // Sorry
            String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myfile.txt";
            try {
                Scanner sc = new Scanner(new File(sdcard));
                String data = "";
                while (sc.hasNext()) {
                    data = data + sc.nextLine() + "\n";
                }
                sc.close();
                edtData.setText(data+"");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}
