package cn.starpost.wmspda.activity.common;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import cn.starpost.wmspda.R;

public class NavigatorLayout extends LinearLayout {
    // private widget
    private ImageButton btNavigatorQuit = null;

    public NavigatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.navigator_activity, this);
        //navigator
        btNavigatorQuit = findViewById(R.id.bt_navigator_quit);
        if (btNavigatorQuit != null) {
            btNavigatorQuit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) getContext()).finish();
                }
            });
        }
    }
}
