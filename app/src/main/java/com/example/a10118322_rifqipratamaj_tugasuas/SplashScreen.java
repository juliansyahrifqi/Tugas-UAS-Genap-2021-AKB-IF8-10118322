// NIM : 10118322
// Nama: Rifqi Pratama Juliansyah
// Kelas: IF-8
// Tanggal Pengerjaan: 9 Agustus 2021

package com.example.a10118322_rifqipratamaj_tugasuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                finish();
            }
        }, 3000);
    }
}