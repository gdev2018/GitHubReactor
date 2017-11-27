package org.gdev2018.githubreactor.data.api;


import org.gdev2018.githubreactor.data.api.response.RepositoryResponse;
import org.gdev2018.githubreactor.data.api.response.UserResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * Created by Miroslaw Stanek on 22.04.15.
 * 2017-11-24 Updated by gdev2018
 */
public interface GithubApiService {

    // 2017-11-24 Observable allowed by RxJavaCallAdapterFactory.create()
    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );

    // 2017-11-24 Observable allowed by RxJavaCallAdapterFactory.create()
    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
