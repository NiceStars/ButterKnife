package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.butterknife.ContentActivity;
import com.butterknife.R;

/**
 * Description :
 * Created by NiceStars on 2017/3/22.
 * Email:NiceStars.cn@gmail.com
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder>  {//2

    private Context context;
    private String [] title;
    private String [] message;
    private LayoutInflater inflater;


    public CardViewAdapter(Context context,String [] title,String [] message){//3
         this.context=context;
        this.title=title;
        this.message=message;
        inflater = LayoutInflater.from(context);//4
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(inflater.from(parent.getContext()).inflate(R.layout.main_items, parent, false));//5
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {//7
        holder.title.setText(title[position]);
        holder.message.setText(message[position]);
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==3){


                }else{
                    Intent i=new Intent();
                    i.putExtra("position",position);
                    i.setClass(context, ContentActivity.class);
                    context.startActivity(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;//6
    }

    //1
    public final  class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,message;
        private CardView card_view;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            message = (TextView) itemView.findViewById(R.id.message);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }



    //使用RecycleView的话  先添加依赖  在app的build.gradle 里面添加依赖 ：
    // compile 'com.android.support:recyclerview-v7:24.2.1'//这个是RecyclerView的依赖项
    // recycleview的 items和 listview的items一样
    // 现在开始添加adapter
    //1.先创建一个内部类 MyViewHolder 继承自recycleView.ViewHolder  并实现它的未实现的方法 这个是获取items的控件的
    //2.创建的Adapter 继承自RecycleView.Adapter<Class.MyViewHolder>  实现他们未实现的方法
    //3.创建一个带参构造方法 参数必须要有上下文对象  里面实例化布局构造器
    //4.onCreateViewHolder 方法主要加载布局的  方法返回值是 MyViewHolder(inflater.from(parent.getContext)).inflate(R.layout.items,parent,false);
    //5.onBindViewHolder 这个方法主要是加载数据到布局里面去的
    //6.getItemCount() 这个方法主要是获取要加载items数的  返回值一般是数据或者集合的 length 和size

}
