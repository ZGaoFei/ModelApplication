package com.zgf.modelapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zgf.modelapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zgf on 2016/12/1.
 */

public class BKListViewAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public BKListViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_view, null);
            vh = new ViewHolder(view);

            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.textView.setText(list.get(i));

        return view;
    }

    static class ViewHolder{
        @BindView(R.id.tv_lv)
        TextView textView;
        @BindView(R.id.bt_lv)
        Button button;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        /**
         * ok
         *
         * 在listview中添加按钮
         * 点击事件写在viewhloder类的外面点击没有效果
         */
        /*@OnClick(R.id.bt_lv)
        void btOnClick() {
            Log.e("======", "=======");
        }*/
    }
}
