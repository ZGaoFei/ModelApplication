package com.zgf.modelapplication.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.zgf.modelapplication.R;
import com.zgf.modelapplication.ui.adapter.MyWheelViewAdapter;
import com.zgf.modelapplication.utils.DensityUtils;
import com.zgf.modelapplication.weight.wheelview.WheelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickViewActivity extends AppCompatActivity {
    private Button btPickView;
    private Button btPickView2;
    private String selected;
    private PopupWindow popupWindow;

    com.wx.wheelview.widget.WheelView view;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_view);
        btPickView = (Button) findViewById(R.id.bt_pick_view);
        btPickView2 = (Button) findViewById(R.id.bt_pick_view2);

        btPickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showPopupWindow();
                showDialog();
            }
        });

        btPickView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showPopWindow();
//                showDialog();
                showD();
            }
        });
    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.pwp_pick_view, null);
        Button button1 = (Button) contentView.findViewById(R.id.bt_no);
        Button button2 = (Button) contentView.findViewById(R.id.bt_yes);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(PickViewActivity.this, selected,
                        Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        WheelView view = (WheelView) contentView.findViewById(R.id.wv);
        initWheelview(view);

        popupWindow = new PopupWindow(contentView,
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_drawable));

        popupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void initWheelview(WheelView view) {
        String[] str = new String[]{"一个", "二个", "山歌"};
        selected = str[0];
        view.setOffset(1);
        view.setItems(Arrays.asList(str));
        view.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                selected = item;
            }
        });

    }

    // wheel view

    private void showPopWindow() {
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.pwp_wheel_view, null);
        Button button1 = (Button) contentView.findViewById(R.id.bt_no);
        Button button2 = (Button) contentView.findViewById(R.id.bt_yes);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String string = view.getSelectionItem().toString();
                Toast.makeText(PickViewActivity.this, string,
                        Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        view = (com.wx.wheelview.widget.WheelView) contentView.findViewById(R.id.wheel_view);
        initView(view);

        popupWindow = new PopupWindow(contentView,
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_drawable));

        popupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void initView(com.wx.wheelview.widget.WheelView view) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("item" + i);
        }

        view.setWheelAdapter(new MyWheelViewAdapter(this));
        view.setWheelData(list);
        view.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);

        com.wx.wheelview.widget.WheelView.WheelViewStyle style = new com.wx.wheelview.widget.WheelView.WheelViewStyle();
        style.selectedTextColor = Color.parseColor("#ee750c");
        style.textColor = Color.GRAY;
        style.selectedTextSize = 16;
        style.holoBorderColor = Color.GRAY;
        style.textAlpha = 0.2f;
        view.setStyle(style);
    }

    private void showDialog() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);//此处可以设置dialog显示的位置
        dialog.show();
        window.setContentView(R.layout.pwp_wheel_view);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view = (com.wx.wheelview.widget.WheelView) window.findViewById(R.id.wheel_view);
        initView(view);
    }

    private void showD() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setBackgroundDrawable(new BitmapDrawable());
        dialog.show();
        window.setContentView(R.layout.pwp_wheel_view);
        window.setLayout((int) (DensityUtils.getWindowWidth(this)), LinearLayout.LayoutParams.WRAP_CONTENT);
        view = (com.wx.wheelview.widget.WheelView) window.findViewById(R.id.wheel_view);
        initView(view);
    }
}
