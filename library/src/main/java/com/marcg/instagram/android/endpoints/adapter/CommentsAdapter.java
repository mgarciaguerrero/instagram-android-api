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
import com.marcg.instagram.android.endpoints.responses.CommentsResponse;
import com.marcg.instagram.android.endpoints.service.CommentsService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class CommentsAdapter extends BaseAdapter {

    private CommentsService commentsService;

    public CommentsAdapter() {
        super();
        commentsService = BaseAdapter.createService(CommentsService.class);
    }

    /**
     * Get a list of recent comments on a media object.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @return CommentsResponse
     */
    public Call<CommentsResponse> getComments(String mediaID) {
        return commentsService.getComments(mediaID);
    }

    /**
     * Create a comment on a media object with the following rules:
     * <ul>
     *     <li>The total length of the comment cannot exceed 300 characters.</li>
     *     <li>The comment cannot contain more than 4 hashtags.</li>
     *     <li>The comment cannot contain more than 1 URL.</li>
     *     <li>The comment cannot consist of all capital letters.</li>
     * </ul>
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>comments</u>: to post and delete comments on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @param text Text to post as a comment on the media object as specified in media-id.
     * @return BaseResponse
     */
    public Call<BaseResponse> postComment(String mediaID, String text) {
        return commentsService.postComment(mediaID, text);
    }

    /**
     * Remove a comment either on the authenticated user's media object or authored by the authenticated user.
     * </ul>
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>comments</u>: to post and delete comments on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @param commentID
     * @return BaseResponse
     */
    public Call<BaseResponse> removeComment(String mediaID, String commentID) {
        return commentsService.removeComment(mediaID, commentID);
    }
}
