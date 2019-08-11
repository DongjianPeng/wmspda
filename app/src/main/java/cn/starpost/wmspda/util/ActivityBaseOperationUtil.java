package cn.starpost.wmspda.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public abstract class ActivityBaseOperationUtil {

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
}
