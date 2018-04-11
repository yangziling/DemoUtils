package com.houli.demoutils.wheelview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.houli.demoutils.BaseActivity;
import com.houli.demoutils.R;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stone on 2018/4/10.
 */

public class WheelViewActivity extends BaseActivity {

    private WheelView mainWheelView, subWheelView, childWheelView,subWheelView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelview);
        initWheel1();
    }

    private void  initWheel1() {
        //第一层
        mainWheelView = (WheelView) findViewById(R.id.main_wheelview);
        mainWheelView.setWheelAdapter(new ArrayWheelAdapter(this));
        mainWheelView.setSkin(WheelView.Skin.Common);
        mainWheelView.setWheelData(createMainDatas());
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextSize = 20;
        style.textSize = 16;
        mainWheelView.setStyle(style);

        //第二层
        subWheelView = (WheelView) findViewById(R.id.sub_wheelview);
        subWheelView.setWheelAdapter(new ArrayWheelAdapter(this));
        subWheelView.setSkin(WheelView.Skin.Holo);
        subWheelView.setWheelData(createSubDatas().get(createMainDatas().get(mainWheelView.getSelection())));
        subWheelView.setStyle(style);
        mainWheelView.join(subWheelView);
        mainWheelView.joinDatas(createSubDatas());

        //第三层
        childWheelView = (WheelView) findViewById(R.id.child_wheelview);
        childWheelView.setWheelAdapter(new ArrayWheelAdapter(this));
        childWheelView.setSkin(WheelView.Skin.Holo);
        childWheelView.setWheelData(createChildDatas().get(createSubDatas().get(createMainDatas().get(mainWheelView
                .getSelection())).get(subWheelView.getSelection())));
        childWheelView.setStyle(style);
        subWheelView.join(childWheelView);
        subWheelView.joinDatas(createChildDatas());

        //最后一层 跟随第一层进行变动
        subWheelView2= (WheelView) findViewById(R.id.sub_wheelview2);
        subWheelView2.setWheelAdapter(new ArrayWheelAdapter(this));
        subWheelView2.setSkin(WheelView.Skin.Holo);
        subWheelView2.setWheelData(createSubDatas2().get(createMainDatas().get(mainWheelView.getSelection())));
        subWheelView2.setStyle(style);
        mainWheelView.join(subWheelView2);
        mainWheelView.joinDatas(createSubDatas2());
    }

    private List<String> createMainDatas() {
        String[] strings = {"黑龙江", "吉林", "辽宁"};
        return Arrays.asList(strings);
    }

    private HashMap<String, List<String>> createSubDatas() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        String[] strings = {"黑龙江", "吉林", "辽宁"};
        String[] s1 = {"哈尔滨", "齐齐哈尔", "大庆"};
        String[] s2 = {"长春", "吉林"};
        String[] s3 = {"沈阳", "大连", "鞍山", "抚顺"};
        String[][] ss = {s1, s2, s3};
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], Arrays.asList(ss[i]));
        }
        return map;
    }
    //第四层的数据
    private HashMap<String, List<String>> createSubDatas2() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        String[] strings = {"黑龙江", "吉林", "辽宁"};
        String[] s1 = {"黑", "龙", "江"};
        String[] s2 = {"吉", "林"};
        String[] s3 = {"辽", "宁", "山", "抚"};
        String[][] ss = {s1, s2, s3};
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], Arrays.asList(ss[i]));
        }
        return map;
    }

    private HashMap<String, List<String>> createChildDatas() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        String[] strings = {"哈尔滨", "齐齐哈尔", "大庆", "长春", "吉林", "沈阳", "大连", "鞍山", "抚顺"};
        String[] s1 = {"道里区", "道外区", "南岗区", "香坊区"};
        String[] s2 = {"龙沙区", "建华区", "铁锋区"};
        String[] s3 = {"红岗区", "大同区"};
        String[] s11 = {"南关区", "朝阳区"};
        String[] s12 = {"龙潭区"};
        String[] s21 = {"和平区", "皇姑区", "大东区", "铁西区"};
        String[] s22 = {"中山区", "金州区"};
        String[] s23 = {"铁东区", "铁西区"};
        String[] s24 = {"新抚区", "望花区", "顺城区"};
        String[][] ss = {s1, s2, s3, s11, s12, s21, s22, s23, s24};
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], Arrays.asList(ss[i]));
        }
        return map;
    }
}
