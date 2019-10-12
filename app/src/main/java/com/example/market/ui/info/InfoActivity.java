package com.example.market.ui.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.market.R;
import com.example.market.model.SubCategory;
import com.example.market.ui.base.BaseActivity;

import androidx.annotation.Nullable;

public class InfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra(TITLE);
        setTitle(title);
    }


    public static Intent newInstance(Context context, SubCategory subCategory) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(TITLE, subCategory.getTitle());
        return intent;
    }

    private static String TITLE = "title";
}
