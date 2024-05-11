package com.hsq.myapplication2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
//        LDSweepMap ldSweepMap = new LDSweepMap();
//        ldSweepMap.setMapID(1);
//        String hsq = MD5.GetMD5Code("hsq");
//        LogUtils.e(hsq + "，地图ID：" + ldSweepMap.getMapID());
        String a = "{\"a\":1}";
        Object o = JSON.toJSON(a);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance().build("/test/activity").withString("name", "老王").navigation();

//                TestSerializable testSerializable = new TestSerializable("Titanic", 555);
//                TestParcelable testParcelable = new TestParcelable("jack", 666);
//                TestObj testObj = new TestObj("Rose", 777);
//                List<TestObj> objList = new ArrayList<>();
//                objList.add(testObj);
//                Map<String, List<TestObj>> map = new HashMap<>();
//                map.put("testMap", objList);
//                BlankFragment fragment = (BlankFragment) ARouter.getInstance().build("/test/fragment")
//                        .withString("name", "老王")
//                        .withInt("age", 18)
//                        .withBoolean("boy", true)
//                        .withLong("high", 180)
//                        .withString("url", "https://a.b.c")
//                        .withSerializable("ser", testSerializable)
//                        .withParcelable("pac", testParcelable)
//                        .withObject("obj", testObj)
//                        .withObject("objList", objList)
//                        .withObject("map", map)
//                        .navigation();
////                fragment.showLog();
//                Toast.makeText(this, "找到Fragment:" + fragment.toString(), Toast.LENGTH_SHORT).show();
//
//                // 将 Fragment 加载到当前 Activity 中
//                FragmentManager fragmentManager = getSupportFragmentManager(); // 如果是使用 Support Library 的 Fragment，则使用 getSupportFragmentManager()
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.fragment_container, fragment); // R.id.fragment_container 是您在布局文件中定义的 Fragment 容器的 id
//                transaction.commit();
                break;
        }
    }
}