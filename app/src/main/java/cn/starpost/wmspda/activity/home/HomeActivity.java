package cn.starpost.wmspda.activity.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.activity.home.subset.HomeInboundFragment;
import cn.starpost.wmspda.activity.home.subset.HomeOutboundFragment;
import cn.starpost.wmspda.activity.home.subset.HomeWarehouseManagerFragment;

/**
 * 主界面
 */
public class HomeActivity extends BaseActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindWidgetAndEvent(savedInstanceState);
        replaceFragment(new HomeInboundFragment());

    }

    @Override
    protected void bindWidgetAndEvent(Bundle savedInstanceState) {
        bottomNavigationView = findViewById(R.id.bnv_home_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.me_bottom_inbound: {
                        replaceFragment(new HomeInboundFragment());
                    }
                    break;
                    case R.id.me_bottom_outbound: {
                        replaceFragment(new HomeOutboundFragment());
                    }
                    break;
                    case R.id.me_bottom_manager: {
                        replaceFragment(new HomeWarehouseManagerFragment());
                    }
                    break;
                    default:
                        break;
                }

                return true;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
//                .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                .replace(R.id.fl_home_fragment, fragment)
                .commit();
    }

}

