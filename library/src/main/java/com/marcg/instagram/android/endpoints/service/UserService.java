/*
 * Copyright 2016 Marc Garcia Guerrero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marcg.instagram.android.endpoints.service;

import com.marcg.instagram.android.endpoints.responses.MediaResponseList;
import com.marcg.instagram.android.endpoints.responses.UserResponse;
import com.marcg.instagram.android.endpoints.responses.UserSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public interface UserService {

    @GET("v1/users/self")
    Call<UserResponse> getSelfUser();

    @GET("v1/users/{user-id}")
    Call<UserResponse> getUserByID(@Path("user-id") String userID);

    @GET("v1/users/self/media/recent")
    Call<MediaResponseList> getSelfMediaRecent(@Query("fields") String field);

    @GET("v1/users/{user-id}/media/recent")
    Call<MediaResponseList> getMediaRecentByID(@Path("user-id") String userID);

    @GET("v1/users/self/media/recent")
    Call<MediaResponseList> getSelfMediaLiked();

    @GET("v1/users/search")
    Call<UserSearchResponse> getSearchedUsers();
}
