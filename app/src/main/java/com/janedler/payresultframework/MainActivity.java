package com.janedler.payresultframework;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends FragmentActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_fund).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(PayResultActivity.Fragment_Type,PayResultActivity.FUND_TYPE);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,PayResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_fixed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(PayResultActivity.Fragment_Type,PayResultActivity.FIXED_TYPE);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,PayResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }




}
