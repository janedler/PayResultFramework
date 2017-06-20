package com.janedler.payresultframework.presenter.impl;

import android.support.v4.app.Fragment;

import com.janedler.payresultframework.fragment.IPayResultFragment;
import com.janedler.payresultframework.fragment.impl.FixedFragment;
import com.janedler.payresultframework.fragment.impl.FundPayResultFragment;
import com.janedler.payresultframework.listener.PayResultModelListener;
import com.janedler.payresultframework.model.IPayResultModel;
import com.janedler.payresultframework.model.impl.FixedPayResultModel;
import com.janedler.payresultframework.model.impl.FundPayResultModel;
import com.janedler.payresultframework.presenter.IPayResultPresenter;

/**
 * Created by janedler on 2017/6/19.
 */

public class FixedPayResultPresenter implements IPayResultPresenter {


    private IPayResultModel<Integer> mModel;
    private IPayResultFragment<Integer> mFragment;

    @Override
    public void sendTask() {
        mModel = new FundPayResultModel();
        mModel.sendPayResultModelTask(new PayResultModelListener<Integer>() {
            @Override
            public void onStart() {
                mFragment.onSendTaskLoading();
            }

            @Override
            public void onPayResult(Integer result) {
                mFragment.onPayResult(result);
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
    public Fragment buildFragment() {
        mFragment = new FixedFragment();
        return mFragment.getFragment();
    }

    @Override
    public void refresh() {

    }

}
