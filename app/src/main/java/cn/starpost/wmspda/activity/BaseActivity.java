package cn.starpost.wmspda.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getName();
    protected final BaseActivity currentObj = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        Log.d(TAG, currentObj.getClass().getName());
        super.onCreate(savedInstanceState);
    }


    /**
     * 提醒通知
     *
     * @param msg
     */
    public void toastShow(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
