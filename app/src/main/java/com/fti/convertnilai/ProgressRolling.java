package com.fti.convertnilai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressRolling extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView persentase;
    private int Value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_rolling);
        progressBar = findViewById(R.id.progress);
//        persentase = findViewById(R.id.persentase);
//        progressBar.setProgress(0);
//
//        final Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                // Menampung semua data yang ingin diproses oleh thread
//                persentase.setText(String.valueOf(Value)+"%");
//                if(Value == progressBar.getMax()){
//                    Toast.makeText(getApplicationContext(), "Progress Completed", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(ProgressRolling.this, MainActivity.class));
//                    finish();
//                }
//                Value++;
//            }
//        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000); // Waktu Pnding 3 Detik
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(ProgressRolling.this, MainActivity.class));
                    finish();
                }
            }
        });
        thread.start();
    }
}