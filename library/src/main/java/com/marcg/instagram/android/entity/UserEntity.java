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

package com.marcg.instagram.android.entity;

import com.google.gson.annotations.SerializedName;
import com.marcg.instagram.android.entity.model.Counts;

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public class UserEntity {
    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("bio")
    private String bio;
    @SerializedName("website")
    private String website;
    @SerializedName("counts")
    private Counts counts;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public String getWebsite() {
        return website;
    }

    public Counts getCounts() {
        return counts;
    }
}
