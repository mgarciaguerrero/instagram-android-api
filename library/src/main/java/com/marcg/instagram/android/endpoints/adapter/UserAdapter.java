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

package com.marcg.instagram.android.endpoints.adapter;

import com.marcg.instagram.android.endpoints.responses.MediaResponseList;
import com.marcg.instagram.android.endpoints.responses.UserResponse;
import com.marcg.instagram.android.endpoints.responses.UserSearchResponse;
import com.marcg.instagram.android.endpoints.service.UserService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class UserAdapter extends BaseAdapter {

    private UserService userService;

    public UserAdapter() {
        super();
        userService = BaseAdapter.createService(UserService.class);
    }

    /**
     * Get information about the owner.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     * </ul>
     * @return UserResponse
     */
    public Call<UserResponse> getSelfUser() {
        return userService.getSelfUser();
    }

    /**
     * Get information about a user.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param userID
     * @return UserResponse
     */
    public Call<UserResponse> getUserByID(String userID) {
        return userService.getUserByID(userID);
    }

    /**
     * Get the most recent media published by the owner.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     * </ul>
     * @return MediaResponse
     */
    public Call<MediaResponseList> getSelfMediaRecent() {
        return userService.getSelfMediaRecent("comments");
    }

    /**
     * Get the most recent media published by a user.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param userID
     * @return MediaResponse
     */
    public Call<MediaResponseList> getMediaRecentByID(String userID) {
        return userService.getMediaRecentByID(userID);
    }

    /**
     * Get the list of recent media liked by the owner.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @return MediaResponse
     */
    public Call<MediaResponseList> getSelfMediaLiked() {
        return userService.getSelfMediaLiked();
    }

    /**
     * Get a list of users matching the query.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @return UserSearchResponse
     */
    public Call<UserSearchResponse> getSearchedUsers() {
        return userService.getSearchedUsers();
    }
}
