package com.zgf.modelapplication.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zgf.modelapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BKTestFragment extends Fragment {
    @BindView(R.id.tv_fragment)
    public TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bktest, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.tv_fragment)
    public void onClickTextView() {
        textView.setText("=======");
    }

}
