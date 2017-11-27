package org.gdev2018.githubreactor.ui.activity.presenter;


import org.gdev2018.githubreactor.data.model.User;
import org.gdev2018.githubreactor.ui.activity.RepositoryDetailsActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class RepositoryDetailsActivityPresenter {
    private RepositoryDetailsActivity repositoryDetailsActivity;
    private User user;

    public RepositoryDetailsActivityPresenter(RepositoryDetailsActivity repositoryDetailsActivity, User user) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
        this.user = user;
    }

    public void init() {
        repositoryDetailsActivity.setupUserName(user.login);
    }
}
