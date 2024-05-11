package com.hsq.myapplication2.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hsq.myapplication2.model.TestObj;
import com.hsq.myapplication2.model.TestParcelable;
import com.hsq.myapplication2.model.TestSerializable;

import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = "/test/fragment")
public class BlankFragment extends Fragment {

    @Autowired
    String name;

    @Autowired(required = true)
    TestObj obj;

    @Autowired
    int age = 10;

    @Autowired
    int height = 175;

    @Autowired(name = "boy", required = true)
    boolean girl;

    @Autowired
    char ch = 'A';

    @Autowired
    float fl = 12.00f;

    @Autowired
    double dou = 12.01d;

    @Autowired
    TestSerializable ser;

    @Autowired
    TestParcelable pac;

    @Autowired
    List<TestObj> objList;

    @Autowired
    Map<String, List<TestObj>> map;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("撒旦法加快速度");
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ARouter.getInstance().inject(this);
        showLog();
    }

    public void showLog() {
        Log.e("ad", "打印一下1：" + obj.toString());
        Log.e("ad", "打印一下2：" + ser.toString());
        Log.e("ad", "打印一下3：" + pac.toString());
        Log.e("ad", "打印一下4：" + objList.toString());
        Log.e("ad", "打印一下5：" + map.toString());
    }

}
