package com.example.administrator.matrixtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/7/8.
 */
public class MyView extends View {
    private Bitmap bitmap;
    private Matrix matrix = new Matrix();
    private float sx = 0.0f;
    private int width,height;
    private float scale = 1.0f;
    private boolean isSacle = false;
    public MyView(Context context,AttributeSet set){
        super(context,set);
        bitmap = ((BitmapDrawable)context.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        this.setFocusable(true);
    }
    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        matrix.reset();
        if(!isSacle){
            matrix.setSkew(sx,0);
        }
        else{
            matrix.setScale(scale,scale);
        }
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        canvas.drawBitmap(bitmap2, matrix, null);
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_A:
                isSacle = false;
                sx += 0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_D:
                isSacle = false;
                sx -= 0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_W:
                isSacle = true;
                if(scale<2.0)
                    scale += 0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_S:
                isSacle = true;
                if(scale>0.5)
                    scale -= 0.1;
                postInvalidate();
                break;
        }
        return super.onKeyDown(keyCode,event);
    }

}
