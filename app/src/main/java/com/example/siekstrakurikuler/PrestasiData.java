package com.example.siekstrakurikuler;

import java.util.ArrayList;

public class PrestasiData {
    private static String [] prestasiName = {
            "Futsal",
            "Futsal Putri",
            "Basket",
            "Volly"
    };

    private static String [] prestasiDesk = {
            "Juara 1 Futsal se-Kabupaten Lumajan 2020",
            "Juara 2 Futsal Putri se-Kabupuaten Lumajang",
            "Juara 1 Basket se-Kabupaten Lumajan 2020",
            "Juara 2 Bola Volly se-Kabupaten Lumajan 2020"
    };
    private static int[] prestasiImg ={
            R.drawable.imgprestasi1,
            R.drawable.futsalputri,
            R.drawable.basket,
            R.drawable.volly
    };

    static ArrayList<Prestasi> getListData(){
        ArrayList<Prestasi> list = new ArrayList<>();
        for (int position = 0; position <prestasiName.length;position++){
            Prestasi prestasi = new Prestasi();
            prestasi.setName(prestasiName[position]);
            prestasi.setDesk(prestasiDesk[position]);
            prestasi.setPhoto(prestasiImg[position]);
            list.add(prestasi);
        }
        return  list;
    }
}
