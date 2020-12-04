package com.example.alatelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alatelektronik.model.Alat;

import java.util.List;

public class GaleriActivity extends AppCompatActivity {

    List<Alat> alats;
    int indeksTampil = 0;
    String jenisAlat;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txHarga,txDeskripsi,txJudul,txNama;
    ImageView ivFotoAlat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        jenisAlat = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        alats = DataProvider.getAlatsByTipe(this,jenisAlat);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> alatPertama());
        btnTerakhir.setOnClickListener(view -> alatTerakhir());
        btnSebelumnya.setOnClickListener(view -> alatSebelumnya());
        btnBerikutnya.setOnClickListener(view -> alatBerikutnya());

        txNama = findViewById(R.id.txNama);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoAlat = findViewById(R.id.gambarAlat);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam jenis "+ jenisAlat);
    }


    private void tampilkanProfil() {
        Alat m = alats.get(indeksTampil);
        Log.d("KULKAS","Menampilkan kulkas "+m.getNama());
        txHarga.setText(m.getHarga());
        txNama.setText(m.getNama());
        txDeskripsi.setText(m.getDeskripsi());
        ivFotoAlat.setImageDrawable(this.getDrawable(m.getDrawableRes()));
    }

    private void alatPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void alatTerakhir() {
        int posAkhir = alats.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void alatBerikutnya() {
        if (indeksTampil == alats.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void alatSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}

