package com.janedler.payresultframework.presenter.impl;

import android.support.v4.app.Fragment;

import com.janedler.payresultframework.fragment.IPayResultFragment;
import com.janedler.payresultframework.fragment.impl.FundPayResultFragment;
import com.janedler.payresultframework.listener.PayResultModelListener;
import com.janedler.payresultframework.model.IPayResultModel;
import com.janedler.payresultframework.model.impl.FundPayResultModel;
import com.janedler.payresultframework.presenter.IPayResultPresenter;

/**
 * Created by janedler on 2017/6/19.
 */

public class FundPayResultPresenter implements IPayResultPresenter {


    private IPayResultModel<String> mModel;
    private IPayResultFragment<String> mFragment;

    @Override
    public void sendTask() {
        mModel = new FundPayResultModel();
        mModel.sendPayResultModelTask(new PayResultModelListener<String>() {
            @Override
            public void onStart() {
                mFragment.onSendTaskLoading();
            }

            @Override
            public void onPayResult(String result) {
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
        mFragment = new FundPayResultFragment();
        return mFragment.getFragment();
    }

    @Override
    public void refresh() {

    }

}
