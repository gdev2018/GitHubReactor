package org.gdev2018.githubreactor.data.api;

import org.gdev2018.githubreactor.data.UserScope;
import org.gdev2018.githubreactor.data.model.User;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Miroslaw Stanek on 23.06.15.
 * 2017-11-30 Updated by gdev2018
 */
@Module
public class UserModule {

    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
