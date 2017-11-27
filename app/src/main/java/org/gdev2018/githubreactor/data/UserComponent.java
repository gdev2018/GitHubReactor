package org.gdev2018.githubreactor.data;

import org.gdev2018.githubreactor.data.api.UserModule;
import org.gdev2018.githubreactor.ui.activity.component.RepositoriesListActivityComponent;
import org.gdev2018.githubreactor.ui.activity.component.RepositoryDetailsActivityComponent;
import org.gdev2018.githubreactor.ui.activity.module.RepositoriesListActivityModule;
import org.gdev2018.githubreactor.ui.activity.module.RepositoryDetailsActivityModule;

import dagger.Subcomponent;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);

    RepositoryDetailsActivityComponent plus(RepositoryDetailsActivityModule module);
}