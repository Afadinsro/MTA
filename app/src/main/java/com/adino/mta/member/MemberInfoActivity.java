package com.adino.mta.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

import com.adino.mta.R;

public class MemberInfoActivity extends AppCompatActivity {

    private ImageView img_pic;
    private EditText txt_name;
    private EditText txt_ministry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img_pic = (ImageView)findViewById(R.id.img_member_info_pic);
        txt_name = (EditText)findViewById(R.id.txt_member_info_name);
        txt_ministry = (EditText)findViewById(R.id.txt_member_info_ministry);

        // Set member info
        txt_name.setText(getIntent().getStringExtra("name"));
        txt_ministry.setText(getIntent().getStringExtra("ministry"));
    }

}
