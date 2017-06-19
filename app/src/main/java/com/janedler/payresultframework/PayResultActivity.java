package com.janedler.payresultframework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.janedler.payresultframework.adapter.IPayResultAdapter;
import com.janedler.payresultframework.adapter.impl.FixedPayResultAdapter;
import com.janedler.payresultframework.adapter.impl.FundPayResultAdapter;

public class PayResultActivity extends FragmentActivity{

    public static final String Fragment_Type = "Fragment_Type";
    public static final String FUND_TYPE = "FUND_TYPE";

    public static final String FIXED_TYPE = "FIXED_TYPE";

    private IPayResultAdapter mAdapter;

    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String type = bundle.getString(Fragment_Type);
        mAdapter = getAdapter(type);
        Fragment fragment = mAdapter.buildFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment.setArguments(getIntent().getExtras());
        fragmentManager.beginTransaction().add(R.id.content_layout, fragment, "fragment").commitAllowingStateLoss();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isFirst)mAdapter.sendTask();
        isFirst = false;
        mAdapter.refresh();
    }


    private IPayResultAdapter getAdapter(String type){

        if (type.equals(FUND_TYPE)){
            return new FundPayResultAdapter();
        }

        if (type.equals(FIXED_TYPE)){
            return new FixedPayResultAdapter();
        }

        return null;
    }

}
