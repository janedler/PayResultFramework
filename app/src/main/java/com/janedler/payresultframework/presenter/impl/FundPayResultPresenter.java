package com.janedler.payresultframework.presenter.impl;

import com.janedler.payresultframework.listener.PayResultModelListener;
import com.janedler.payresultframework.model.IPayResultModel;
import com.janedler.payresultframework.model.impl.FundPayResultModel;
import com.janedler.payresultframework.presenter.IPayResultPresenter;

/**
 * Created by janedler on 2017/6/19.
 */

public class FundPayResultPresenter<T> implements IPayResultPresenter<T> {


    private IPayResultModel<T> mModel;

    @Override
    public void sendTask(PayResultModelListener<T> listener) {
        mModel = new FundPayResultModel();
        mModel.sendPayResultModelTask(listener);
    }

}