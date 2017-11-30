package org.gdev2018.githubreactor.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.common.collect.ImmutableList;

import org.gdev2018.githubreactor.GithubReactorApplication;
import org.gdev2018.githubreactor.R;
import org.gdev2018.githubreactor.data.model.Repository;
import org.gdev2018.githubreactor.ui.activity.module.RepositoriesListActivityModule;
import org.gdev2018.githubreactor.ui.activity.presenter.RepositoriesListActivityPresenter;
import org.gdev2018.githubreactor.ui.adapter.RepositoriesListAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 * 2017-11-30 Updated by gdev2018
 */
public class RepositoriesListActivity extends BaseActivity {
    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    RepositoriesListActivityPresenter presenter;
    @Inject
    RepositoriesListAdapter repositoriesListAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);
        ButterKnife.bind(this);
        setupRepositoriesListView();
        presenter.loadRepositories();
    }

    private void setupRepositoriesListView() {
        rvRepositories.setAdapter(repositoriesListAdapter);
        rvRepositories.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void setupActivityComponent() {
        GithubReactorApplication.get(this).getUserComponent()
                .plus(new RepositoriesListActivityModule(this))
                .inject(this);
    }

    public void showLoading(boolean loading) {
        rvRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.updateRepositoriesList(repositories);
    }

    public void onRepositoryClick(Repository repository) {
        RepositoryDetailsActivity.startWithRepository(repository, this);
    }

    @Override
    public void finish() {
        super.finish();
        GithubReactorApplication.get(this).releaseUserComponent();
    }
}
