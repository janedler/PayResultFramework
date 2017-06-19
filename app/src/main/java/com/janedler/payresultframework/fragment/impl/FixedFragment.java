package com.janedler.payresultframework.fragment.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.janedler.payresultframework.R;
import com.janedler.payresultframework.fragment.IPayResultFragment;

public class FixedFragment extends Fragment implements IPayResultFragment<Integer> {

    private View mView;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fixed, null);
        initView();
        return mView;
    }

    private void initView(){
        mTextView = (TextView) mView.findViewById(R.id.text_fixed);
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    @Override
    public void onSendTaskLoading() {
        Log.e("TAG","onSendTaskLoading");
    }

    @Override
    public void onPayResult(Integer integer) {
        mTextView.setText(String.valueOf(integer));
    }

    @Override
    public void onSendTaskError() {
        Log.e("TAG","onSendTaskError");
    }

    @Override
    public void onSendTaskFinish() {
        Log.e("TAG","onSendTaskFinish");
    }
}
