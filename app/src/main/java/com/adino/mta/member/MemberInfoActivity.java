package com.adino.mta.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.adino.mta.R;

public class MemberInfoActivity extends AppCompatActivity {

    private ImageView img_pic;
    private EditText txt_name;
    private EditText txt_ministry;
    private Button btn_edit;

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
        btn_edit = (Button)findViewById(R.id.btn_member_info_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_name.setEnabled(true);
                txt_ministry.setEnabled(true);
            }
        });
    }

}
