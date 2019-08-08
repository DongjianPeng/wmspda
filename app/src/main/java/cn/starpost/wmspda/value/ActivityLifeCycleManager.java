package cn.starpost.wmspda.value;

import java.util.concurrent.ConcurrentLinkedQueue;

import cn.starpost.wmspda.activity.common.BaseActivity;

public final class ActivityLifeCycleManager {
    private ConcurrentLinkedQueue<BaseActivity> queue = new ConcurrentLinkedQueue();

    public void pop() {
    }
}
