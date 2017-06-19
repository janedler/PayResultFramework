package com.janedler.payresultframework.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by janedler on 2017/6/19.
 */

public interface IPayResultAdapter {

    Fragment buildFragment();

    void sendTask();

    void refresh();


}
