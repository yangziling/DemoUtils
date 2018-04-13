package com.houli.demoutils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.houli.demoutils.customerview.RefView;

/**
 * Created by stone on 2018/4/13.
 */

public class RefViewActivity extends BaseActivity{

    private RefView ref_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref_view);
        ref_view = (RefView) findViewById(R.id.ref_view);

    }

}
