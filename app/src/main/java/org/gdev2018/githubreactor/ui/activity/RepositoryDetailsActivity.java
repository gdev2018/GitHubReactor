package org.gdev2018.githubreactor.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.gdev2018.githubreactor.GithubReactorApplication;
import org.gdev2018.githubreactor.R;
import org.gdev2018.githubreactor.data.model.Repository;
import org.gdev2018.githubreactor.ui.activity.module.RepositoryDetailsActivityModule;
import org.gdev2018.githubreactor.ui.activity.presenter.RepositoryDetailsActivityPresenter;
import org.gdev2018.githubreactor.utils.AnalyticsManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



public class RepositoryDetailsActivity extends BaseActivity {
    private static final String ARG_REPOSITORY = "arg_repository";

    @BindView(R.id.tvRepoName)
    TextView tvRepoName;
    @BindView(R.id.tvRepoDetails)
    TextView tvRepoDetails;
    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    RepositoryDetailsActivityPresenter presenter;

    private Repository repository;

    public static void startWithRepository(Repository repository, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoryDetailsActivity.class);
        intent.putExtra(ARG_REPOSITORY, repository);
        startingActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);
        ButterKnife.bind(this);
        analyticsManager.logScreenView(getClass().getName());

        repository = getIntent().getParcelableExtra(ARG_REPOSITORY);
        tvRepoName.setText(repository.name);
        tvRepoDetails.setText(repository.url);

        presenter.init();
    }

    @Override
    protected void setupActivityComponent() {
        GithubReactorApplication.get(this).getUserComponent()
                .plus(new RepositoryDetailsActivityModule(this))
                .inject(this);

    }

    public void setupUserName(String userName) {
        tvUserName.setText(userName);
    }
}