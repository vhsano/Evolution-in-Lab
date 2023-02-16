package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.telephony.CellSignalStrength;

public class CharacterSprite {
    private Bitmap image;
    private float x,y;
    private int width,height;
    public boolean combine = false;
    private  int xVelocity = 6;
    private  int yVelocity = 3;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels + 100;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels + 100;
    private int screenXcenter = 540;
    private int screenYcenter = 960;
    private float xtoCenter ;
    private float ytoCenter ;


    public int coin_s ;

    public CharacterSprite(Bitmap bmp,int x ,int y, int coins){
        image = bmp;
        this.x= x;
        this.y= y;
        this.coin_s = coins;
        width = 300;
        height = 300;
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image,x,y,null);
    }

    public void update() {
        if(combine == true)
        {
            if( x != 540 || y != 960 )
            {
                if (x > screenXcenter) {
                    if (y > screenYcenter) {
                        xtoCenter = x - screenXcenter;
                        ytoCenter = y - screenYcenter;
                        if (xtoCenter >= ytoCenter) {
                            x = x - (xtoCenter / ytoCenter * 10);
                            y = y - (ytoCenter / xtoCenter * 10);
                        } else {
                            x = x - (ytoCenter / xtoCenter * 10);
                            y = y - (xtoCenter / ytoCenter * 10);
                        }
                    } else {
                        xtoCenter = x - screenXcenter;
                        ytoCenter = screenYcenter - y;
                        if (xtoCenter >= ytoCenter) {
                            x = x - (xtoCenter / ytoCenter * 10);
                            y = y + (ytoCenter / xtoCenter * 10);
                        } else {
                            x = x - (ytoCenter / xtoCenter * 10);
                            y = y + (xtoCenter / ytoCenter * 10);
                        }
                    }
                } else {
                    if (y > screenYcenter) {
                        xtoCenter = screenXcenter - x;
                        ytoCenter = y - screenYcenter;
                        if (xtoCenter >= ytoCenter) {
                            x = x + (xtoCenter / ytoCenter * 10);
                            y = y - (ytoCenter / xtoCenter * 10);
                        } else {
                            x = x + (ytoCenter / xtoCenter * 10);
                            y = y - (xtoCenter / ytoCenter * 10);
                        }
                    } else {
                        xtoCenter = screenXcenter - x;
                        ytoCenter = screenYcenter - y;
                        if (xtoCenter >= ytoCenter) {
                            x = x + (xtoCenter / ytoCenter * 10);
                            y = y + (ytoCenter / xtoCenter * 10);
                        } else {
                            x = x + (ytoCenter / xtoCenter * 10);
                            y = y + (xtoCenter / ytoCenter * 10);
                        }
                    }
                }
            }
        }
        else {
            if (x < 0 && y < 0) {
                x = screenWidth / 2;
                y = screenHeight / 2;
            } else {
                x += xVelocity;
                y += yVelocity;
                if ((x > (screenWidth - image.getWidth())) || (x < 0)) {
                    xVelocity = xVelocity * -1;
                }
                if ((y > (screenHeight - image.getHeight())) || (y < 0)) {
                    yVelocity = yVelocity * -1;
                }
            }
        }
    }
}
