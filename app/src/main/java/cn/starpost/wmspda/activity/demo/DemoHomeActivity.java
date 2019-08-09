package cn.starpost.wmspda.activity.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.activity.common.DialogActivity;
import cn.starpost.wmspda.activity.demo.fragment.DemoFragmentHome;
import cn.starpost.wmspda.activity.demo.home.DemoHomePage;
import cn.starpost.wmspda.activity.demo.layout.DemoFrameLayout;
import cn.starpost.wmspda.activity.demo.layout.DemoLinearLayout;
import cn.starpost.wmspda.activity.demo.layout.DemoPercentLayout;
import cn.starpost.wmspda.activity.demo.layout.DemoRelativeLayout;
import cn.starpost.wmspda.activity.demo.listview.DemoListView;

public class DemoHomeActivity extends BaseActivity {

    private Button bt_demo_home_show_alert_dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_home_activity);

        findViewById(R.id.bt_demo_home_show_dialog).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_alert_dialog).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_pro_dialog).setOnClickListener(this);


        //layout
        findViewById(R.id.bt_demo_home_show_linear_layout).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_relative_layout).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_frame_layout).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_percent_layout).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_list_view).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_fragment).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_home_page).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.bt_demo_home_show_dialog: {
                openNewActivity(DialogActivity.class);
            }
            break;
            case R.id.bt_demo_home_show_alert_dialog: {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Title");
                dialog.setMessage("Message...");
                dialog.setCancelable(false);
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                    }
                });
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

            }
            break;
            case R.id.bt_demo_home_show_pro_dialog: {
            }
            break;
            case R.id.bt_demo_home_show_linear_layout: {
                openNewActivity(DemoLinearLayout.class);
            }
            break;
            case R.id.bt_demo_home_show_relative_layout: {
                openNewActivity(DemoRelativeLayout.class);
            }
            break;
            case R.id.bt_demo_home_show_frame_layout: {
                openNewActivity(DemoFrameLayout.class);
            }
            break;
            case R.id.bt_demo_home_show_percent_layout: {
                openNewActivity(DemoPercentLayout.class);
            }
            break;
            case R.id.bt_demo_home_show_list_view: {
                openNewActivity(DemoListView.class);
            }
            break;
            case R.id.bt_demo_home_show_fragment: {
                openNewActivity(DemoFragmentHome.class);
            }
            break;
            case R.id.bt_demo_home_show_home_page: {
                openNewActivity(DemoHomePage.class);
            }
            break;
            default:
                break;
        }
    }
}
