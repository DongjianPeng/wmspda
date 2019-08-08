package cn.starpost.wmspda.activity.home;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.activity.common.DialogActivity;
import cn.starpost.wmspda.activity.setting.about.AboutActivity;

public class HomeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = findViewById(R.id.bt_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                toastShow("click");
                AboutActivity.actionStart(currentContext);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.me_about: {
                openNewActivity(AboutActivity.class);
            }
            break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
