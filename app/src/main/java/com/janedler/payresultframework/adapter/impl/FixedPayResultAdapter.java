package com.janedler.payresultframework.adapter.impl;

import android.support.v4.app.Fragment;

import com.janedler.payresultframework.adapter.IPayResultAdapter;
import com.janedler.payresultframework.fragment.IPayResultFragment;
import com.janedler.payresultframework.fragment.impl.FixedFragment;
import com.janedler.payresultframework.listener.PayResultModelListener;
import com.janedler.payresultframework.presenter.IPayResultPresenter;
import com.janedler.payresultframework.presenter.impl.FixedPayResultPresenter;
import com.janedler.payresultframework.presenter.impl.FundPayResultPresenter;

/**
 * Created by janedler on 2017/6/19.
 */

public class FixedPayResultAdapter implements IPayResultAdapter {

    private IPayResultFragment<Integer> mFragment;
    private IPayResultPresenter mPresenter;

    @Override
    public Fragment buildFragment() {
        mFragment = new FixedFragment();
        return mFragment.getFragment();
    }

    @Override
    public void sendTask() {
        mPresenter = new FixedPayResultPresenter();
        mPresenter.sendTask(new PayResultModelListener<Integer>() {
            @Override
            public void onStart() {
                mFragment.onSendTaskLoading();
            }

            @Override
            public void onPayResult(Integer o) {
                mFragment.onPayResult(o);
            }

            @Override
            public void onError() {
                mFragment.onSendTaskError();
            }

            @Override
            public void onFinish() {
                mFragment.onSendTaskFinish();
            }
        });
    }

    @Override
    public void refresh() {
//        mFragment
    }

}
