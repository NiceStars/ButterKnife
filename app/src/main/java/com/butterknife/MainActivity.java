package com.butterknife;

import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import android.widget.LinearLayout;

import adapter.CardViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycleview)
    RecyclerView mainRecycle;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;




    private CardViewAdapter cardViewAdapter;

    private String[] title = new String[]{"RecycleView的使用", "Cardview的使用", "控件注解框架的使用", "链接至手机浏览器","小米推送服务"};
    private String[] message = new String[]{"RecycleView使用的基本步骤 get", "Cardview使用的基本步骤 get", "控件注解框架的使用", "如何链接至手机浏览器","小米推送服务使用具体步骤"};

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

}
