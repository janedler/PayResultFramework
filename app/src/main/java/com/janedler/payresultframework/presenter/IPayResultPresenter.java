package com.janedler.payresultframework.presenter;

import android.support.v4.app.Fragment;

import com.janedler.payresultframework.listener.PayResultModelListener;

/**
 * Created by janedler on 2017/6/19.
 */

public interface IPayResultPresenter<T> {

    void sendTask();

    Fragment buildFragment();

    void refresh();

}
