package com.muazduran.cepteoneri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActivityIntro extends AppCompatActivity {

    private ViewPager screenPager;
    private IntroViewPageAdapter introViewPageAdapter;
    private TabLayout tabIndicator;
    private Button btnGetStart;
    Animation animFadeIn;
    Animation animFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(restoredPrefData()){
            Intent main = new Intent(ActivityIntro.this, ActivityMain.class);
            startActivity(main);
            finish();
        }

        setContentView(R.layout.activity_intro);

        Objects.requireNonNull(getSupportActionBar()).hide();

        //Indicator initialization
        tabIndicator = findViewById(R.id.introIndicator);

        //Fill list screen
        final List<IntroScreenItem> mList = new ArrayList<>();
        mList.add(new IntroScreenItem("Find your best Phone","There are tons of smartphone on the market. You can find which one is suits for you",R.drawable.img1));
        mList.add(new IntroScreenItem("Enter your necessity","With just easy 3 steps. Pick your need",R.drawable.img2));
        mList.add(new IntroScreenItem("Voila! Chose one of them from Golden to Bronze","After that our smart comparing system will find best phone for you! Also you can compare with other best two",R.drawable.img3));

        //Viewpager initialization
        screenPager = findViewById(R.id.screenViewpager);
        introViewPageAdapter = new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(introViewPageAdapter);

        // Animations
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out);

        //Tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        btnGetStart = findViewById(R.id.buttonBasla);
        screenPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                if(screenPager.getCurrentItem() == mList.size()-1){
                    tabIndicator.setVisibility(View.INVISIBLE);
                    btnGetStart.setVisibility(View.VISIBLE);
                    btnGetStart.startAnimation(animFadeIn);
                }
                else{
                    btnGetStart.setVisibility(View.INVISIBLE);
                    tabIndicator.setVisibility(View.VISIBLE);
                }
            }
        });

        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(ActivityIntro.this, ActivityMain.class);
                ActivityIntro.this.startActivity(main);
                ActivityIntro.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                ActivityIntro.this.savePrefsData();
                ActivityIntro.this.finish();
            }
        });
    }

    private boolean restoredPrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        Boolean isIntroOpenedB4 = pref.getBoolean("isOpenedB4",false);
        return  isIntroOpenedB4;
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isOpenedB4",true);
        editor.commit();
    }

}
