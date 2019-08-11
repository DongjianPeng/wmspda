package cn.starpost.wmspda.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.starpost.wmspda.activity.common.BaseActivity;

/**
 * 冷启动欢迎页面
 */
public class WelcomePage extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        openNewActivity(HomeActivity.class);
        finish();
    }


}
