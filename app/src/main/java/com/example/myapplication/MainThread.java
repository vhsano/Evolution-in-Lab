package com.example.myapplication;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.util.Timer;
import java.util.TimerTask;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameCanvas gameCanvas;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GameCanvas gameCanvas) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameCanvas = gameCanvas;
    }



    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameCanvas.update();
                    this.gameCanvas.draw(canvas);
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}

