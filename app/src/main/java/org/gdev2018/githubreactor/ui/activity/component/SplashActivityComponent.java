package org.gdev2018.githubreactor.ui.activity.component;

import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.SplashActivity;
import org.gdev2018.githubreactor.ui.activity.module.SplashActivityModule;

import dagger.Subcomponent;


/**
 * Created by Miroslaw Stanek on 23.04.15.
 * 2017-11-30 Updated by gdev2018
 */
@ActivityScope
@Subcomponent(
        modules = SplashActivityModule.class
)
public interface SplashActivityComponent {

    SplashActivity inject(SplashActivity splashActivity);

}