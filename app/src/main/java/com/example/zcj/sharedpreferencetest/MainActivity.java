package com.example.zcj.sharedpreferencetest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private TextView textView;
    private Button button_write;
    private Button button_read;
    private Button button_turnto;
    private SharedPreferences sp;
    private SpUtil spUtil;
    private static final String SP_NAME = "com.tjz.sp";
    private static final String SP_KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spUtil = new SpUtil();
        sp =getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        textView = (TextView) findViewById(R.id.text_sp);
        button_write = (Button) findViewById(R.id.writeA);
        button_write.setOnClickListener(this);
        button_read = (Button) findViewById(R.id.readA);
        button_read.setOnClickListener(this);
        button_turnto = (Button) findViewById(R.id.startA);
        button_turnto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.writeA:
                spUtil.put(this,"按钮事件A写入");
//                sp.edit().putString(SP_KEY,"按钮事件A写入").commit();
                break;
            case R.id.readA:
                textView.setText(spUtil.get(this));
//                textView.setText(sp.getString(SP_KEY,""));
                break;
            case R.id.startA:
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
