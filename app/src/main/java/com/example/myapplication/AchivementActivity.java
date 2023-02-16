package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AchivementActivity extends AppCompatActivity {

    private ImageButton buttonBack, buttonSetting;
    private ImageButton reward1, reward2, reward3, reward4, reward5, reward6, reward7, reward8, reward9;
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
        setContentView(R.layout.activity_achivement);
        buttonBack = (ImageButton) findViewById(R.id.imageButton13);
        buttonSetting = (ImageButton) findViewById(R.id.imageButton2);
        reward1 = (ImageButton) findViewById(R.id.imageButton1_2);
        reward2 = (ImageButton) findViewById(R.id.imageButton2_2);
        reward3 = (ImageButton) findViewById(R.id.imageButton3_2);
        reward4 = (ImageButton) findViewById(R.id.imageButton4_2);
        reward5 = (ImageButton) findViewById(R.id.imageButton5_2);
        reward6 = (ImageButton) findViewById(R.id.imageButton6_2);
        reward7 = (ImageButton) findViewById(R.id.imageButton7_2);
        reward8 = (ImageButton) findViewById(R.id.imageButton8_2);
        reward9 = (ImageButton) findViewById(R.id.imageButton9_2);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackActivity();
                AchivementActivity.this.finish();
                ClickMusic();
            }
        });
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingActivity();
                ClickMusic();
            }
        });
        reward1.setEnabled(false);
        reward2.setEnabled(false);
        reward3.setEnabled(false);
        reward4.setEnabled(false);
        reward5.setEnabled(false);
        reward6.setEnabled(false);
        reward7.setEnabled(false);
        reward8.setEnabled(false);
        reward9.setEnabled(false);

        updateAchivenmennt();
        loadAchivement(GameManager.rewardAchi1, reward1);
        loadAchivement(GameManager.rewardAchi2, reward2);
        loadAchivement(GameManager.rewardAchi3, reward3);
        loadAchivement(GameManager.rewardAchi4, reward4);
        loadAchivement(GameManager.rewardAchi5, reward5);
        loadAchivement(GameManager.rewardAchi6, reward6);
        loadAchivement(GameManager.rewardAchi7, reward7);
        loadAchivement(GameManager.rewardAchi8, reward8);
        loadAchivement(GameManager.rewardAchi9, reward9);
        reward1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi1 = true;
                GameManager.coin += 500;
                message("Reward 500 Dna");
                loadAchivement(GameManager.rewardAchi1, reward1);
                ClickMusic();
            }

        });
        reward2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi2 = true;
                GameManager.coin += 5000;
                message("Reward 5000 Dna");
                loadAchivement(GameManager.rewardAchi2, reward2);
                ClickMusic();
            }

        });
        reward3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi3 = true;
                GameManager.coin += 50000;
                message("Reward 50000 Dna");
                loadAchivement(GameManager.rewardAchi3, reward3);
                ClickMusic();
            }

        });
        reward4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi4 = true;
                GameManager.coin += 500000;
                message("Reward 500000 Dna");
                loadAchivement(GameManager.rewardAchi4, reward4);
                ClickMusic();
            }

        });
        reward5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi5 = true;
                GameManager.coin += 50000000;
                message("Reward 5M Dna");
                loadAchivement(GameManager.rewardAchi5, reward5);
                ClickMusic();
            }

        });
        reward6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager.rewardAchi6 = true;
                GameManager.coin += 500000000;
                message("Reward 500M Dna");
                loadAchivement(GameManager.rewardAchi6, reward6);
                ClickMusic();
            }

        });

    }

    public  void openBackActivity(){
        Intent intent =new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public  void openSettingActivity(){
        Intent intent =new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void loadAchivement( boolean rewardAchi, ImageButton reward){
        if(rewardAchi == true){
            reward.setEnabled(false);
            reward.setBackgroundColor(Color.GRAY);
        }
    }
    public void updateAchivenmennt()
    {
        if(GameManager.unclockChar1 == true)
        {
            GameManager.unclockAchi1 = true;
            reward1.setBackgroundColor(Color.YELLOW);
            reward1.setEnabled(true);
        }

        if(GameManager.unclockChar2 == true)
        {
            GameManager.unclockAchi2 = true;
            reward2.setBackgroundColor(Color.YELLOW);
            reward2.setEnabled(true);
        }
        if(GameManager.unclockChar3 == true)
        {
            GameManager.unclockAchi3 = true;
            reward3.setBackgroundColor(Color.YELLOW);
            reward3.setEnabled(true);
        }
        if(GameManager.coin >= 1000000)
        {
            GameManager.unclockAchi4 = true;
            reward4.setBackgroundColor(Color.YELLOW);
            reward4.setEnabled(true);
        }
        if(GameManager.coin >= 500000000)
        {
            GameManager.unclockAchi5 = true;
            reward5.setBackgroundColor(Color.YELLOW);
            reward5.setEnabled(true);
        }
        if(GameManager.coin >= 1000000000)
        {
            GameManager.unclockAchi6 = true;
            reward6.setBackgroundColor(Color.YELLOW);
            reward6.setEnabled(true);
        }
    }
    public void message(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do nothing
                    }
                })
                .show();
    }
    public void ClickMusic(){
        if(GameManager.activeSFX == true) {
            mediaPlayer = MediaPlayer.create(AchivementActivity.this, R.raw.click1);
            mediaPlayer.start();
        }
    }
}