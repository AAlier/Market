package com.example.market.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.market.R;
import com.example.market.ui.category.SampleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        setupPager();
    }

    private void setupPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(SampleFragment.getInstance("test1.json"));
        adapter.add(SampleFragment.getInstance("test2.json"));
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageListener);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.itemMain:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.itemGuns:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(false);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
