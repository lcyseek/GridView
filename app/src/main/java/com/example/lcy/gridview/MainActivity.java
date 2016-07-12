package com.example.lcy.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * android:numColumns="auto_fit" --------表示有多少列，如果设置为auto_fit，将根据columnWidth和Spacing来自动计算 -->
 * android:columnWidth="90dp"，----------每列的宽度，也就是Item的宽度
 * android:stretchMode="columnWidth"------如何填满空余的位置 如果是columnWidth，则这剩余的将分摊给每一列.如果采用SpacingWidth，则分摊给3个间隔空隙
 * android:verticalSpacing="10dp"----------垂直边距
 * android:horizontalSpacing="10dp"-------水平边距
 *
 * GridView本身不能规定行数，这个类的行数是由宽度和元素个数自动算出来的
 */
public class MainActivity extends AppCompatActivity {

    private int[] icons = new int[]{R.drawable.add,R.drawable.addplus,R.drawable.camera,R.drawable.clock_1,
            R.drawable.firefox,R.drawable.settings,R.drawable.sparrow, R.drawable.canary,R.drawable.google_earth,
            R.drawable.ie,R.drawable.itunes,R.drawable.office,R.drawable.safari, R.drawable.visual_studio,
            R.drawable.youtube,R.drawable.arrow_down,R.drawable.car,R.drawable.circlecompass,R.drawable.denied,
            R.drawable.dropbox, R.drawable.hipchat,R.drawable.memorycard,R.drawable.mic,R.drawable.skype,R.drawable.traffic,R.drawable.vlc};

    private String[] names = {"添加","添加1","相机","时钟","浏览器","设置","导航","谷歌浏览器","谷歌地球","IE浏览器","apple","办公软件","safari",
    "visual studio","youtube","arrow","car","android","Stop","dropbox","chat","memory","mic","skype","traffic","vlc"};
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.grid_item,new String[]{"icon","name"},new int[]{R.id.iv,R.id.name});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<>();

        for (int i = 0; i < icons.length; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("icon",icons[i]);
            map.put("name",names[i]);
            list.add(map);
        }
        return list;
    }
}
