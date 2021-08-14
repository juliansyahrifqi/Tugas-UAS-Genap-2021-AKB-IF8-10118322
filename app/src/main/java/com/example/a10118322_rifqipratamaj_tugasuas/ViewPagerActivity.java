// NIM : 10118322
// Nama: Rifqi Pratama Juliansyah
// Kelas: IF-8
// Tanggal Pengerjaan: 9 Agustus 2021

package com.example.a10118322_rifqipratamaj_tugasuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout layoutViewPagerIndicators;
    private Button buttonGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_slider);

        layoutViewPagerIndicators = findViewById(R.id.viewpager_indicators);
        buttonGetStarted = findViewById(R.id.button_get_started);

        setupViewPagerItems();

        ViewPager2 viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);

        setupViewPagerIndicators();
        setCurrentViewPagerIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentViewPagerIndicator(position);
            }
        });

        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem() + 1 < viewPagerAdapter.getItemCount()) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupViewPagerItems() {
        List<ViewPagerItem> viewPagerItems = new ArrayList<>();

        ViewPagerItem firstSlider = new ViewPagerItem();
        firstSlider.setTitle("SELAMAT DATANG");
        firstSlider.setDescription("Travelahka adalah aplikasi yang dibuat oleh 10118322 - Rifqi Pratama Juliansyah - IF8");
        firstSlider.setImage(R.drawable.ic_viewpager_1);

        ViewPagerItem secondSlider = new ViewPagerItem();
        secondSlider.setTitle("DAFTAR TEMPAT WISATA");
        secondSlider.setDescription("Di aplikasi ini, kalian bisa melihat daftar tempat wisata apa saja yang ada di kota Bandung");
        secondSlider.setImage(R.drawable.ic_viewpager_2);

        ViewPagerItem thirdSlider = new ViewPagerItem();
        thirdSlider.setTitle("LIHAT DI MAPS");
        thirdSlider.setDescription("Selain lewat daftar tempat, kalian juga bisa melihat daftar tempat wisata melalui Maps yang ada pada aplikasi ini");
        thirdSlider.setImage(R.drawable.ic_viewpager_3);

        viewPagerItems.add(firstSlider);
        viewPagerItems.add(secondSlider);
        viewPagerItems.add(thirdSlider);

        viewPagerAdapter = new ViewPagerAdapter(viewPagerItems);
    }

    private void setupViewPagerIndicators() {
        ImageView[] indicators = new ImageView[viewPagerAdapter.getItemCount()];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8, 0, 8, 0);

        for(int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.unselected
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutViewPagerIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentViewPagerIndicator(int index) {
        int childCount = layoutViewPagerIndicators.getChildCount();

        for(int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutViewPagerIndicators.getChildAt(i);

            if(i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.unselected)
                );
            }
        }

        if(index == viewPagerAdapter.getItemCount() - 1) {
            buttonGetStarted.setText("AYO LIBURAN");
        } else {
            buttonGetStarted.setText("Next");
        }
    }
}