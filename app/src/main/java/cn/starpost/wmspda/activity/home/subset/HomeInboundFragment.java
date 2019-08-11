package cn.starpost.wmspda.activity.home.subset;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.starpost.wmspda.R;
import cn.starpost.wmspda.activity.inbound.ArrivalActivity;
import cn.starpost.wmspda.activity.inbound.MeasureActivity;
import cn.starpost.wmspda.activity.inbound.QcActivity;
import cn.starpost.wmspda.activity.inbound.StockInActivity;
import cn.starpost.wmspda.util.ActivityBaseOperationUtil;

public class HomeInboundFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_inbound_fragment, container, false);

        ActivityBaseOperationUtil.bindIdAndStartNewActivity(view, R.id.bt_home_subset_inbound_arrival, ArrivalActivity.class);
        ActivityBaseOperationUtil.bindIdAndStartNewActivity(view, R.id.bt_home_subset_inbound_measure, MeasureActivity.class);
        ActivityBaseOperationUtil.bindIdAndStartNewActivity(view, R.id.bt_home_subset_inbound_qc, QcActivity.class);
        ActivityBaseOperationUtil.bindIdAndStartNewActivity(view, R.id.bt_home_subset_inbound_stock_in, StockInActivity.class);

        return view;
    }


}
