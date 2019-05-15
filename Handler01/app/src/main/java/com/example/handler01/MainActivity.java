package com.example.handler01;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
//Simple Handler example
public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what==1){
                    Bundle data=msg.getData();
                    String s=data.getString("s");
                    setTitle(s);
                }
                return false;
            }
        });
    }

    public void onBtnSendData(View view) {
        Message msg=new Message();
        msg.what=1;
        Bundle data=msg.getData();
        data.putString("s", "Hello World!");
        handler.sendMessage(msg);
    }
}