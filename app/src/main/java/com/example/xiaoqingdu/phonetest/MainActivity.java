package com.example.xiaoqingdu.phonetest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ok=(Button)findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"缺少打电话权限",Toast.LENGTH_LONG).show();
                    return;
                }
                String phonenumber="15650799276";
                String encodePhonenumber=null;
                try{
                    encodePhonenumber= URLEncoder.encode(phonenumber,"UTF-8");
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+encodePhonenumber)));
            }
        });
    }
}

