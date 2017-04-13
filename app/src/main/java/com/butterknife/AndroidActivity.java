package com.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description :
 * Created by NiceStars on 2017/4/13.
 * Email:NiceStars.cn@gmail.com
 */

public class AndroidActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.sourcecode)
    Button sourcecode;
    @BindView(R.id.popframework)
    Button popframework;
    @BindView(R.id.weiget)
    Button weiget;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_activity);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Android SourceCode");

        }
        sourcecode.setOnClickListener(this);
        popframework.setOnClickListener(this);
        weiget.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sourcecode:
                startActivity(new Intent(AndroidActivity.this, MainActivity.class));
                break;
            case R.id.popframework:
                break;
            case R.id.weiget:

                break;
        }

    }
}
