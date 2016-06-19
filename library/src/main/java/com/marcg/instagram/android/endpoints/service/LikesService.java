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

import com.marcg.instagram.android.endpoints.responses.BaseResponse;
import com.marcg.instagram.android.endpoints.responses.LikesResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public interface LikesService {

    @GET("v1/media/{media-id}/likes")
    Call<LikesResponse> getLikes(@Path("media-id") String mediaID);

    @POST("v1/media/{media-id}/likes")
    Call<BaseResponse> postLike(@Path("media-id") String mediaID);

    @DELETE("v1/media/{media-id}/likes")
    Call<BaseResponse> removeLike(@Path("media-id") String mediaID);
}
