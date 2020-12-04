package com.example.alatelektronik;


import android.content.Context;

import com.example.alatelektronik.model.Alat;
import com.example.alatelektronik.model.Kipas_Angin;
import com.example.alatelektronik.model.Kulkas;
import com.example.alatelektronik.model.Tv;

import java.util.ArrayList;
import java.util.List;




public class DataProvider {
    private static List<Alat>alats= new ArrayList<>();

    private static List<Kipas_Angin> initDataKipas_Angin(Context ctx) {
        List<Kipas_Angin> kipas_angins = new ArrayList<>();
        kipas_angins.add(new Kipas_Angin("BEAT", "2008",
                " ", R.drawable.kipas_floor_fan));
        kipas_angins.add(new Kipas_Angin("ADV150", "2019",
                "", R.drawable.kipas_mini));
        kipas_angins.add(new Kipas_Angin("SCOOPY", "2010",
                " ", R.drawable.kipas_wall_fan));
        kipas_angins.add(new Kipas_Angin("PCX150", "2010",
                "", R.drawable.kipas_deskfan));
        kipas_angins.add(new Kipas_Angin("VARIO", "2006",
                "", R.drawable.kipas_ceiling_fan));
        return kipas_angins;
    }

    private static List<Kulkas> initDataKulkas(Context ctx) {
        List<Kulkas> kulkas = new ArrayList<>();
        kulkas.add(new Kulkas(" SUZUKI ADRESS F1", "Inggris",
                "", R.drawable.k_panasonic));
        kulkas.add(new Kulkas("SUZUKI ADRESS PLAYFULL", "Alaska,Siberia,Finlandia (daerah bersalju) ",
                "", R.drawable.k_aqua));
        kulkas.add(new Kulkas("SUZUKI BEUGMAN 200", "2002",
                "", R.drawable.k_sharp));
        kulkas.add(new Kulkas("SUZUKI BRUGMAN 650", "Rusia",
                "n", R.drawable.k_polytron));
        kulkas.add(new Kulkas("SUZUKI NEX", "2020",
                "", R.drawable.k_lg));
        return kulkas;
    }
    private static List<Tv> initDataTv(Context ctx) {
        List<Tv> tvs = new ArrayList<>();
        tvs.add(new Tv("Fino Classic", "2018",
                "", R.drawable.tv_lg));
        tvs.add(new Tv("Lexi", "2020 ",
                "", R.drawable.tv_polytron));
        tvs.add(new Tv("Mio", "2013",
                "", R.drawable.tv_sony));
        tvs.add(new Tv("NMAX 155", "2017",
                "", R.drawable.tv_led_samsung));
        tvs.add(new Tv("X-Ride", "2020",
                "", R.drawable.tv_aqua));
        return tvs;

    }

    private static void initAllAlats(Context ctx) {
        alats.addAll(initDataKipas_Angin(ctx));
        alats.addAll(initDataKulkas(ctx));
        alats.addAll(initDataTv(ctx));

    }

    public static List<Alat> getAllAlat(Context ctx) {
        if (alats.size() == 0) {
            initAllAlats(ctx);
        }
        return  alats;
    }

    public static List<Alat> getAlatsByTipe(Context ctx, String jenis) {
        List<Alat> alatsByType = new ArrayList<>();
        if (alats.size() == 0) {
            initAllAlats(ctx);
        }
        for (Alat h : alats) {
            if (h.getJenis().equals(jenis)) {
                alatsByType.add(h);
            }
        }
        return alatsByType;
    }

}

