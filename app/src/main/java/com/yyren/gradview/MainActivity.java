package com.yyren.gradview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    private RelativeLayout showToFriendLayout;
    private LinearLayout bottomOnClick1;
    private LinearLayout bottomOnClick2;
    private LinearLayout bottomOnClick3;
    private LinearLayout bottomOnClick4;
    private ImageView imageView1;
    private TextView textView1;
    private ImageView imageView2;
    private TextView textView2;
    private ImageView imageView3;
    private TextView textView3;
    private ImageView imageView4;
    private TextView textView4;

    //将图片的编号放在一个整形数组中
    private int[] icon = {R.mipmap.grid_view_1,R.mipmap.grid_view_2,R.mipmap.grid_view_3,R.mipmap.grid_view_4,R.mipmap.grid_view_5,R.mipmap.grid_view_6};
    private String[] iconName = {"清理加速","话费流量","骚扰拦截","防止吸费","支付保镖","手机杀毒"};
    //建立一个简单适配器
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.centerGridView);

        dataList = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.grid_view_item,new String[]{"icon","iconName"},new int[]{R.id.itemImageView,R.id.itemTextView});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,iconName[position] + "被点击",Toast.LENGTH_SHORT).show();
            }
        });
        bottomOnClick();

        //分享给好友
        showToFriendLayout = (RelativeLayout)findViewById(R.id.showToFriendLayout);
        showToFriendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "分享成功，积分+1",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //得到数据
    private List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("icon",icon[i]);
            map.put("iconName",iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    //底部导航事件组
    private void bottomOnClick(){
        bottomOnClick1 = (LinearLayout) findViewById(R.id.bottomList1);
        bottomOnClick2 = (LinearLayout) findViewById(R.id.bottomList2);
        bottomOnClick3 = (LinearLayout) findViewById(R.id.bottomList3);
        bottomOnClick4 = (LinearLayout) findViewById(R.id.bottomList4);
        imageView1 = (ImageView)findViewById(R.id.bottomImageView1);
        textView1 = (TextView)findViewById(R.id.bottomTextView1);
        imageView2 = (ImageView)findViewById(R.id.bottomImageView2);
        textView2 = (TextView)findViewById(R.id.bottomTextView2);
        imageView3 = (ImageView)findViewById(R.id.bottomImageView3);
        textView3 = (TextView)findViewById(R.id.bottomTextView3);
        imageView4 = (ImageView)findViewById(R.id.bottomImageView4);
        textView4 = (TextView)findViewById(R.id.bottomTextView4);
        bottomOnClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_1_on));
                textView1.setTextColor(getResources().getColorStateList(R.color.colorGreen));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_2_off));
                textView2.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_3_off));
                textView3.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_4_off));
                textView4.setTextColor(getResources().getColorStateList(R.color.colorWhite));
            }
        });
        bottomOnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_1_off));
                textView1.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_2_on));
                textView2.setTextColor(getResources().getColorStateList(R.color.colorGreen));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_3_off));
                textView3.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_4_off));
                textView4.setTextColor(getResources().getColorStateList(R.color.colorWhite));
            }
        });
        bottomOnClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_1_off));
                textView1.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_2_off));
                textView2.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_3_on));
                textView3.setTextColor(getResources().getColorStateList(R.color.colorGreen));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_4_off));
                textView4.setTextColor(getResources().getColorStateList(R.color.colorWhite));
            }
        });
        bottomOnClick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_1_off));
                textView1.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_2_off));
                textView2.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_3_off));
                textView3.setTextColor(getResources().getColorStateList(R.color.colorWhite));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.bottom_4_on));
                textView4.setTextColor(getResources().getColorStateList(R.color.colorGreen));
            }
        });
    }

}
