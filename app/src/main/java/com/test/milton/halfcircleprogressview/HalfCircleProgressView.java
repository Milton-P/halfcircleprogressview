package com.test.milton.halfcircleprogressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Milton on 2017/6/15.
 */

public class HalfCircleProgressView extends View {

    Paint mPaint;
    RectF mRectF;
    //颜色以及宽度
    private int mFirstColor;
    private int mSecondColor;
    private int mCircleWidth;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);//绘图为描边模式
        mPaint.setStrokeWidth(20);//画笔宽度
        mPaint.setAntiAlias(true);//抗锯齿
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //得到画布一半的宽度
        int center = getWidth() / 2;
        int height = getHeight();
        canvas.translate(center, height-center/4);
        //定义圆的半径
        int radius = getWidth() / 2*3/4;
        //定义一个圆  (float left, float top, float right, float bottom)
        mRectF = new RectF(-radius, -radius,  radius,  radius);
       //设置画笔的颜色
        /*mPaint.setColor(Color.BLUE);
        //画一个圆，由于画笔是描边模式，所以展现的是个圆环
        canvas.drawCircle(center, center, radius, mPaint);*/
        //设置画笔的颜色
        mPaint.setColor(0x11222222);
        //绘制圆弧，从9点方向（-180度）开始绘制，偏移角度为进度
        canvas.drawArc(mRectF, -180,180, false, mPaint);
        mPaint.setColor(Color.BLUE);
        //绘制圆弧，从9点方向（-180度）开始绘制，偏移角度为进度
        canvas.drawArc(mRectF, -180,130, false, mPaint);

        Paint textPaint = new Paint();          // 创建画笔
        textPaint.setColor(Color.BLACK);        // 设置颜色
        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("募集进度",0,0,textPaint);
        canvas.translate(0, -height/3);
        canvas.drawText("100%",0,0,textPaint);


    }

    /*   public HalfCircleProgressView(){
           super();

       }*/
    public HalfCircleProgressView(Context context) {
        this(context, null);
        init();
    }

    public HalfCircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public HalfCircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray at = context.obtainStyledAttributes(attrs, R.styleable.HalfCircleProgressView, defStyleAttr, 0);
        //获取自定义属性和默认值
        //getColor方法的第一个参数是我们在XML文件中定义的颜色，如果我们没有给我们自定义的View定义颜色，他就会使用第二个参数中的默认值
        mFirstColor = at.getColor(R.styleable.HalfCircleProgressView_circleWidth, Color.RED);
        mSecondColor = at.getColor(R.styleable.HalfCircleProgressView_secondColor, Color.BLUE);
        mCircleWidth = at.getDimensionPixelSize(R.styleable.HalfCircleProgressView_circleWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
    }


}
