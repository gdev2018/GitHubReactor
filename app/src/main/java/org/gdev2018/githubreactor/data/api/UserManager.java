package org.gdev2018.githubreactor.data.api;


import org.gdev2018.githubreactor.data.api.response.UserResponse;
import org.gdev2018.githubreactor.data.model.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 2017-11-24 UserManager - emmits (Rx way) User class by mapping UserResponse
 *  <p>
 *
 * Created by Miroslaw Stanek on 22.04.15.
 * 2017-11-24 Updated by gdev2018
 *
 */
public class UserManager {

    private GithubApiService githubApiService;

    public UserManager(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    public Observable<User> getUser(String username) {
        return githubApiService.getUser(username)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
