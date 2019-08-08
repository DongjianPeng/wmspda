package cn.starpost.wmspda.activity.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.activity.common.DialogActivity;
import cn.starpost.wmspda.activity.demo.layout.DemoLinearLayout;

public class DemoHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_home_activity);
        findViewById(R.id.bt_demo_home_show_dialog).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_alert_dialog).setOnClickListener(this);
        findViewById(R.id.bt_demo_home_show_pro_dialog).setOnClickListener(this);


        //layout
        findViewById(R.id.bt_demo_home_show_linear_layout).setOnClickListener(this);

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
            default:
                break;
        }
    }
}
