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

import com.marcg.instagram.android.endpoints.responses.BaseResponse;
import com.marcg.instagram.android.endpoints.responses.LikesResponse;
import com.marcg.instagram.android.endpoints.service.LikesService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class LikesAdapter extends BaseAdapter {

    private LikesService likesService;

    public LikesAdapter() {
        super();
        likesService = BaseAdapter.createService(LikesService.class);
    }

    /**
     * Get a list of users who have liked this media.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @return LikesResponse
     */
    public Call<LikesResponse> getLikes(String mediaID) {
        return likesService.getLikes(mediaID);
    }

    /**
     * Set a like on this media by the currently authenticated user.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>likes</u>: to like and unlike media on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @return BaseResponse
     */
    public Call<BaseResponse> postLike(String mediaID) {
        return likesService.postLike(mediaID);
    }

    /**
     * Remove a like on this media by the currently authenticated user.
     * </ul>
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>likes</u>: to like and unlike media on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @return BaseResponse
     */
    public Call<BaseResponse> removeLike(String mediaID) {
        return likesService.removeLike(mediaID);
    }
}
