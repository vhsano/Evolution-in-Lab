package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameActivity extends AppCompatActivity {
    private ImageButton buttonSetting;
    private ImageButton buttonEra;
    private ImageButton buttonAlbum;
    private ImageButton buttonAchivement;
    private ImageButton buttonStore;
    private ImageButton buttonEnvironment1;
    private ImageButton buttonEnvironment2;
    private static Context context;
    public static final String fileName = "saveFile.txt";
    public  MediaPlayer  mediaPlayer;



    GameCanvas gameCanvas;

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
            setContentView(R.layout.activity_game);

            gameCanvas = (GameCanvas) findViewById(R.id.gamecanvas);
            buttonSetting = (ImageButton) findViewById(R.id.imageButton2);

            buttonAlbum = (ImageButton) findViewById(R.id.imageButton8);

            buttonAchivement = (ImageButton) findViewById(R.id.imageButton4);

            buttonEra = (ImageButton) findViewById(R.id.imageButton7);

            buttonStore = (ImageButton) findViewById(R.id.imageButton9);

            buttonEnvironment1 = (ImageButton) findViewById(R.id.environment1) ;

            buttonEnvironment2 = (ImageButton) findViewById(R.id.environment2) ;
            if(GameManager.unclockChar6 == false)
                buttonEnvironment2.setEnabled(false);
            else
                buttonEnvironment2.setEnabled(true);

            buttonSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivitySetting();
                    GameActivity.this.finish();
                    ClickMusic();
                }
            });
            buttonEra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivityEra();
                    GameActivity.this.finish();

                    ClickMusic();
                }
            });
            buttonAlbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivityAlbum();
                    GameActivity.this.finish();
                    ClickMusic();
                }
            });
            buttonAchivement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivityAchi();
                    GameActivity.this.finish();
                    ClickMusic();
                }
            });

            buttonStore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivityStore();
                    GameActivity.this.finish();
                    ClickMusic();
                }
            });
            buttonEnvironment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GameManager.environment = 2;
                }
            });

            buttonEnvironment1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GameManager.environment = 1;
                }
            });
            if(GameManager.showAfkGamereward == false){
                message(GameManager.coinAfk);
                GameManager.showAfkGamereward = true;
            }

        //Toast.makeText(getApplicationContext(),"+"+String.valueOf(GameManager.coinAfk),Toast.LENGTH_LONG).show();

        //Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String currentDateandTime = dateFormat.format(new Date());
        String test = ""+GameManager.coin
                        +"\n"+GameManager.listChar1.size()+"\n"+GameManager.listChar2.size()+"\n"+GameManager.listChar3.size()+"\n"+GameManager.listChar6.size()+"\n"+GameManager.listChar7.size()+"\n"+GameManager.listChar8.size()
                        +"\n"+GameManager.char1Const+"\n"+GameManager.char2Const+"\n"+GameManager.char3Const+"\n"+GameManager.char6Const+"\n"+GameManager.char7Const+"\n"+GameManager.char8Const
                        +"\n"+GameManager.unclockChar1+"\n"+GameManager.unclockChar2+"\n"+GameManager.unclockChar3+"\n"+GameManager.unclockChar6+"\n"+GameManager.unclockChar7+"\n"+GameManager.unclockChar8
                        +"\n"+GameManager.unclockAchi1+"\n"+GameManager.unclockAchi2+"\n"+GameManager.unclockAchi3+"\n"+GameManager.unclockAchi4+"\n"+GameManager.unclockAchi5+"\n"+GameManager.unclockAchi6
                        +"\n"+GameManager.rewardAchi1+"\n"+GameManager.rewardAchi2+"\n"+GameManager.rewardAchi3+"\n"+GameManager.rewardAchi4+"\n"+GameManager.rewardAchi5+"\n"+GameManager.rewardAchi6+"\n"+currentDateandTime+"\n";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName,MODE_PRIVATE);
            fos.write(test.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //Toast.makeText(this,"save to " + getFilesDir() + "/" + fileName,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
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
        setContentView(R.layout.activity_game);

        gameCanvas = (GameCanvas) findViewById(R.id.gamecanvas);
        buttonSetting = (ImageButton) findViewById(R.id.imageButton2);

        buttonAlbum = (ImageButton) findViewById(R.id.imageButton8);

        buttonAchivement = (ImageButton) findViewById(R.id.imageButton4);

        buttonEra = (ImageButton) findViewById(R.id.imageButton7);

        buttonStore = (ImageButton) findViewById(R.id.imageButton9);


        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySetting();
                GameActivity.this.finish();
                ClickMusic();
            }
        });
        buttonEra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityEra();
                GameActivity.this.finish();
                ClickMusic();
            }
        });
        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAlbum();
                GameActivity.this.finish();
                ClickMusic();
            }
        });
        buttonAchivement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAchi();
                GameActivity.this.finish();
                ClickMusic();
            }
        });

        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityStore();
                GameActivity.this.finish();
                ClickMusic();
            }
        });
        //Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        onPause();
        exitByBackKey();
    }

    public  void openActivitySetting(){
        Intent intent =new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public  void openActivityEra(){
        Intent intent =new Intent(this, EraEvolutionActivity.class);
        startActivity(intent);
    }
    public  void openActivityAlbum(){
        Intent intent =new Intent(this, AlbumActivity.class);
        startActivity(intent);
    }
    public  void openActivityAchi(){
        Intent intent =new Intent(this, AchivementActivity.class);
        startActivity(intent);
    }

    public  void openActivityStore(){
        Intent intent =new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

    public void exitByBackKey(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit!!!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing
                    }
                })
                .show();
    }

    public void message(long afkCoin){
        String coinreward;
        if(afkCoin > 1000000) {
            coinreward = String.format("%.02f"+"M",afkCoin/1000000f);
        }
        else {
            if(GameManager.coin > 1000000000)
            {
                coinreward = String.format("%.02f"+"B",afkCoin/1000000000);
            }
            else
                coinreward = String.valueOf(afkCoin);
        }
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Afk Coin Reward: " + coinreward)
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do nothing
                    }
                })
                .show();
    }

    public void ClickMusic(){
        if(GameManager.activeSFX == true){
            mediaPlayer = MediaPlayer.create(GameActivity.this, R.raw.click1);
            mediaPlayer.start();
        }

    }


}