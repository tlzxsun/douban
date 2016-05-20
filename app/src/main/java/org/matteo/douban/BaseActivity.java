package org.matteo.douban;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by matteo on 2015/6/11.
 */
public abstract class BaseActivity extends AppCompatActivity{

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayoutResID() != 0) {
            setContentView(getLayoutResID());
            ButterKnife.bind(this);
        }
        initComponent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        dismissProgressDialog();
    }

    @StringRes
    protected void showProgressDialog(int resId) {
        showProgressDialog(getString(resId));
    }

    protected void showProgressDialog(String message) {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    protected void dismissProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected abstract int getLayoutResID();

    protected abstract void initComponent();

}
