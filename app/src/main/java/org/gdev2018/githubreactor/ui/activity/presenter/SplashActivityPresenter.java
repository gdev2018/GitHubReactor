package org.gdev2018.githubreactor.ui.activity.presenter;


import org.gdev2018.githubreactor.HeavyLibraryWrapper;
import org.gdev2018.githubreactor.data.api.UserManager;
import org.gdev2018.githubreactor.data.model.User;
import org.gdev2018.githubreactor.ui.activity.SplashActivity;
import org.gdev2018.githubreactor.utils.SimpleObserver;
import org.gdev2018.githubreactor.utils.Validator;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class SplashActivityPresenter {
    public String username;

    private SplashActivity splashActivity;
    private Validator validator;
    private UserManager userManager;
    private HeavyLibraryWrapper heavyLibraryWrapper;

    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator,
                                   UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
        this.heavyLibraryWrapper = heavyLibraryWrapper;

        //This calls should be delivered to ExternalLibrary right after it will be initialized
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    splashActivity.showLoading(false);
                    splashActivity.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    splashActivity.showLoading(false);
                    splashActivity.showValidationError();
                }
            });
        } else {
            splashActivity.showValidationError();
        }
    }
}
