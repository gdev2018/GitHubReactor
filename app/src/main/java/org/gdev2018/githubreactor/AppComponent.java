package org.gdev2018.githubreactor;

import org.gdev2018.githubreactor.data.UserComponent;
import org.gdev2018.githubreactor.data.api.GithubApiModule;
import org.gdev2018.githubreactor.data.api.UserModule;
import org.gdev2018.githubreactor.ui.activity.component.SplashActivityComponent;
import org.gdev2018.githubreactor.ui.activity.module.SplashActivityModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Miroslaw Stanek on 22.04.15.
 * 2017-11-30 Updated by gdev2018
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {

    SplashActivityComponent plus(SplashActivityModule module);

    UserComponent plus(UserModule userModule);

}