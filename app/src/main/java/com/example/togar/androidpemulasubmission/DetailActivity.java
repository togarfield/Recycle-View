package com.example.togar.androidpemulasubmission;

/*
 * Created by Togar on 2/8/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_MARKS = "extra_marks";
    public static String EXTRA_PHOTO = "extra_photo";
    public static String EXTRA_DESC = "extra_desc";
    private TextView tvName, tvRemarks;
    private ImageView imgDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.img_detail);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        Glide.with(this)
                .load(photo)
                .override(350, 550)
                .into(imgDetail);

        tvName = (TextView)findViewById(R.id.tv_item_name);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvName.setText(name);


        tvRemarks = (TextView)findViewById(R.id.tv_item_remarks);
        String remarks = getIntent().getStringExtra(EXTRA_MARKS);
        tvRemarks.setText(remarks);
    }
}
