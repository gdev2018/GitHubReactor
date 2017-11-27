package org.gdev2018.githubreactor.ui.activity.module;

import org.gdev2018.githubreactor.HeavyLibraryWrapper;
import org.gdev2018.githubreactor.data.api.UserManager;
import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.SplashActivity;
import org.gdev2018.githubreactor.ui.activity.presenter.SplashActivityPresenter;
import org.gdev2018.githubreactor.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class SplashActivityModule {
    private SplashActivity splashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter
    provideSplashActivityPresenter(Validator validator, UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        return new SplashActivityPresenter(splashActivity, validator, userManager, heavyLibraryWrapper);
    }
}