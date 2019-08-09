package cn.starpost.wmspda.activity.demo.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

public class DemoListView extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_listview_listview_activity);


        List<String> data = new ArrayList<>();
        data.addAll(Arrays.asList("aaa", "bbb", "ccc", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx", "xx"));

        ArrayAdapter<String> adapter = new ArrayAdapter(currentContext, android.R.layout.simple_list_item_1, data);

        ListView listView = findViewById(R.id.lv_demo_list_view_1);
        listView.setAdapter(adapter);
    }
}
