package cn.starpost.wmspda.service.app;

import java.util.LinkedList;

import cn.starpost.wmspda.activity.common.BaseActivity;

/**
 * 活动生命周期管理
 */
public class ActivityLifeManager {

    private static LinkedList<BaseActivity> activities = new LinkedList<>();

    public static void push(BaseActivity context) {
        activities.push(context);
    }

    public static void pop() {
        BaseActivity activity = activities.pop();
    }

    public static void exit() {

    }

}
