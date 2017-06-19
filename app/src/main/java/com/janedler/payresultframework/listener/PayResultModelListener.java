package com.janedler.payresultframework.listener;

/**
 * Created by janedler on 2017/6/19.
 */

public interface PayResultModelListener<T> {

    void onStart();

    void onPayResult(T t);

    void onError();

    void onFinish();

}
