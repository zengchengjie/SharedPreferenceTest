package com.example.zcj.sharedpreferencetest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zcj on 2016/11/7.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button_write;
    private Button button_read;
    private Button button_turnto;
    private SpUtil spUtil;
    private SharedPreferences sp;
    private static final String SP_NAME = "com.tjz.sp";
    private static final String SP_KEY = "key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        spUtil = new SpUtil();
        sp =getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        textView = (TextView) findViewById(R.id.text_sp_B);
        button_write = (Button) findViewById(R.id.writeB);
        button_write.setOnClickListener(this);
        button_read = (Button) findViewById(R.id.readB);
        button_read.setOnClickListener(this);
        button_turnto = (Button) findViewById(R.id.startB);
        button_turnto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.writeB:
//                spUtil.put(this, "按钮事件B写入");
                break;
            case R.id.readB:
                textView.setText(sp.getString(SP_KEY,""));
                break;
            case R.id.startB:
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
