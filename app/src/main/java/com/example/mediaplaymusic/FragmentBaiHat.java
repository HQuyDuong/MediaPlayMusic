package com.example.mediaplaymusic;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

public class FragmentBaiHat extends Fragment {
    ImageButton bntSort;
    private static final String KEY_POSITION = "position";

    public FragmentBaiHat() {
    }

    // Method static dạng singleton, cho phép tạo fragment mới, lấy tham số đầu vào để cài đặt màu sắc.
    public static FragmentBaiHat newInstance(int position) {
        FragmentBaiHat fragment = new FragmentBaiHat();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_baihat, container, false);

        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.fragmentBaiHat);

        /**
         * Số 1: Màu xanh.
         * Số 2: Màu đỏ.
         * Số 3: Màu vàng.
         */
        relativeLayout.setBackgroundResource(R.drawable.backgroundmedia);
        if(getArguments().getInt(KEY_POSITION) == 1){
         //   relativeLayout.setBackgroundResource(R.drawable.backgroundmedia);
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
        PopupMenu popupMenu = new PopupMenu(getContext(), bntSort);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item_song, popupMenu.getMenu());
        popupMenu.show();
    }
}
