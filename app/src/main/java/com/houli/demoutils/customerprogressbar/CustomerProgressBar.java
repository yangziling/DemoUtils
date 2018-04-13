package com.houli.demoutils.customerprogressbar;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Created by stone on 2018/4/13.
 */

public class CustomerProgressBar extends ProgressBar {

    Paint mPaint = new Paint();

    public CustomerProgressBar(Context context) {
        super(context);
    }

    public CustomerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStrokeWidth(20f);
    }

    public CustomerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
