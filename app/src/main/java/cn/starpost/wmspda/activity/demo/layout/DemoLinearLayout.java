package cn.starpost.wmspda.activity.demo.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.common.BaseActivity;

/**
 * 线性布局，这个布局会把包含在内的所有控件竖向或横向排列<br>
 *     次布局支持设定layout_weight权重来实按比例指定控件大小功能
 */
public class DemoLinearLayout extends BaseActivity {
    private LinearLayout layout = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout_linearlayout_activity);
        layout = findViewById(R.id.ll_demo_layout_linear_id);
        findViewById(R.id.bt_demo_layout_liner_switch_orientation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_demo_layout_liner_switch_orientation: {
                if (layout.getOrientation() == LinearLayout.HORIZONTAL) {
                    layout.setOrientation(LinearLayout.VERTICAL);
                } else {
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
            break;
            default:
                break;
        }
    }
}
