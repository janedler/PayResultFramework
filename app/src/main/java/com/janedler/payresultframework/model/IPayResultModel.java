package com.janedler.payresultframework.model;

import com.janedler.payresultframework.listener.PayResultModelListener;

/**
 * 数据层
 * Created by janedler on 2017/6/19.
 */

public interface IPayResultModel<T> {

    void sendPayResultModelTask(PayResultModelListener<T> listener);

}
