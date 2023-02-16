package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.util.List;
import java.util.Random;

public class StoreActivity extends AppCompatActivity {
    private ImageButton buttonBack;
    private ImageButton buttonBuy1;
    private ImageButton buttonBuy2;
    private ImageButton buttonBuy3;
    private ImageButton buttonBuy6,buttonBuy7,buttonBuy8;
    private TextView charcost1,charcost2,charcost3,charcost6,charcost7,charcost8;
    private ImageButton char2, char3, char6, char7, char8;
    int x,y;
    Random r = new Random();
    public  MediaPlayer  mediaPlayer;
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
        setContentView(R.layout.activity_store);
        buttonBack = (ImageButton) findViewById(R.id.imageButton21);
        buttonBuy1 = (ImageButton) findViewById(R.id.imageButton4);
        buttonBuy2 = (ImageButton) findViewById(R.id.imageButton6);
        buttonBuy3 = (ImageButton) findViewById(R.id.imageButton8);
        buttonBuy6 = (ImageButton) findViewById(R.id.imageButton10);
        buttonBuy7 = (ImageButton) findViewById(R.id.imageButton12);
        buttonBuy8 = (ImageButton) findViewById(R.id.imageButton14);
        charcost1 = (TextView) findViewById(R.id.text1) ;
        charcost2 = (TextView) findViewById(R.id.text2) ;
        charcost3 = (TextView) findViewById(R.id.text3) ;
        charcost6 = (TextView) findViewById(R.id.text4) ;
        charcost7 = (TextView) findViewById(R.id.text5) ;
        charcost8 = (TextView) findViewById(R.id.text6) ;
        char2 = (ImageButton) findViewById(R.id.imageButton5) ;
        char3 = (ImageButton) findViewById(R.id.imageButton7) ;
        char6 = (ImageButton) findViewById(R.id.imageButton9) ;
        char7 = (ImageButton) findViewById(R.id.imageButton11) ;
        char8 = (ImageButton) findViewById(R.id.imageButton13) ;

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
                StoreActivity.this.finish();
                ClickMusic();
            }
        });

        if ( GameManager.coin < GameManager.char1Const )
        {
            buttonBuy1.setEnabled(false);
        }else {
            buttonBuy1.setEnabled(true);
            buttonBuy1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi1size =GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size();
                    GameManager.unclockChar1 = true;
                    GameManager.char1Const += GameManager.char1Const*0.1;
                    if( envi1size < 5)
                        buyChar(GameManager.char1Const,R.drawable.creater_00,GameManager.listChar1,10);
                    charconstUpdate(charcost1,GameManager.char1Const);
                    ClickMusic();
                }
            });
        }

        if ( GameManager.coin < GameManager.char2Const )
        {
            buttonBuy2.setEnabled(false);
        }else {
            buttonBuy2.setEnabled(true);
            buttonBuy2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi1size =GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size();
                    GameManager.unclockChar2 = true;
                    GameManager.char2Const += GameManager.char2Const*0.1;
                    if( envi1size < 5)
                    buyChar(GameManager.char2Const,R.drawable.creater_01,GameManager.listChar2,25);
                    charconstUpdate(charcost2,GameManager.char2Const);
                    ClickMusic();
                }
            });
        }

        if ( GameManager.coin < GameManager.char3Const )
        {
            buttonBuy3.setEnabled(false);
        }else {
            buttonBuy3.setEnabled(true);
            buttonBuy3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi1size =GameManager.listChar1.size() + GameManager.listChar2.size() + GameManager.listChar3.size();
                    GameManager.unclockChar3 = true;
                    GameManager.char3Const += GameManager.char3Const*0.1;
                    if( envi1size < 5)
                    buyChar(GameManager.char3Const,R.drawable.creater_02,GameManager.listChar3,60);
                    charconstUpdate(charcost3,GameManager.char3Const);
                    ClickMusic();
                }
            });
        }

        if ( GameManager.coin < GameManager.char6Const )
        {
            buttonBuy6.setEnabled(false);
        }
        else {
            buttonBuy6.setEnabled(true);
            buttonBuy6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi2size =GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size();
                    GameManager.unclockChar6 = true;
                    GameManager.char6Const += GameManager.char6Const*0.1;
                    if( envi2size < 5)
                    buyChar(GameManager.char6Const,R.drawable.creater_03,GameManager.listChar6,130);
                    charconstUpdate(charcost6,GameManager.char6Const);
                    ClickMusic();
                }
            });
        }

        if ( GameManager.coin < GameManager.char7Const )
        {
            buttonBuy7.setEnabled(false);
        }
        else {
            buttonBuy7.setEnabled(true);
            buttonBuy7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi2size =GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size();
                    GameManager.unclockChar7 = true;
                    GameManager.char7Const += GameManager.char7Const*0.1;
                    if( envi2size < 5)
                        buyChar(GameManager.char7Const,R.drawable.creater_04,GameManager.listChar7,300);
                    charconstUpdate(charcost7,GameManager.char7Const);
                    ClickMusic();
                }
            });
        }

        if ( GameManager.coin < GameManager.char8Const )
        {
            buttonBuy8.setEnabled(false);
        }
        else {
            buttonBuy8.setEnabled(true);
            buttonBuy8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int envi2size =GameManager.listChar6.size() + GameManager.listChar7.size() + GameManager.listChar8.size();
                    GameManager.unclockChar8 = true;
                    GameManager.char8Const += GameManager.char8Const*0.1;
                    if( envi2size < 5)
                        buyChar(GameManager.char8Const,R.drawable.creater_05,GameManager.listChar8,800);
                    charconstUpdate(charcost8,GameManager.char8Const);
                    ClickMusic();
                }
            });
        }
        updateStore(charcost1,charcost2,charcost3,charcost6,charcost7,charcost8,char2,char3,char6,char7,char8);
    }

    public  void openGameActivity(){
        Intent intent =new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void buyChar(int charConst,int resource, List<CharacterSprite> list,int coin_s){
        if ( GameManager.coin >= charConst ) {
            x= r.nextInt(880);
            y= r.nextInt(1620);
            Bitmap image = BitmapFactory.decodeResource(getResources(),resource);
            CharacterSprite characterSprite = new CharacterSprite(image, x, y,coin_s);
            list.add(characterSprite);
            GameManager.coin = GameManager.coin - charConst;
        }
    }
    public void charconstUpdate(TextView charCost,int cost){
        charCost.setText(String.valueOf(cost));
    }

    public void updateStore(TextView char1cost, TextView char2cost, TextView char3cost, TextView char6cost, TextView char7cost,TextView char8cost, ImageView char2, ImageView char3, ImageView char6, ImageView char7, ImageView char8)
    {
        char1cost.setText(String.valueOf(GameManager.char1Const));
        if(GameManager.unclockChar2 == false)
        {
            char2cost.setText("!!!!");
            char2.setImageResource(R.drawable.questionicon);
        }
        else
        {
            char2cost.setText(String.valueOf(GameManager.char2Const));
            char2.setImageResource(R.drawable.creater_01);
        }
        if(GameManager.unclockChar3 == false)
        {
            char3cost.setText("!!!!");
            char3.setImageResource(R.drawable.questionicon);
        }
        else
        {
            char3cost.setText(String.valueOf(GameManager.char3Const));
            char3.setImageResource(R.drawable.creater_02);
        }
        if(GameManager.unclockChar6 == false)
        {
            char6cost.setText("!!!!");
            char6.setImageResource(R.drawable.questionicon);
        }
        else
        {
            char6cost.setText(String.valueOf(GameManager.char6Const));
            char6.setImageResource(R.drawable.creater_03);
        }
        if(GameManager.unclockChar7 == false)
        {
            char7cost.setText("!!!!");
            char7.setImageResource(R.drawable.questionicon);
        }
        else
        {
            char7cost.setText(String.valueOf(GameManager.char7Const));
            char7.setImageResource(R.drawable.creater_04);
        }
        if(GameManager.unclockChar8 == false)
        {
            char8cost.setText("!!!!");
            char8.setImageResource(R.drawable.questionicon);
        }
        else
        {
            char8cost.setText(String.valueOf(GameManager.char8Const));
            char8.setImageResource(R.drawable.creater_05);
        }
    }
    public void ClickMusic(){
        if(GameManager.activeSFX == true) {
            mediaPlayer = MediaPlayer.create(StoreActivity.this, R.raw.click1);
            mediaPlayer.start();
        }
    }
}