package org.gdev2018.githubreactor.ui.activity.component;

import org.gdev2018.githubreactor.ui.activity.ActivityScope;
import org.gdev2018.githubreactor.ui.activity.RepositoryDetailsActivity;
import org.gdev2018.githubreactor.ui.activity.module.RepositoryDetailsActivityModule;

import dagger.Subcomponent;


/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoryDetailsActivityModule.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

}