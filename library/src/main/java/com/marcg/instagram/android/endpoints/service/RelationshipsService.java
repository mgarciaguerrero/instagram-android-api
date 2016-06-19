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

import com.marcg.instagram.android.constants.ApiConstants;
import com.marcg.instagram.android.endpoints.responses.FollowsUserResponse;
import com.marcg.instagram.android.endpoints.responses.RelationshipResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public interface RelationshipsService {

    @GET("v1/users/self/follows")
    Call<FollowsUserResponse> getSelfFollows();

    @GET("v1/users/self/followed-by")
    Call<FollowsUserResponse> getSelfFollowedBy();

    @GET("v1/users/self/requested-by")
    Call<FollowsUserResponse> getSelfRequestedBy();

    @GET("v1/users/{user-id}/relationship")
    Call<RelationshipResponse> getUserRelationship(@Path("user-id") String userID);

    @FormUrlEncoded
    @POST("v1/users/{user-id}/relationship")
    Call<RelationshipResponse> modifyRelationship(@Path("user-id") String userID,
                                                  @Field("action") ApiConstants.RELATIONSHIP_ACTION action);
}
