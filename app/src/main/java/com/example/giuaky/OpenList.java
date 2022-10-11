package com.example.giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OpenList extends AppCompatActivity {

    TextView txtview;
    TextView txtview2;
    ImageView imghinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);
        AnhXa();
        txtview.setText(getIntent().getStringExtra("Tên"));
        txtview2.setText(getIntent().getStringExtra("Mô tả"));
        imghinh.setImageResource(getIntent().getIntExtra("Hinh",0));
    }

    private void AnhXa() {
        txtview = (TextView) findViewById(R.id.ten1);
        txtview2 = (TextView) findViewById(R.id.ten2);
        imghinh = (ImageView) findViewById(R.id.hinh1);
    }
}