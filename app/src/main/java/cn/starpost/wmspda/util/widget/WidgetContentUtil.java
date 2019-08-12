package cn.starpost.wmspda.util.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

/**
 * 校验控件内容通用工具类
 */
public class WidgetContentUtil {
    private static final String TAG = "WidgetContentUtil";


    /**
     * 文本控件内容过滤
     *
     * @param textView
     * @param mode
     */
    public static void textChangedListener(final TextView textView, RegexMode mode) {
        textView.addTextChangedListener(new TextWatcher() {
            CharSequence sBefore = null;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.v(TAG, "beforeTextChanged: s:" + s + ";start:" + start + ";count:" + count + ";after:" + after);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sBefore = s;

                Log.v(TAG, "onTextChanged: s:" + s + ";start:" + start + ";count:" + count + ";before:" + before);
            }

            @Override
            public void afterTextChanged(Editable s) {


                Log.v(TAG, "afterTextChanged: s:" + s.toString());
            }
        });
    }

    /**
     * 丢失焦点内容过滤
     *
     * @param textView
     * @param mode
     */
    public static void lostFocusChangeListener(final TextView textView, RegexMode mode) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                }
            }
        });
    }


    /**
     * 将焦点移动到指定的下一个控件
     *
     * @param currentView
     * @param nextView
     */
    public static void setOnEditorActionListenerAndFocusNextWidget(TextView currentView, final TextView nextView) {

        currentView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {


                nextView.requestFocus();

                if (event != null) {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:" + event.getAction());

                } else {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:null");

                }
                return true;
            }
        });

    }

    public static void setOnEditorActionListener(TextView currentView, final TextView nextView) {

        currentView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {


                nextView.requestFocus();

                if (event != null) {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:" + event.getAction());
                } else {
                    Log.d(TAG, "onEditorAction: actionId:" + actionId + ";event action:null");
                }
                return true;
            }
        });

    }
}
