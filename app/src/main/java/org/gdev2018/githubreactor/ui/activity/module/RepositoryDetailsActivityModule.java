package org.gdev2018.githubreactor.ui.activity.module;

import org.gdev2018.githubreactor.data.model.User;
import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.RepositoryDetailsActivity;
import org.gdev2018.githubreactor.ui.activity.presenter.RepositoryDetailsActivityPresenter;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class RepositoryDetailsActivityModule {
    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity provideRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity, user);
    }
}