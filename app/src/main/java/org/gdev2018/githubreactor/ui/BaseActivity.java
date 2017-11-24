package org.gdev2018.githubreactor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 *   Updated by gdev2018 on 2017-11-22
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();
}