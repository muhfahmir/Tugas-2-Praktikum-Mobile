package com.fti.convertnilai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ConverNilai extends AppCompatActivity {
    TextView tvNama, tvNim, tvNilai;
    private String nama ;
    private String KEY_NAME = "NAMA";
    private String nilai ;
    private String KEY_NILAI = "NILAI";
    private String nim ;
    private String KEY_NIM = "NIM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conver_nilai);

        tvNama = findViewById(R.id.tvNama);
        tvNim = findViewById(R.id.tvNim);
        tvNilai = findViewById(R.id.tvNilai);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        nim = extras.getString(KEY_NIM);
        nilai = extras.getString(KEY_NILAI);
        tvNama.setText(nama);
        tvNim.setText(nim);
        tvNilai.setText(nilai);
    }
}