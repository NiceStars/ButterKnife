package com.butterknife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description :
 * Created by NiceStars on 2017/4/13.
 * Email:NiceStars.cn@gmail.com
 */

public class WeigetActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.notification)
    Button notification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weiget_activity);
        ButterKnife.bind(this);
        notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.notification:

                break;
        }
    }
}
