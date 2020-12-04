package com.example.alatelektronik;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKipas,btnKulkas,btnTv;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKipas = findViewById(R.id.btn_buka_nama_kipas);
        btnKulkas = findViewById(R.id.btn_buka_nama_kulkas);
        btnTv = findViewById(R.id.btn_buka_nama_tv);
        btnKipas.setOnClickListener(view -> bukaGaleri("Kipas"));
        btnKulkas.setOnClickListener(view -> bukaGaleri("Kulkas"));
        btnTv.setOnClickListener(view -> bukaGaleri("Tv"));
    }

    private void bukaGaleri(String jenisAlat) {
        Log.d("MAIN","Buka activity kipas");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisAlat);
        startActivity(intent);
    }

}