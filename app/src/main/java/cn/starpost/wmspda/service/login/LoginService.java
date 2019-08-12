package cn.starpost.wmspda.service.login;

import cn.starpost.wmspda.activity.common.BaseActivity;
import cn.starpost.wmspda.activity.login.LoginActivity;

/**
 * 登录服务类，App使用此服务类做登录、退出登录
 */
public class LoginService {


    public static boolean checkLogin(BaseActivity activity) {

        activity.openNewActivity(LoginActivity.class);
        return false;
    }
}
