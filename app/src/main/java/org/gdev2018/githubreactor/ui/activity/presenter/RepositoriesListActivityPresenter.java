package org.gdev2018.githubreactor.ui.activity.presenter;

import com.google.common.collect.ImmutableList;

import org.gdev2018.githubreactor.data.api.RepositoriesManager;
import org.gdev2018.githubreactor.data.model.Repository;
import org.gdev2018.githubreactor.ui.activity.RepositoriesListActivity;
import org.gdev2018.githubreactor.utils.SimpleObserver;


/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class RepositoriesListActivityPresenter {
    private RepositoriesListActivity repositoriesListActivity;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity,
                                             RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesListActivity.showLoading(true);
        repositoriesManager.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                repositoriesListActivity.showLoading(false);
            }
        });
    }

}
