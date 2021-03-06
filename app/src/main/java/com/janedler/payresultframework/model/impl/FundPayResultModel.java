package com.janedler.payresultframework.model.impl;

import com.janedler.payresultframework.listener.PayResultModelListener;
import com.janedler.payresultframework.model.IPayResultModel;

/**
 * Created by janedler on 2017/6/19.
 */

public class FundPayResultModel<T> implements IPayResultModel<T> {

    @Override
    public void sendPayResultModelTask(PayResultModelListener<T> listener) {

        listener.onPayResult((T) "Come from fund");

    }
}
