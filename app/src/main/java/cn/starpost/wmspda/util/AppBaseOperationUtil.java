package cn.starpost.wmspda.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public abstract class AppBaseOperationUtil {

    public static void bindIdAndStartNewActivity(View view, final int bindId, final Class newActivity) {
        final Context context = view.getContext();
        view.findViewById(bindId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == bindId) {
                    context.startActivity(new Intent(context, newActivity));
                }
            }
        });
    }

    /**
     * 关闭软键盘
     *
     * @param activity
     */
    public static void hideSoftInputView(Activity activity) {
        if (activity.getWindow().getAttributes().softInputMode !=
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                manager.hideSoftInputFromWindow(currentFocus.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
