package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends SurfaceView implements SurfaceHolder.Callback {

    Paint paint1, paint2;
    CharacterSprite creater1,creater2;
    private MainThread thread;
    private Bitmap background,topbackground,background2;
    private String coin,envi1size,envi2size,coinpersecond;
    private int environment ;

    public GameCanvas(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);
        setFocusable(true);
        //creater1 = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.char_01),100,200);
        //creater2 = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.char_01),25,900);
        paint1 = new Paint();
        paint2 = new Paint();
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background_01);
        background = Bitmap.createScaledBitmap(background, 1280, 2220, false);
        background2 = BitmapFactory.decodeResource(getResources(),R.drawable.background_04);
        background2 = Bitmap.createScaledBitmap(background2, 1280, 2220, false);
        topbackground = BitmapFactory.decodeResource(getResources(),R.drawable.paper_01);
        topbackground = Bitmap.createScaledBitmap(topbackground, 1080, 300, false);
        paint1.setColor(Color.RED);
        paint1.setStrokeWidth(5);
        paint1.setTextSize(60);
        paint1.setFakeBoldText(true);
        paint2.setColor(Color.GRAY);
        paint2.setStrokeWidth(5);
        paint2.setTextSize(50);
        paint2.setFakeBoldText(true);
        coin = String.valueOf(GameManager.coin);
        coinpersecond = String.valueOf(GameManager.coinpersecond());
        envi1size = String.valueOf(GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size());
        envi2size = String.valueOf(GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size());
        //listChar.add(creater1);
        //listChar.add(creater2);
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);
        setFocusable(true);
        //creater1 = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.char_01),100,200);
        //creater2 = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.char_01),25,900);
        paint1 = new Paint();
        paint2 = new Paint();
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background_01);
        background = Bitmap.createScaledBitmap(background, 1280, 2220, false);
        background2 = BitmapFactory.decodeResource(getResources(),R.drawable.background_04);
        background2 = Bitmap.createScaledBitmap(background2, 1280, 2220, false);
        topbackground = BitmapFactory.decodeResource(getResources(),R.drawable.paper_01);
        topbackground = Bitmap.createScaledBitmap(topbackground, 1080, 200, false);
        paint1.setColor(Color.RED);
        paint1.setStrokeWidth(5);
        paint1.setTextSize(60);
        paint1.setFakeBoldText(true);
        paint2.setColor(Color.GRAY);
        paint2.setStrokeWidth(5);
        paint2.setTextSize(50);
        paint2.setFakeBoldText(true);
        coin = String.valueOf(GameManager.coin);
        coinpersecond = String.valueOf(GameManager.coinpersecond());
        envi1size = String.valueOf(GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size());
        envi2size = String.valueOf(GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size());
        //listChar.add(creater1);
        //listChar.add(creater2);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(environment == 1) {
            canvas.drawBitmap(background, 0, 0, paint1);
            for (CharacterSprite item : GameManager.listChar1
            ) {
                item.draw(canvas);
            }
            for (CharacterSprite item : GameManager.listChar2
            ) {
                item.draw(canvas);
            }
            for (CharacterSprite item : GameManager.listChar3
            ) {
                item.draw(canvas);
            }
            canvas.drawBitmap(topbackground,0,0,paint1);
            canvas.drawText(coin,480,120,paint1);
            canvas.drawText(coinpersecond+"/S",500,180,paint2);
            canvas.drawText(envi1size+"/5",800,120,paint1);
        }
        if(environment == 2) {
            canvas.drawBitmap(background2, 0, 0, paint1);
            for (CharacterSprite item : GameManager.listChar6
            ) {
                item.draw(canvas);
            }
            for (CharacterSprite item : GameManager.listChar7
            ) {
                item.draw(canvas);
            }
            for (CharacterSprite item : GameManager.listChar8
            ) {
                item.draw(canvas);
            }
            canvas.drawBitmap(topbackground,0,0,paint1);
            canvas.drawText(coin,480,120,paint1);
            canvas.drawText(coinpersecond+"/S",500,180,paint2);
            canvas.drawText(envi2size+"/5",800,120,paint1);
        }



           // creater1.draw(canvas);
           // creater2.draw(canvas);
        //canvas.drawColor(Color.TRANSPARENT);
        //canvas.drawBitmap(creater.getMove(),350,350, paint);
        //canvas.drawBitmap(creater.getMove(),500,500, paint);
        //canvas.drawBitmap(creater.getMove(),200,1100, paint);
        //canvas.drawBitmap(creater.getMove(),700,800, paint);
        //for(int i=0 ; i < 6 ; i++)
        //{
        //    Random r = new Random();
        //    int y = r.nextInt(1920);
        //    int x = r.nextInt(1080);
        //    canvas.drawBitmap(creater.getMove(),x,y, paint);
        //}
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update(){
        environment = GameManager.environment;
        coinpersecond = String.valueOf(GameManager.coinpersecond());
        envi1size = String.valueOf(GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size());
        envi2size = String.valueOf(GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size());
        if(environment == 1) {
            for (CharacterSprite item : GameManager.listChar1
            ) {
                item.update();
            }
            for (CharacterSprite item : GameManager.listChar2
            ) {
                item.update();
            }
            for (CharacterSprite item : GameManager.listChar3
            ) {
                item.update();
            }
        }
        if(environment == 2) {
            for (CharacterSprite item : GameManager.listChar6
            ) {
                item.update();
            }
            for (CharacterSprite item : GameManager.listChar7
            ) {
                item.update();
            }
            for (CharacterSprite item : GameManager.listChar8
            ) {
                item.update();
            }
        }
        if(GameManager.coin > 1000000) {
            coin = String.format("%.02f"+"M",GameManager.coin/1000000f);
        }
        else {
            if(GameManager.coin > 1000000000)
            {
                coin = String.format("%.02f"+"B",GameManager.coin/1000000000);
            }
            else
                coin = String.valueOf(GameManager.coin);

        }

        //creater1.update();
        //creater2.update();
    }
}
