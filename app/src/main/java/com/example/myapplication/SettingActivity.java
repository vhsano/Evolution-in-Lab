package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {
    private ImageButton buttonBack;
    ImageButton btn;
    private SwitchCompat switchCompat, switchCompat2;
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
        setContentView(R.layout.activity_setting);
        buttonBack = (ImageButton) findViewById(R.id.imageButton3);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingActivity();
                SettingActivity.this.finish();
            }
        });

        switchCompat=findViewById(R.id.switchCompat);
        switchCompat2=findViewById(R.id.switchCompat2);
        if(GameManager.activeMusic == true)
        {
            switchCompat.setChecked(true);
        }
        else {
            switchCompat.setChecked(false);
        }
        if(GameManager.activeSFX == true)
        {
            switchCompat2.setChecked(true);
        }
        else {
            switchCompat2.setChecked(false);
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    GameManager.activeMusic = true;
                    MainActivity.music.start();

                }
                else
                {
                    GameManager.activeMusic = false;
                    MainActivity.music.pause();
                }
            }
        });
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    GameManager.activeSFX = true;
                    ClickMusic();
                }
                else
                {
                    GameManager.activeSFX = false;
                    ClickMusic();
                }
            }
        });
    }

    public  void openSettingActivity(){
        Intent intent =new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void ClickMusic(){
        if(GameManager.activeSFX == true) {
            mediaPlayer = MediaPlayer.create(SettingActivity.this, R.raw.click1);
            mediaPlayer.start();
        }
    }
}