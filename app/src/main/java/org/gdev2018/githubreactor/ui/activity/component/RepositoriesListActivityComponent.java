package org.gdev2018.githubreactor.ui.activity.component;

import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.RepositoriesListActivity;
import org.gdev2018.githubreactor.ui.activity.module.RepositoriesListActivityModule;

import dagger.Subcomponent;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 * 2017-11-30 Updated by gdev2018
 */
@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

}