package com.janedler.payresultframework.presenter;

import com.janedler.payresultframework.listener.PayResultModelListener;

/**
 * Created by janedler on 2017/6/19.
 */

public interface IPayResultPresenter<T> {

    void sendTask(PayResultModelListener<T> listener);

}
