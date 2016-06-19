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
import com.marcg.instagram.android.endpoints.responses.TagResponse;
import com.marcg.instagram.android.endpoints.responses.TagSearchResponse;
import com.marcg.instagram.android.endpoints.service.TagsService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 01/04/2016.
 */
public class TagsAdapter extends BaseAdapter {

    private TagsService tagsService;

    public TagsAdapter() {
        super();
        tagsService = BaseAdapter.createService(TagsService.class);
    }

    /**
     * Get information about a tag object.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param tagName
     * @return TagResponse
     */
    public Call<TagResponse> getTagInfo(String tagName) {
        return tagsService.getTagInfo(tagName);
    }

    /**
     * Get a list of recently tagged media.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param tagName
     * @return MediaResponse
     */
    public Call<MediaResponse> getTaggedMediaList(String tagName) {
        return tagsService.getTaggedMediaList(tagName);
    }

    /**
     * Search for tags by name.
     * <br>
     * <br>
     * <b>Needed permissions:</b>
     * <ul>
     *     <li><u>public_content</u>: to read any public profile info and media on a user’s behalf</li>
     * </ul>
     * @param tagName
     * @return MediaResponse
     */
    public Call<TagSearchResponse> getTagsByName(String tagName) {
        return tagsService.getTagsByName(tagName);
    }
}
