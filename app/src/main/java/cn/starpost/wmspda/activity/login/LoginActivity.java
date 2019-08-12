package cn.starpost.wmspda.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.config.AppConfig;
import cn.starpost.wmspda.util.http.HTTPUtil;
import cn.starpost.wmspda.util.http.HttpCallBackListener;
import cn.starpost.wmspda.util.widget.RegexMode;
import cn.starpost.wmspda.util.widget.WidgetContentUtil;

public class LoginActivity extends BaseActivity {

    private Button btnDoLogin;
    private EditText etLoginUser;
    private EditText etLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        btnDoLogin = findViewById(R.id.bt_login_do_login);
        etLoginUser = findViewById(R.id.et_login_user);
        etLoginPassword = findViewById(R.id.et_login_password);

        btnDoLogin.setOnClickListener(this);
        WidgetContentUtil.textChangedListener(etLoginUser, RegexMode.MULTI_LINE);
        WidgetContentUtil.textChangedListener(etLoginPassword, RegexMode.MULTI_LINE);

        etLoginUser.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null) {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:" + event.getAction());

                } else {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:null");

                }
                return true;
            }
        });
        etLoginPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null) {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:" + event.getAction());

                } else {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:null");

                }
                return true;
            }
        });


    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bt_login_do_login: {

                String s = etLoginUser.getText().toString();
                String s1 = etLoginPassword.getText().toString();
                Log.d(TAG, "onClick: |" + s + "|" + "s1:|" + s1 + "|");


                new HTTPUtil(new HttpCallBackListener() {
                    @Override
                    public void httpCallBack() {
                        
                    }
                }).doPost(AppConfig.wmsUrl + "v2/pda/check-login", "ddd");
            }
            break;

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        toastShow("再按一次退出程序");
    }
}