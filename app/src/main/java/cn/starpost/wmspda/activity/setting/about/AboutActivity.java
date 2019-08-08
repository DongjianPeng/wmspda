package cn.starpost.wmspda.activity.setting.about;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

public class AboutActivity extends BaseActivity {

    public static void actionStart(BaseActivity context) {
        context.openNewActivity(AboutActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_about_activity);
    }
}
