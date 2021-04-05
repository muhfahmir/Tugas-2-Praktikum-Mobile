package com.fti.convertnilai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etNim, etNilai;
    ProgressBar progressBar;
    Button btnSubmit;

    private String KEY_NAME = "NAMA";
    private String KEY_NIM = "NIM";
    private String KEY_NILAI = "NILAI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressSubmit);
        etNama = findViewById(R.id.etNama);
        etNilai = findViewById(R.id.etNilai);
        etNim = findViewById(R.id.etNim);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String sNama = etNama.getText().toString();
                    String sNim = etNim.getText().toString();
                    String sNilai = etNilai.getText().toString();

                    Double dNilai = Double.parseDouble(sNilai);
                    if(dNilai < 4.00){
                        btnSubmit.setText("Please Wait ...");
                        progressBar.setVisibility(v.VISIBLE);
                        if(dNilai> 3.66 && dNilai <= 4.00){
                            sNilai = "A";
                        }else if(dNilai> 3.33 && dNilai <= 3.66){
                            sNilai = "A-";
                        }else if(dNilai> 3.00 && dNilai <= 3.33){
                            sNilai = "B+";
                        }else if(dNilai> 2.66 && dNilai <= 3.00){
                            sNilai = "B";
                        }else if(dNilai> 2.33 && dNilai <= 2.66){
                            sNilai = "B-";
                        }else if(dNilai> 2.00 && dNilai <= 2.33){
                            sNilai = "C+";
                        }else if(dNilai> 1.66 && dNilai <= 2.00){
                            sNilai = "C";
                        }else if(dNilai> 1.33 && dNilai <= 1.66){
                            sNilai = "C-";
                        }else if(dNilai> 1.00 && dNilai <= 1.33){
                            sNilai = "D+";
                        }else{
                            sNilai = "D";
                        }
                        String fNilai= sNilai;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(MainActivity.this, ConverNilai.class);
                                i.putExtra(KEY_NAME,sNama);
                                i.putExtra(KEY_NIM,sNim);
                                i.putExtra(KEY_NILAI,fNilai);
                                startActivity(i);
                            }
                        },3000);

                    }else{
                        Toast.makeText(getApplicationContext(), "Mohon masukkan nilai <= 4.00", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}