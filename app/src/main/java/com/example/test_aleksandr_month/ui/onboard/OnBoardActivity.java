package com.example.test_aleksandr_month.ui.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.test_aleksandr_month.App;
import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.ui.main.MainActivity;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class OnBoardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SpringDotsIndicator dotsIndicator;
    private Button board_button;
    Fragment fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        fragment = new BoardFragment();

        initViews();
    }

    private void initViews () {
        toolbar = findViewById(R.id.toolbarTransparent);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewPagerOnBoard);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 0));
        viewPager.setCurrentItem(0);
        dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(viewPager);
        board_button = findViewById(R.id.board_button);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, OnBoardActivity.class));
    }

}
