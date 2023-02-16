package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageButton button;
    private static Context context;
    private Random r = new Random();
    ImageButton btnM,btnSFX;
    public static MediaPlayer music;
    public  MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        button = (ImageButton) findViewById(R.id.imageButton5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
                MainActivity.this.finish();
            }

        });
        musicstar();
        btnM = (ImageButton) findViewById(R.id.imageButton);
        btnSFX = (ImageButton) findViewById(R.id.imageButton3);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameManager.activeMusic == true) {
                    music.pause();
                    GameManager.activeMusic = false;
                    ClickMusic();
                    btnM.setImageResource(R.drawable.musicmute);
                } else {
                    music = MediaPlayer.create(getBaseContext(), R.raw.nen);
                    music.setLooping(true);
                    music.setVolume(510, 10);
                    music.start();
                    GameManager.activeMusic = true;
                    ClickMusic();
                    btnM.setImageResource(R.drawable.music);
                }
            }
        });
        btnSFX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameManager.activeSFX == true) {
                    GameManager.activeSFX = false;
                    btnSFX.setImageResource(R.drawable.audiomute);
                } else {
                    GameManager.activeSFX = true;
                    btnSFX.setImageResource(R.drawable.audio);
                }
            }
        });
        coinUpdate();
        combineUpdate();
        loadData();


    }

    public void musicstar() {
        music = MediaPlayer.create(this, R.raw.nen);
        music.setLooping(false);
        music.setVolume(10, 10);
        music.start();
        mediaPlayer = MediaPlayer.create(this, R.raw.click1);
    }

    public void coinUpdate(){
        // update coin
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameManager.coinUpdate();
            }
        }, 0, 1000);
        //wait 0 ms before doing the action and do it evry 1000ms (1second)
    }

    public void combineUpdate() {
        // update coin
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameManager.charCombine();
                Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        boolean combine1 = GameManager.removeCharCombine(GameManager.listChar1);
                        boolean combine2 = GameManager.removeCharCombine(GameManager.listChar2);
                        boolean combine3 = GameManager.removeCharCombine(GameManager.listChar3);
                        boolean combine6 = GameManager.removeCharCombine(GameManager.listChar6);
                        boolean combine7 = GameManager.removeCharCombine(GameManager.listChar7);
                        if (combine1 == true) {
                            addChar(R.drawable.creater_01,GameManager.listChar2,25);
                            GameManager.unclockChar2 = true;
                        }
                        if (combine2 == true) {
                            addChar(R.drawable.creater_02,GameManager.listChar3,60);
                            GameManager.unclockChar3 = true;
                        }
                        if (combine3 == true) {
                            addChar(R.drawable.creater_03,GameManager.listChar6,130);
                            GameManager.unclockChar6 = true;
                        }
                        if (combine6 == true) {
                            addChar(R.drawable.creater_04,GameManager.listChar7,300);
                            GameManager.unclockChar7 = true;
                        }
                        if (combine7 == true) {
                            addChar(R.drawable.creater_05,GameManager.listChar8,800);
                            GameManager.unclockChar8 = true;
                        }
                    }
                }, 600);
            }
        }, 15000, 8000);
        //wait 0 ms before doing the action and do it evry 1000ms (1second)
    }

    public void loadData(){
        FileInputStream fis = null;
        try {
            fis = openFileInput(GameActivity.fileName);
            //MainActivity.context = getApplicationContext();
            //AssetManager am = context.getAssets();
            //InputStream is = am.open("saveFile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(inputStreamReader);
            GameManager.loadData(br);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if( fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0 ; i < GameManager.list1size ; i++)
        {
            addChar(R.drawable.creater_00,GameManager.listChar1,10);
        }
        for (int i = 0 ; i < GameManager.list2size ; i++)
        {
            addChar(R.drawable.creater_01,GameManager.listChar2,25);
        }
        for (int i = 0 ; i < GameManager.list3size ; i++)
        {
            addChar(R.drawable.creater_02,GameManager.listChar3,60);
        }
        for (int i = 0 ; i < GameManager.list6size ; i++)
        {
            addChar(R.drawable.creater_03,GameManager.listChar6,130);
        }
        for (int i = 0 ; i < GameManager.list7size ; i++)
        {
            addChar(R.drawable.creater_04,GameManager.listChar7,300);
        }
        for (int i = 0 ; i < GameManager.list8size ; i++)
        {
            addChar(R.drawable.creater_05,GameManager.listChar8,800);
        }
        if(GameManager.second <= 10800){
            GameManager.coinAfk = GameManager.coinpersecond() * GameManager.second;
        }
        else
        {
            GameManager.coinAfk = GameManager.coinpersecond() * GameManager.timeAfk;
        }
        GameManager.coin += GameManager.coinAfk;
    }

    public void addChar(int resource, List<CharacterSprite> list,int coin_s)
    {
        int x= r.nextInt(880);
        int y= r.nextInt(1620);
        Bitmap image = BitmapFactory.decodeResource(getResources(), resource);
        CharacterSprite characterSprite = new CharacterSprite(image, x, y,coin_s);
        list.add(characterSprite);
    }

    public void ClickMusic(){
        if(GameManager.activeSFX == true){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.click1);
            mediaPlayer.start();
        }

    }

}