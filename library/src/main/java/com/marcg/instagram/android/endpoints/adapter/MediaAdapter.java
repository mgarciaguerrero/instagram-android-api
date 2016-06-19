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

import com.marcg.instagram.android.endpoints.responses.MediaResponse;
import com.marcg.instagram.android.endpoints.responses.MediaResponseList;
import com.marcg.instagram.android.endpoints.service.MediaService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class MediaAdapter extends BaseAdapter {

    private MediaService mediaService;

    public MediaAdapter() {
        super();
        mediaService = BaseAdapter.createService(MediaService.class);
    }

    /**
     * Get information about a media object. Use the type field to differentiate between image and
     * video media in the response. You will also receive the user_has_liked field which tells you
     * whether the owner.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param mediaID
     * @return MediaResponse
     */
    public Call<MediaResponse> getMediaByID(String mediaID) {
        return mediaService.getMediaByID(mediaID);
    }

    /**
     * A media object's shortcode can be found in its shortlink URL.
     * An example shortlink is http://instagram.com/p/tsxp1hhQTG/.
     * Its corresponding shortcode is tsxp1hhQTG.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>basic</u>: to read a user’s profile info and media</li>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param shortcode
     * @return MediaResponse
     */
    public Call<MediaResponse> getMediaShortcode(String shortcode) {
        return mediaService.getMediaShortcode(shortcode);
    }

    /**
     * Search for recent media in a given area.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param latitude latitude of the center search coordinate. If used, lng is required.
     * @param longitude longitude of the center search coordinate. If used, lat is required.
     * @return MediaResponseList
     */
    public Call<MediaResponseList> getMediaSearch(double latitude, double longitude) {
        return mediaService.getMediaSearch(latitude, longitude);
    }
}
