package com.example.myapplication;

import static android.os.Looper.getMainLooper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.Timer;
import java.util.TimerTask;


public class Creater {
    int x,y,width,height,moveCounter=0;
    Bitmap image;

    Creater(Bitmap bmp) {
        width = 100;
        height = 300;
        x=100;
        y=100;
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image,x,y,null);
    }

    public void update() {
        y++;
    }

}
