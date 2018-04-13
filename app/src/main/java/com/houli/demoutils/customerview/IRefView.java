package com.houli.demoutils.customerview;

import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by stone on 2018/4/13.
 */

public interface IRefView {
    //设置画笔的属性
     Paint getPaint(ArrayList<Paint> paints);
}
