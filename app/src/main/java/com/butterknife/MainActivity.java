package com.butterknife;

import android.content.Context;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import android.widget.LinearLayout;
import android.widget.Toast;



import adapter.CardViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycleview)
    RecyclerView mainRecycle;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;





    private CardViewAdapter cardViewAdapter;

    private String[] title = new String[]{"RecycleView的使用", "Cardview的使用", "控件注解框架的使用", "链接至手机浏览器","友盟推送"};
    private String[] message = new String[]{"RecycleView使用的基本步骤 get", "Cardview使用的基本步骤 get", "控件注解框架的使用", "如何链接至手机浏览器","友盟推送SDK集成步骤"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Android");

        }
        cardViewAdapter = new CardViewAdapter(MainActivity.this, title, message);
        mainRecycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRecycle.setAdapter(cardViewAdapter);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击back键finish当前activity
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


    //CardView 的初步用法
    // compile 'com.android.support:cardview-v7:25.0.1'  添加依赖
    //  这个属于一种布局模式  在这个里面可以添加自己需要的控件  比如textview  Button  等等
    //比较特色的属性有两个  app:cardCornerRadius="10dp" CardView的圆角度数
    // app:cardElevation="5dp" 深度  Android Material Design 设计模式

    //ButterKnife 注解框架
    // 要想使用快捷键 alt+insert 一键注解控件的话  分为两步
    //第一步  Android Studio 下载插件 file—settings-plugins-browse repositories 查找butterknife插件  然后安装
    //第二步 在app  build.gradle 里面添加 compile 'com.jakewharton:butterknife:8.5.1'  apt 'com.jakewharton:butterknife-compiler:8.5.1'
    //然后 在头部 添加 apply plugin: 'com.neenbedankt.android-apt'
    //最后在项目的 build.gradle 里面添加   classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    //刷新一下  使用的时候一定要在页面OnCreate方法里面 绑定一下  代码： ButterKnife.bind(this);



    //集成友盟推送的步骤：
    //1.下载友盟推送sdk 并当做库的模式导入到项目里面
    //2.在友盟后台注册app  并拿到UMENG_APPKEY和UMENG_MESSAGE_SECRET 在清单文件里面配置一下
    /*<meta-data
    android:name="UMENG_APPKEY"
    android:value="58eed133677baa67110021fa"></meta-data>
    <meta-data
    android:name="UMENG_MESSAGE_SECRET"
    android:value="f758dd80530362ed5a6a5b8cedb1e11a"></meta-data>*/
    //3.在application里面注册一下 umeng的信息
    /*PushAgent mPushAgent = PushAgent.getInstance(this);
    //注册推送服务，每次调用register方法都会回调该接口
    mPushAgent.register(new IUmengRegisterCallback() {
        @Override
        public void onSuccess(String deviceToken) {
            //注册成功会返回device token
            Log.e("Application", deviceToken);
        }
        @Override
        public void onFailure(String s, String s1) {
            Log.e("Application", s);
            Log.e("Application", s1);
        }
    });
    UmengMessageHandler messageHandler = new UmengMessageHandler() {
        @Override
        public void dealWithCustomMessage(final Context context, final UMessage msg) {
            new Handler(getMainLooper()).post(new Runnable() {

                @Override
                public void run() {
                    // 对于自定义消息，PushSDK默认只统计送达。若开发者需要统计点击和忽略，则需手动调用统计方法。
                    boolean isClickOrDismissed = true;
                    if (isClickOrDismissed) {
                        //自定义消息的点击统计
                        UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
                    } else {
                        //自定义消息的忽略统计
                        UTrack.getInstance(getApplicationContext()).trackMsgDismissed(msg);
                    }
                    Toast.makeText(context, msg.custom, Toast.LENGTH_LONG).show();
                  //这里加入提醒功能 比如notification
                }
            });
        }
    };
    mPushAgent.setMessageHandler(messageHandler);*/
    //4.在首页Activity里面加上  PushAgent.getInstance(this).onAppStart();
    //5.集成功完成


}
