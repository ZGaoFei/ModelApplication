package com.zgf.modelapplication.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zgf.modelapplication.R;
import com.zgf.modelapplication.ui.adapter.BKListViewAdapter;
import com.zgf.modelapplication.ui.fragment.BKTestFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * 测试 ButterKnife
 * 在设置Button时，不可以是在为 private 或者 static 类型
 */
public class ButterKnifeTestActivity extends FragmentActivity {

    @BindView(R.id.bt_bk_top)
    Button btBkTop;
    @BindView(R.id.tv_bk_top)
    TextView tvBkTop;
    @BindView(R.id.ll_fragment)
    LinearLayout linearLayout;
    @BindView(R.id.lv_bk_test)
    ListView lv;

    @BindString(R.string.test_bk_text)
    String bkText;

    private List<String> listStr;
    private BKListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_test);
        ButterKnife.bind(this);

        setFragment();
        setLv();
    }

    @OnClick(R.id.bt_bk_top)
    public void onClickTopBt(){
        tvBkTop.setText(bkText);
    }

    private void setFragment() {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.ll_fragment, new BKTestFragment())
                .commit();
    }

    private void setLv() {
        listStr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listStr.add("item: " + i);
        }

        adapter = new BKListViewAdapter(listStr, this);
        lv.setAdapter(adapter);

    }

    /*@OnItemClick(R.id.lv_bk_test)
    public void onItemClick(int position) {
        Log.e("====item====", "=======" + listStr.get(position));
    }*/

    /*@OnItemLongClick(R.id.lv_bk_test)
    public boolean onItemLongClick(int position) {
        Log.e("===item=long=====", "=======" + listStr.get(position));
        return true;
    }*/

    @OnItemSelected(R.id.lv_bk_test)
    public void onItemSelected(int position) {
        Log.e("===item=long=====", "=======" + listStr.get(position));
    }

}
