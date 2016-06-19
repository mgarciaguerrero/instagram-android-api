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

/**
 * Created by Marc Garcia on 30/03/2016.
 */
public class Location {
    @SerializedName("latitude")
    private Float latitude;
    @SerializedName("longitude")
    private Float longitude;
    @SerializedName("id")
    private String id;
    @SerializedName("street_address")
    private String streetAddress;
    @SerializedName("name")
    private String name;

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public String getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getName() {
        return name;
    }
}
