package com.janedler.payresultframework.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by janedler on 2017/6/19.
 */

public interface IPayResultFragment<T>{

    Fragment getFragment();

    void onSendTaskLoading();

    void onPayResult(T t);

    void onSendTaskError();

    void onSendTaskFinish();

}
