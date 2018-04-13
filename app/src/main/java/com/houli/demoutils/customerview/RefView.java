package com.houli.demoutils.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by stone on 2018/4/13.
 * 自定义绘制方形
 */

public class RefView extends View {


    private Paint totalPaint,progressPaint,linePaint,textPaint;
    public  Canvas canvas;
    public float mWidth;

    //创建一个画笔
    public RefView(Context context) {
        super(context);
    }

    public RefView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(100,100,100,50,linePaint);//刚开始的时间线
        canvas.drawText("计划时间",50, 50, textPaint);//开始的地方画文字提示

        canvas.drawRect(100, 100, 800, 200, totalPaint);//总的长度

        canvas.drawLine(800, 100, 800, 50, linePaint);//总长度后面的线
        canvas.drawText("当前时间",700, 50, textPaint);//最后画文字提示

        canvas.drawLine(600,100,600,50,linePaint);//这个是进度的时间线
        canvas.drawText("预计完成",500, 50, textPaint);//进行中文字提示
        canvas.drawRect(100,100,600,200,progressPaint);//画当前进度矩形
    }

    //初始化paint
    private void initPaint() {
        //背景矩形
        totalPaint = new Paint();
        totalPaint.setColor(Color.GRAY);
        totalPaint.setStyle(Paint.Style.FILL);//填充画笔模式
        totalPaint.setStrokeWidth(10f);//宽度10px

        //进度矩形
        progressPaint = new Paint();
        progressPaint.setColor(Color.YELLOW);
        progressPaint.setStyle(Paint.Style.FILL);//填充画笔模式
        progressPaint.setStrokeWidth(10f);//宽度10px

        //进度出拉出来的竖线
        linePaint = new Paint();
        linePaint.setStrokeWidth(8);
        linePaint.setColor(Color.MAGENTA);

        //文字画笔
        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setStyle(Paint.Style.FILL);//填充画笔模式
        textPaint.setStrokeWidth(10f);//宽度10px
        textPaint.setTextSize(40);
        textPaint.setTextAlign(Paint.Align.LEFT);

        //创建Canvas
        canvas = new Canvas();
    }

    public void setWidth(float mWidth){

    }


}
