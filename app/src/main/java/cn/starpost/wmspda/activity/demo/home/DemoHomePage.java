package cn.starpost.wmspda.activity.demo.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

public class DemoHomePage extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_home_page_activity);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv_home_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                toastShow(menuItem.getTitle());
                return true;
            }
        });

    }
}
