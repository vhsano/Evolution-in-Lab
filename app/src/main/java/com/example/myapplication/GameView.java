package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView  extends SurfaceView implements Runnable {

    private  Thread thread;
    private  boolean isPlaying;
    private Creater creater;
    private Paint paint;
    private int screenX, screenY;


    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;

        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying){
            draw();
        }
    }

    public  void draw() {
        if(getHolder().getSurface().isValid()){
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawColor(Color.TRANSPARENT);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public  void resume () {
        isPlaying = true;
         thread = new Thread(this);
         thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
