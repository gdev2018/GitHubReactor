package org.gdev2018.githubreactor.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 * 2017-11-24 Updated by gdev2018
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}