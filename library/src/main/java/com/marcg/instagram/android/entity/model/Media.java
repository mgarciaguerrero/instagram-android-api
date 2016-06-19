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

package com.marcg.instagram.android.entity.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public class Media {
    @SerializedName("comments")
    private Comments comments;
    @SerializedName("caption")
    private Caption caption;
    @SerializedName("likes")
    private Likes likes;
    @SerializedName("link")
    private String link;
    @SerializedName("created_time")
    private String createdTime;
    @SerializedName("images")
    private Images images;
    @SerializedName("type")
    private String type;
    @SerializedName("users_in_photo")
    private List<UserInPhoto> usersInPhoto;
    @SerializedName("filter")
    private String filter;
    @SerializedName("tags")
    private List<String> tags = new ArrayList<>();
    @SerializedName("id")
    private String id;
    @SerializedName("user")
    private User user;
    @SerializedName("location")
    private Location location;
    @SerializedName("distance")
    private Double distance;

    public Comments getComments() {
        return comments;
    }

    public Caption getCaption() {
        return caption;
    }

    public Likes getLikes() {
        return likes;
    }

    public String getLink() {
        return link;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public Images getImages() {
        return images;
    }

    public String getType() {
        return type;
    }

    public List<UserInPhoto> getUsersInPhoto() {
        return usersInPhoto;
    }

    public String getFilter() {
        return filter;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Location getLocation() {
        return location;
    }

    public Double getDistance() {
        return distance;
    }
}
