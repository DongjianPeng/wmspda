package cn.starpost.wmspda.activity.demo.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

/**
 * 相对布局，可设置相对父控件和相对某控件的相对位置<br>
 */
public class DemoRelativeLayout extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout_relativelayout_activity);
    }
}
