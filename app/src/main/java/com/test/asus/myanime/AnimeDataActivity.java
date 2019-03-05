package com.test.asus.myanime;

import java.util.ArrayList;
public class AnimeDataActivity {
    private static String[] title = new String[]{"Uzumaki Naruto","Mongkey D. Luffy","Kaneki Ken","Saitama"};

    private static String[] detail = new String[]{
            "Uzumaki Naruto, adalah pahlawan perang dunia shinobi saat berhadapan dengan Uchiha Madara.",
            "Mongkey D. Luffy, adalah seorang bajak laut yang bertujuan menjadi Raja Bajak Laut.",

            "Kaneki Ken, adalah seorang manusia yang menjadi ghoul.",
            "Saitama, adalah seorang manusia yang mempunyai kekuatan yang luar biasa."
    };

    private static int[] thumbnail = new int[]{R.drawable.narutoo,R.drawable.luuffy,R.drawable.kaaneki,R.drawable.saitamaa};

    public static ArrayList<AnimeModelActivity> getListData(){
        AnimeModelActivity Model = null;
        ArrayList<AnimeModelActivity> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            Model = new AnimeModelActivity();
            Model.setThumbnail(thumbnail[i]);
            Model.setTitle(title[i]);
            Model.setDetail(detail[i]);
            list.add(Model);
        }
        return list;
    }









}
