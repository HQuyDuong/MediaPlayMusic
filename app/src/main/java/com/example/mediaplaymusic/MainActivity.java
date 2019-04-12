package com.example.mediaplaymusic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_song, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public static class PlaceholderFragment extends Fragment {
        ImageButton bntSort;
        Context context;
        private static final String KEY_COLOR = "key_color";

        public PlaceholderFragment() {
        }

        // Method static dạng singleton, cho phép tạo fragment mới, lấy tham số đầu vào để cài đặt màu sắc.
        public static PlaceholderFragment newInstance(int color) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(KEY_COLOR, color);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment, container, false);
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl_fragment);

            /**
             * Số 1: Màu xanh.
             * Số 2: Màu đỏ.
             * Số 3: Màu vàng.
             */
            switch (getArguments().getInt(KEY_COLOR)) {
                case 1:
                    relativeLayout.setBackgroundResource(R.drawable.backgroundmedia);
                    break;
                case 2:
                    relativeLayout.setBackgroundColor(Color.BLUE);
                    break;
                case 3:
                    relativeLayout.setBackgroundResource(R.drawable.backgroundmedia);
                    break;
                default:
                    relativeLayout.setBackgroundResource(R.drawable.backgroundmedia);
                    break;
            }

            bntSort = rootView.findViewById(R.id.buttonItemSong);
            bntSort.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMenu();
                }
            });
            return rootView;
        }
        private void showMenu() {
            PopupMenu popupMenu = new PopupMenu(context, bntSort);
            popupMenu.getMenuInflater().inflate(R.menu.menu_item_song, popupMenu.getMenu());
            popupMenu.show();
        }


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // position + 1 vì position bắt đầu từ số 0.
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Bài Hát";
                case 1:
                    return "Album";
                case 2:
                    return "Nghệ Sĩ";
                case 3:
                    return "Danh Sách Nhạc";
                case 4:
                    return "Thư Mục";
            }
            return null;
        }
    }
}
