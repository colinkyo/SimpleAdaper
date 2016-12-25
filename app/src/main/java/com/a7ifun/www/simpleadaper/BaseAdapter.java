package com.a7ifun.www.simpleadaper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list.add("Item"+i);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        lv.setAdapter(myBaseAdapter);
    }

    /**
     *
     */
    class MyBaseAdapter extends android.widget.BaseAdapter{
        /**
         * 表示当前数据源的总条数
         * @return
         */
        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 根据指定下标，获取对应的item的view
         * @param position
         * @return
         */
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        /**
         * 根据指定下标，获取当前item的id
         * @param position
         * @return
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 根据指定下标获取适配器控件中的每个item对应的view对象 得到每个用于展示数据的item视图
         * @param position 表示当前绘制的item下标
         * @param convertView 表示可复用的view对象
         * @param parent 表示当前绘制的item所属的listview对象
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //动态创建
            /*TextView tv = new TextView(BaseAdapter.this);
            tv.setTextSize(25);
            tv.setText(list.get(position));
            return tv;*/
            //用xml创建
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.list_item1,null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(list.get(position));
            return  view;
        }
    }
}
