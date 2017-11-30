package org.gdev2018.githubreactor;

import android.app.Application;
import android.content.Context;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import org.gdev2018.githubreactor.data.UserComponent;
import org.gdev2018.githubreactor.data.api.UserModule;
import org.gdev2018.githubreactor.data.model.User;

import timber.log.Timber;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 * 2017-11-30 Updated by gdev2018
 */
    public class GithubReactorApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;

    public static GithubReactorApplication get(Context context) {
        return (GithubReactorApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            AndroidDevMetrics.initWith(this);
        }

        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

}