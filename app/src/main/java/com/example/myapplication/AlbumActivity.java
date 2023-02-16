package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumActivity extends AppCompatActivity {
    private ImageButton buttonBack,buttonNext,buttonPre;
    private int albumIndex = 1;
    private ImageView createrSprite;
    private TextView name, coinpersecond, describe;
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
        setContentView(R.layout.activity_album);
        buttonBack = (ImageButton) findViewById(R.id.imageButton13);
        buttonNext = (ImageButton) findViewById(R.id.imageButton12);
        buttonPre = (ImageButton) findViewById(R.id.imageButton11);
        createrSprite = (ImageView) findViewById(R.id.imageView7);
        name = (TextView) findViewById(R.id.textView6);
        coinpersecond = (TextView) findViewById(R.id.textView7);
        describe = (TextView) findViewById(R.id.textView8);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackActivity();
                AlbumActivity.this.finish();
                ClickMusic();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextAlbum();
                updateAlbum(albumIndex,createrSprite,name,coinpersecond,describe);
                ClickMusic();
            }
        });
        buttonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preAlbum();
                updateAlbum(albumIndex,createrSprite,name,coinpersecond,describe);
                ClickMusic();
            }
        });
        updateAlbum(albumIndex,createrSprite,name,coinpersecond,describe);
    }

    public  void openBackActivity(){
        Intent intent =new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void nextAlbum(){

        albumIndex ++;
    }

    public void preAlbum(){
        albumIndex --;
    }

    public void updateAlbum(int albumIndex, ImageView createrSprite, TextView name, TextView coinpersecond, TextView describe){
        /*switch (albumIndex){

            case '1' :
            {
                createrSprite.setImageResource(R.drawable.creater_00);
                break;
            }
            case '2' :
            {
                createrSprite.setImageResource(R.drawable.creater_01);
                break;
            }
            case '3' :
            {
                createrSprite.setImageResource(R.drawable.creater_02);
                break;
            }
        }*/
        if(albumIndex == 1)
        {
            if(GameManager.unclockChar1 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_00);
                name.setText("Archaea");
                coinpersecond.setText("10/s");
                describe.setText("Archaea constitute a domain of single-celled organisms. These microorganisms lack cell nuclei and are therefore prokaryotes. Archaea were initially classified as bacteria, receiving the name archaebacteria, but this term has fallen out of use.");
                describe.setTextSize(15);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
        if(albumIndex == 2)
        {
            if(GameManager.unclockChar2 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_01);
                name.setText("Paramecium");
                coinpersecond.setText("25/s");
                describe.setText("Paramecium is a genus of eukaryotic, unicellular ciliates, commonly studied as a representative of the ciliate group. Paramecia are widespread in freshwater, brackish, and marine environments and are often very abundant in stagnant basins and ponds. ");
                describe.setTextSize(14);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
        if(albumIndex == 3)
        {
            if(GameManager.unclockChar3 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_02);
                name.setText("Noctilucales");
                coinpersecond.setText("60/s");
                describe.setText("The Noctilucales are an order of marine dinoflagellates. They differ from most others in that the mature cell is diploid and its nucleus does not show a dinokaryotic organization. They show gametic meiosis.");
                describe.setTextSize(15);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
        if(albumIndex == 4)
        {
            if(GameManager.unclockChar6 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_03);
                name.setText("Spiggina");
                coinpersecond.setText("130/s");
                describe.setText("Spriggina is a genus of early bilaterian animals whose relationship to living animals is unclear. Fossils of Spriggina are known from the late Ediacaran period in what is now South Australia. Spriggina floundersi is the official fossil emblem of South Australia. It has been found nowhere else.");
                describe.setTextSize(14);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
        if(albumIndex == 5)
        {
            if(GameManager.unclockChar7 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_04);
                name.setText("Haikouichthys");
                coinpersecond.setText("300/s");
                describe.setText("Haikouichthys is an extinct genus of craniate that lived 518 million years ago, during the Cambrian explosion of multicellular life. ");
                describe.setTextSize(16);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
        if(albumIndex == 6)
        {
            if(GameManager.unclockChar8 == true)
            {
                createrSprite.setImageResource(R.drawable.creater_05);
                name.setText("Entelognathus");
                coinpersecond.setText("800/s");
                describe.setText("Entelognathus primordialis is a placoderm from the late Silurian of Qujing, Yunnan, 419 million years ago. A team led by Min Zhu of the Academy of Sciences' Institute of Vertebrate Paleontology and Paleoanthropology in Beijing discovered the intact, articulated fossil in rock formations at Xiaoxiang reservoir.");
                describe.setTextSize(14);
            }
            else {
                createrSprite.setImageResource(R.drawable.questionicon);
                name.setText("!!!!!!!");
                coinpersecond.setText("!/s");
                describe.setText("!!!!!!!");
                describe.setTextSize(30);
            }

        }
    }
    public void ClickMusic(){
        if(GameManager.activeSFX == true) {
            mediaPlayer = MediaPlayer.create(AlbumActivity.this, R.raw.click1);
            mediaPlayer.start();
        }
    }
}