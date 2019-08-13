package cn.starpost.wmspda.activity.common;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.home.HomeActivity;
import cn.starpost.wmspda.service.app.ActivityLifeManager;
import cn.starpost.wmspda.service.login.LoginService;
import cn.starpost.wmspda.util.AppBaseOperationUtil;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected final String TAG = getClass().getName();

    protected final BaseActivity currentContext = this;
    protected final Intent currentIntent = getIntent();
    protected Intent currentIntentResult = null;


    public BaseActivity() {
        Log.d(TAG, "Constructor");
    }

    /**
     * Activity第一次创建的时候调用，重写此方法完成初始化操作，如加载布局，绑定事件等；
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        ActivityLifeManager.push(this);
        actionBarHide();
        //强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected void actionBarHide() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            //隐藏标题栏
            supportActionBar.hide();
        }
    }

    protected void actionBarShow() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            //隐藏标题栏
            supportActionBar.show();
        }
    }


    /**
     * 绑定控件和绑定控件对应事件
     *
     * @param savedInstanceState
     */
    protected void bindWidgetAndEvent(Bundle savedInstanceState) {
    }

    /**
     * Activity由不可见变为可见时调用
     */
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    /**
     * Activity可与用户交互时调用，此时此活动一定位于栈顶且处于运行状态
     */
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
        if (getClass().getName().equals(HomeActivity.class.getName())) {
            LoginService.checkLogin(this);
        }
    }

    /**
     * 准备启动和恢复另一个Activity时调用，<br>
     * 可在此方法中将一些消耗CPU的资源释放掉以及保存关键数据，此方法执行一定要快
     */
    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    /**
     * Activity完全不可见时调用<br>
     * <i>注</i>若在当前活动窗口启动Dialog，则会调用onPause而不会调用onStop
     */
    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    /**
     * Activity被销毁之前调用，调用此方法后Activity状态变为销毁状态
     */
    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }


    /**
     * Activity由停止状态变为运行状态之前调用，调用此方法后活动变为运行状态
     */
    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        if (getClass().getName().equals(HomeActivity.class.getName())) {
            toastShow("若想退出此应用请在设置界面下点击'退出应用'按钮");
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown: keyCode：" + keyCode + "keyCode:" + event.getKeyCode());
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    currentIntentResult = data;
                }
            }
            break;
        }
    }

    /**
     * 活动被回收时一定会调用，在此方法中保存重要数据以便重新调用onCreate时恢复数据<br>
     * 在bundle中保存数据后在onCreate中读取
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void finish() {
        super.finish();
    }

    /**
     * 提醒通知
     *
     * @param msg
     */
    public void toastShow(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void openNewActivity(Class<?> targetActivityClazz) {
        openNewActivity(targetActivityClazz, null);
    }

    public void openNewActivity(Class<?> targetActivityClazz, Bundle params) {
        Intent intent = new Intent(this, targetActivityClazz);
        if (params != null && !params.isEmpty()) {
            intent.putExtras(params);
        }
        startActivity(intent);
    }

    public void openNewActivityForResult(Class<?> targetActivityClazz) {
        openNewActivityForResult(targetActivityClazz, null);
    }

    public void openNewActivityForResult(Class<?> targetActivityClazz, Bundle params) {
        Intent intent = new Intent(this, targetActivityClazz);
        if (params != null && !params.isEmpty()) {
            intent.putExtras(params);
        }
        startActivityForResult(intent, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_login_main_layout: {
                AppBaseOperationUtil.hideSoftInputView(this);
            }
            break;

            default:
                break;
        }
    }
}
