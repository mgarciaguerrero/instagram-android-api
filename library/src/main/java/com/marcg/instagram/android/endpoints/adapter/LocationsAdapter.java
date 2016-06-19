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

import com.marcg.instagram.android.endpoints.responses.LocationResponse;
import com.marcg.instagram.android.endpoints.responses.LocationSearchResponse;
import com.marcg.instagram.android.endpoints.responses.MediaResponse;
import com.marcg.instagram.android.endpoints.service.LocationsService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class LocationsAdapter extends BaseAdapter {

    private LocationsService locationsService;

    public LocationsAdapter() {
        super();
        locationsService = BaseAdapter.createService(LocationsService.class);
    }

    /**
     * Get information about a location.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param locationID
     * @return LocationResponse
     */
    public Call<LocationResponse> getLocationInfo(String locationID) {
        return locationsService.getLocationInfo(locationID);
    }

    /**
     * Get a list of recent media objects from a given location.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param locationID
     * @return MediaResponse
     */
    public Call<MediaResponse> getLocationMediaList(String locationID) {
        return locationsService.getLocationMediaList(locationID);
    }

    /**
     * Search for a location by geographic coordinate.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param latitude latitude of the center search coordinate. If used, lng is required.
     * @param longitude longitude of the center search coordinate. If used, lat is required.
     * @return LocationSearchResponse
     */
    public Call<LocationSearchResponse> getLocationSearchedList(double latitude, double longitude) {
        return locationsService.getLocationSearchedList(latitude, longitude);
    }
}
