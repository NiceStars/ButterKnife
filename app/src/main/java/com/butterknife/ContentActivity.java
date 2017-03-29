package com.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import views.MyZoomImageView;

/**
 * Description :
 * Created by NiceStars on 2017/3/23.
 * Email:NiceStars.cn@gmail.com
 */

public class ContentActivity extends AppCompatActivity {


    @BindView(R.id.content_iv)
    MyZoomImageView contentIv;
    private int[] res = new int[]{R.mipmap.recycleview,R.mipmap.cardview,R.mipmap.butterknife,R.mipmap.intent};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentactivity);
        ButterKnife.bind(this);

        int p = getIntent().getIntExtra("position",-1);
        contentIv.setImageResource(res[p]);
    }
}
