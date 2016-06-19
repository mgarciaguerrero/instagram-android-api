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

import com.marcg.instagram.android.constants.ApiConstants;
import com.marcg.instagram.android.endpoints.responses.FollowsUserResponse;
import com.marcg.instagram.android.endpoints.responses.RelationshipResponse;
import com.marcg.instagram.android.endpoints.service.RelationshipsService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class RelationshipAdapter extends BaseAdapter {

    private RelationshipsService relationshipsService;

    public RelationshipAdapter() {
        super();
        relationshipsService = BaseAdapter.createService(RelationshipsService.class);
    }

    /**
     * Get the list of users this user follows.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>follower_list</u>: to read the list of followers and followed-by users</li>
     * </ul>
     * @return FollowsUserResponse
     */
    public Call<FollowsUserResponse> getSelfFollows() {
        return relationshipsService.getSelfFollows();
    }

    /**
     * Get the list of users this user is followed by.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>follower_list</u>: to read the list of followers and followed-by users</li>
     * </ul>
     * @return FollowsUserResponse
     */
    public Call<FollowsUserResponse> getSelfFollowedBy() {
        return relationshipsService.getSelfFollowedBy();
    }

    /**
     * List the users who have requested this user's permission to follow.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>follower_list</u>: to read the list of followers and followed-by users</li>
     * </ul>
     * @return FollowsUserResponse
     */
    public Call<FollowsUserResponse> getSelfRequestedBy() {
        return relationshipsService.getSelfRequestedBy();
    }

    /**
     *  Get information about a relationship to another user. Relationships are expressed using the following terms in the response:
     * <ul>
     *     <li><b>outgoing_status</b>: Your relationship to the user. Can be 'follows', 'requested', 'none'.</li>
     *     <li><b>incoming_status</b>: A user's relationship to you. Can be 'followed_by', 'requested_by', 'blocked_by_you', 'none'.</li>
     * </ul>
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>follower_list</u>: to read the list of followers and followed-by users</li>
     * </ul>
     * @return FollowsUserResponse
     */
    public Call<RelationshipResponse> getUserRelationship(String userID) {
        return relationshipsService.getUserRelationship(userID);
    }

    /**
     * Modify the relationship between the current user and the target user. You need to include an
     * action parameter to specify the relationship action you want to perform. Valid actions are:
     * 'follow', 'unfollow' 'approve' or 'ignore'. Relationships are expressed using the following
     * terms in the response:
     * <ul>
     *     <li><b>outgoing_status</b>: Your relationship to the user. Can be 'follows', 'requested', 'none'.</li>
     *     <li><b>incoming_status</b>: A user's relationship to you. Can be 'followed_by', 'requested_by', 'blocked_by_you', 'none'.</li>
     * </ul>
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>relationships</u>: to follow and unfollow accounts on a user’s behalf</li>
     * </ul>
     * @param userID
     * @param action can be follow, unfollow, approve or ignore
     * @return RelationshipEntity
     */
    public Call<RelationshipResponse> modifyRelationship(String userID, ApiConstants.RELATIONSHIP_ACTION action) {
        return relationshipsService.modifyRelationship(userID,action);
    }
}
