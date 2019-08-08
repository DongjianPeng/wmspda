package cn.starpost.wmspda.activity.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import cn.starpost.wmspda.R;

public class DialogActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);

        ProgressBar progressBar = findViewById(R.id.pb_dialog);
        progressBar.setVisibility(ProgressBar.VISIBLE);
//        progressBar.setProgress(50);
    }
}
