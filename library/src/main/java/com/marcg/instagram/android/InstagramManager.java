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

package com.marcg.instagram.android;

import android.content.Context;

import com.marcg.instagram.android.endpoints.adapter.CommentsAdapter;
import com.marcg.instagram.android.endpoints.adapter.LikesAdapter;
import com.marcg.instagram.android.endpoints.adapter.LocationsAdapter;
import com.marcg.instagram.android.endpoints.adapter.MediaAdapter;
import com.marcg.instagram.android.endpoints.adapter.RelationshipAdapter;
import com.marcg.instagram.android.endpoints.adapter.TagsAdapter;
import com.marcg.instagram.android.endpoints.adapter.TokenAdapter;
import com.marcg.instagram.android.endpoints.adapter.UserAdapter;
import com.marcg.instagram.android.session.InstagramSession;

/**
 * Created by Marc Garcia on 31/03/2016.
 */
public final class InstagramManager {

    private static InstagramManager instance;
    private static Context context;
    // Session class
    private InstagramSession instagramSession;
    // Adapters
    private TokenAdapter tokenAdapter;
    private UserAdapter userAdapter;
    private RelationshipAdapter relationshipAdapter;
    private MediaAdapter mediaAdapter;
    private CommentsAdapter commentsAdapter;
    private LikesAdapter likesAdapter;
    private TagsAdapter tagsAdapter;
    private LocationsAdapter locationsAdapter;

    private static boolean activeLogs = false;

    private InstagramManager() {
        this.instagramSession = new InstagramSession();
        this.tokenAdapter = new TokenAdapter();
        this.userAdapter = new UserAdapter();
        this.relationshipAdapter = new RelationshipAdapter();
        this.mediaAdapter = new MediaAdapter();
        this.commentsAdapter = new CommentsAdapter();
        this.likesAdapter = new LikesAdapter();
        this.tagsAdapter = new TagsAdapter();
        this.locationsAdapter = new LocationsAdapter();
    }

    public static void init(Context context) {
        InstagramManager.context = context;
    }

    private synchronized static InstagramManager getInstance(){
        if(instance == null){
            instance = new InstagramManager();
        }
        return instance;
    }

    public static Context getContext() {
        return context;
    }

    public static InstagramSession getSession() {
        return getInstance().instagramSession;
    }

    public static TokenAdapter getTokenAdapter() {
        return getInstance().tokenAdapter;
    }

    public static UserAdapter getUserAdapter() {
        return getInstance().userAdapter;
    }

    public static RelationshipAdapter getRelationshipAdapter() {
        return getInstance().relationshipAdapter;
    }

    public static MediaAdapter getMediaAdapter() {
        return getInstance().mediaAdapter;
    }

    public static CommentsAdapter getCommentsAdapter() {
        return getInstance().commentsAdapter;
    }

    public static LikesAdapter getLikesAdapter() {
        return getInstance().likesAdapter;
    }

    public static TagsAdapter getTagsAdapter() {
        return getInstance().tagsAdapter;
    }

    public static LocationsAdapter getLocationsAdapter() {
        return getInstance().locationsAdapter;
    }

    public static boolean isActiveLogs() {
        return activeLogs;
    }

    public static void setActiveLogs(boolean activeLogs) {
        InstagramManager.activeLogs = activeLogs;
    }
}
