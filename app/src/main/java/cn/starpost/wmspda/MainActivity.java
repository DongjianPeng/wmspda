package cn.starpost.wmspda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.starpost.wmspda.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
