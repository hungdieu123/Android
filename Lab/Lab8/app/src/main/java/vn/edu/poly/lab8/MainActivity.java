package vn.edu.poly.lab8;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
private EditText edtFile;
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFile=findViewById(R.id.edtFile);
        webView=findViewById(R.id.webView);

    }

    public void Lood(View view) {
        String url=edtFile.getText()+"";
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }


    public void LoadHttp(View view) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        try {
            URL url=new URL("http://lms.poly.edu.vn/");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            String data="";
            Scanner sc=new Scanner(inputStream);
            while (sc.hasNext()){
                data=data+sc.nextLine();
            }
            Toast.makeText(this,"!!!Thành Công !!!",Toast.LENGTH_SHORT).show();
            Log.e("DATA DATA",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
