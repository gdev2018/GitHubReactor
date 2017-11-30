package org.gdev2018.githubreactor.utils;

import android.text.TextUtils;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 * 2017-11-30 Updated by gdev2018
 */
public class Validator {

    public Validator() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
