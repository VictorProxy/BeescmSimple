package com.weex.sample;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import cn.beescm.commonbusiness.base.BaseActivity;

public class WXFragmentActivity extends BaseActivity {

  private static final String EXAMPLE_URL="http://dotwe.org/raw/dist/b22f2a3b087c7fd02471c76e066f0f23.bundle.js";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WeexFragment weexFragment = WeexFragment.newInstance(EXAMPLE_URL);
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.add(R.id.content_fragment, weexFragment);
    transaction.commit();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_fragment;
  }
}
