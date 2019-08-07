package cn.starpost.wmspda;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.starpost.wmspda.activity.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                toastShow("click");
            }
        });
    }
}
