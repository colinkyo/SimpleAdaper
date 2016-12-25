package com.a7ifun.www.simpleadaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<Map<String,Object>> list;
    private int[] images={R.mipmap.item1,R.mipmap.item2,R.mipmap.item3,R.mipmap.item4,R.mipmap.item5,R.mipmap.item6,R.mipmap.item7,R.mipmap.item8,R.mipmap.item9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        //准备数据源
        list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<8;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("img",images[i]);
            map.put("text","item"+i);
            list.add(map);
        }
        /**
         * context 上下文对象
         * data 数据源对象
         * resources  xml视图格式
         * from 数据源map中的key数组，表示key指定的值
         * to xml中对应的控件资源id
         */
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,list,R.layout.list_item,new String[]{"img","text"},new int[]{R.id.iv,R.id.tv});
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,BaseAdapter.class);
                startActivity(intent);
            }
        });
        lv.setAdapter(adapter);
    }
}
