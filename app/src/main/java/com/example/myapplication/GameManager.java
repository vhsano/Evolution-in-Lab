package com.example.myapplication;



import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameManager {
    public static int list1size,list2size,list3size,list6size,list7size,list8size;
    public static List<CharacterSprite> listChar1 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar2 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar3 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar4 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar5 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar6 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar7 = new ArrayList<CharacterSprite>();
    public static List<CharacterSprite> listChar8 = new ArrayList<CharacterSprite>();
    public static long coin = 500, second, coinAfk ;
    public static long timeAfk = 10800;
    public static int environment = 1;
    public static int char1Const = 100,char2Const = 200,char3Const = 400,char4Const,char5Const,char6Const = 800,char7Const = 1600,char8Const = 3200;
    public static boolean rewardAchi1 ,rewardAchi2 , rewardAchi3 , rewardAchi4, rewardAchi5, rewardAchi6, rewardAchi7, rewardAchi8, rewardAchi9;
    public static boolean unclockAchi1 ,unclockAchi2 , unclockAchi3 , unclockAchi4, unclockAchi5, unclockAchi6, unclockAchi7, unclockAchi8, unclockAchi9;
    public static boolean unclockChar1, unclockChar2, unclockChar3, unclockChar6, unclockChar7, unclockChar8;
    public static boolean showAfkGamereward;
    public static boolean activeMusic = true, activeSFX = true;

    public static long coinpersecond()
    {
        int coinpersecond = 0;
        for (CharacterSprite item : listChar1
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar2
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar3
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar4
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar5
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar6
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar7
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        for (CharacterSprite item : listChar8
        ) {
            coinpersecond = coinpersecond + item.coin_s;
        }
        long finalCoinpersecond = coinpersecond;
        return finalCoinpersecond;
    }

    public static void coinUpdate() {

        coin = coinpersecond() + coin;
    }

    public static void charCombine(){
        int list1Count = listChar1.size();
        int list2Count = listChar2.size();
        if(list1Count >= 2)
        {
            for(int i = list1Count -1 ; i > list1Count - 3; i--)
            {
                CharacterSprite charUpdate = listChar1.get(i);
                charUpdate.combine = true;
                listChar1.set(i,charUpdate);
            }
        }
        if(list2Count >= 2)
        {
            for(int i = list2Count -1 ; i > list2Count - 3; i--)
            {
                CharacterSprite charUpdate = listChar2.get(i);
                charUpdate.combine = true;
                listChar2.set(i,charUpdate);
            }
        }

    }

    public static boolean removeCharCombine(List<CharacterSprite> list){
        int listCount = list.size();
        if(listCount >= 2)
        {
            for(int i = listCount -1 ; i > listCount - 3; i--)
            {
                list.remove(i);
            }
            return true;
        }
        return false;
    }
    public static void loadData(BufferedReader br) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            coin = Long.parseLong(br.readLine());
            list1size = Integer.parseInt(br.readLine());
            list2size = Integer.parseInt(br.readLine());
            list3size = Integer.parseInt(br.readLine());
            list6size = Integer.parseInt(br.readLine());
            list7size = Integer.parseInt(br.readLine());
            list8size = Integer.parseInt(br.readLine());
            char1Const = Integer.parseInt(br.readLine());
            char2Const = Integer.parseInt(br.readLine());
            char3Const = Integer.parseInt(br.readLine());
            char6Const = Integer.parseInt(br.readLine());
            char7Const = Integer.parseInt(br.readLine());
            char8Const = Integer.parseInt(br.readLine());
            unclockChar1 = Boolean.parseBoolean(br.readLine());
            unclockChar2 = Boolean.parseBoolean(br.readLine());
            unclockChar3 = Boolean.parseBoolean(br.readLine());
            unclockChar6 = Boolean.parseBoolean(br.readLine());
            unclockChar7 = Boolean.parseBoolean(br.readLine());
            unclockChar8 = Boolean.parseBoolean(br.readLine());
            unclockAchi1 = Boolean.parseBoolean(br.readLine());
            unclockAchi2 = Boolean.parseBoolean(br.readLine());
            unclockAchi3 = Boolean.parseBoolean(br.readLine());
            unclockAchi4 = Boolean.parseBoolean(br.readLine());
            unclockAchi5 = Boolean.parseBoolean(br.readLine());
            unclockAchi6 = Boolean.parseBoolean(br.readLine());
            rewardAchi1 = Boolean.parseBoolean(br.readLine());
            rewardAchi2 = Boolean.parseBoolean(br.readLine());
            rewardAchi3 = Boolean.parseBoolean(br.readLine());
            rewardAchi4 = Boolean.parseBoolean(br.readLine());
            rewardAchi5 = Boolean.parseBoolean(br.readLine());
            rewardAchi6 = Boolean.parseBoolean(br.readLine());

            Date dateEnd = dateFormat.parse(br.readLine());
            Date dateNow = new Date();
            second = (dateNow.getTime() - dateEnd.getTime())/1000;
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
