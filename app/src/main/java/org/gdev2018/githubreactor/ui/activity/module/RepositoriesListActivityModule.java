package org.gdev2018.githubreactor.ui.activity.module;

import android.support.v7.widget.LinearLayoutManager;

import org.gdev2018.githubreactor.data.api.RepositoriesManager;
import org.gdev2018.githubreactor.data.model.Repository;
import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.RepositoriesListActivity;
import org.gdev2018.githubreactor.ui.activity.presenter.RepositoriesListActivityPresenter;
import org.gdev2018.githubreactor.ui.adapter.RepositoriesListAdapter;
import org.gdev2018.githubreactor.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import org.gdev2018.githubreactor.ui.adapter.viewholder.RepositoryViewHolderBigFactory;
import org.gdev2018.githubreactor.ui.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import org.gdev2018.githubreactor.ui.adapter.viewholder.RepositoryViewHolderNormalFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;


/**
 * Created by Miroslaw Stanek on 23.04.15.
 * 2017-11-30 Updated by gdev2018
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoriesManager);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(repositoriesListActivity, viewHolderFactories);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(RepositoriesListActivity repositoriesListActivity) {
        return new LinearLayoutManager(repositoriesListActivity);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesListViewHolderFactory provideViewHolderNormal() {
        return new RepositoryViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesListViewHolderFactory provideViewHolderBig() {
        return new RepositoryViewHolderBigFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_FEATURED)
    RepositoriesListViewHolderFactory provideViewHolderFeatured() {
        return new RepositoryViewHolderFeaturedFactory();
    }
}