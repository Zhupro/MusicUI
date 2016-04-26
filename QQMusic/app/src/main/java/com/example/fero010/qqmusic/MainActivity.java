package com.example.fero010.qqmusic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager musicViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> musicTabs = new ArrayList<Fragment>();
    TextView wordText;
    TextView imageText;
    TextView templateText;
    TextView twoCodeText;
    MusicWord musicWord;
    MusicImage musicImage;
    MusicTemplate musicTemplate;
    MusicTwoDimensionCode musicTwoCode;
    RelativeLayout firstView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
        musicViewPager.setOnPageChangeListener(this);
        musicViewPager.setAdapter(mAdapter);

    }

    private void initView() {
        musicViewPager = (ViewPager) findViewById(R.id.musicViewpager);
        firstView = (RelativeLayout) findViewById(R.id.firstView);
        //firstView.setBackground(new BitmapDrawable(FastBlur.doBlur()));

        wordText = (TextView) findViewById(R.id.iconWord);
        imageText = (TextView) findViewById(R.id.iconImage);
        templateText = (TextView) findViewById(R.id.iconTemplate);
        twoCodeText = (TextView) findViewById(R.id.iconTwoCode);

        wordText.setOnClickListener(this);
        imageText.setOnClickListener(this);
        templateText.setOnClickListener(this);
        twoCodeText.setOnClickListener(this);

        TextIcon.setForIcon(wordText, TextIcon.music);
        TextIcon.setForIcon(imageText, TextIcon.word);
        TextIcon.setForIcon(templateText, TextIcon.tag);
        TextIcon.setForIcon(twoCodeText, TextIcon.two);

        setChangeColor(0);

    }

    private void init() {

        musicWord = new MusicWord();
        musicImage = new MusicImage();
        musicTemplate = new MusicTemplate();
        musicTwoCode = new MusicTwoDimensionCode();

        musicTabs.add(musicWord);
        musicTabs.add(musicImage);
        musicTabs.add(musicTemplate);
        musicTabs.add(musicTwoCode);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return musicTabs.size();
            }

            @Override
            public Fragment getItem(int position) {
                return musicTabs.get(position);
            }
        };
    }

    public void onClick(View view) {
        clickTab(view);
    }


    private void clickTab(View v) {
        resetOtherTabs();

        switch (v.getId()) {
            case R.id.musicWordDetail:
                break;
            case R.id.iconWord:
                setChangeColor(0);
                break;
            case R.id.iconImage:
                setChangeColor(1);
                break;
            case R.id.iconTemplate:
                setChangeColor(2);
                break;
            case R.id.iconTwoCode:
                setChangeColor(3);
                break;
        }
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs() {

        wordText.setTextColor(0xffffffff);
        imageText.setTextColor(0xffffffff);
        templateText.setTextColor(0xffffffff);
        twoCodeText.setTextColor(0xffffffff);

    }


    private void setChangeTab(int i) {
        resetOtherTabs();
        switch (i) {
            case 0:
                wordText.setTextColor(0xff2baa6d);
                break;
            case 1:
                imageText.setTextColor(0xff2baa6d);

                break;
            case 2:
                templateText.setTextColor(0xff2baa6d);
                break;
            case 3:
                twoCodeText.setTextColor(0xff2baa6d);
                break;
        }
    }

    private void setChangeColor(int i) {

        switch (i) {
            case 0:
                wordText.setTextColor(0xff2baa6d);
                break;
            case 1:
                imageText.setTextColor(0xff2baa6d);
                break;
            case 2:
                templateText.setTextColor(0xff2baa6d);
                break;
            case 3:
                twoCodeText.setTextColor(0xff2baa6d);
                break;
        }
        musicViewPager.setCurrentItem(i, false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int current = musicViewPager.getCurrentItem();
        setChangeTab(current);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
