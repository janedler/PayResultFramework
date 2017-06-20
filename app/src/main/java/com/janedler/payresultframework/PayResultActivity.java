package com.janedler.payresultframework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.janedler.payresultframework.presenter.IPayResultPresenter;
import com.janedler.payresultframework.presenter.impl.FixedPayResultPresenter;
import com.janedler.payresultframework.presenter.impl.FundPayResultPresenter;

public class PayResultActivity extends FragmentActivity{

    public static final String FRAGMENT_TYPE = "Fragment_Type";
    public static final String FUND_TYPE = "FUND_TYPE";

    public static final String FIXED_TYPE = "FIXED_TYPE";

    private IPayResultPresenter mPresenter;

    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String type = bundle.getString(FRAGMENT_TYPE);
        mPresenter = getPresenter(type);
        Fragment fragment = mPresenter.buildFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment.setArguments(getIntent().getExtras());
        fragmentManager.beginTransaction().add(R.id.content_layout, fragment, "fragment").commitAllowingStateLoss();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isFirst)mPresenter.sendTask();
        isFirst = false;
    }


    private IPayResultPresenter getPresenter(String type){

        if (type.equals(FUND_TYPE)){
            return new FundPayResultPresenter();
        }

        if (type.equals(FIXED_TYPE)){
            return new FixedPayResultPresenter();
        }

        return null;
    }

}
