package cn.starpost.wmspda.activity.demo.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

/**
 * 帧布局，所有的控件都会默认摆放在布局的左上角
 */
public class DemoFrameLayout extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout_framelayout_activity);
    }

}
