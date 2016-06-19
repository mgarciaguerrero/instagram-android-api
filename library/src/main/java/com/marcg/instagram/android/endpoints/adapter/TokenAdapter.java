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

import android.text.TextUtils;

import com.marcg.instagram.android.constants.ApiConstants;
import com.marcg.instagram.android.endpoints.responses.AuthResponse;
import com.marcg.instagram.android.endpoints.service.AccessTokenService;

import retrofit2.Call;

/**
 * Created by Marc Garcia on 31/03/2016.
 */
public class TokenAdapter extends BaseAdapter {

    private AccessTokenService accessTokenService;

    public TokenAdapter() {
        super();
        accessTokenService = BaseAdapter.createService(AccessTokenService.class);
    }

    public String getCodeRequest(String clientId, String redirectUrl, String[] permissions) {
        String permission = TextUtils.join("+", permissions).toLowerCase();
        return ApiConstants.API_AUTH_URL + "client_id=" + clientId + "&redirect_uri=" + redirectUrl + "&response_type=code"
                + "&scope=" + permission;
    }

    public Call<AuthResponse> getToken(String clientId, String clientSecret, String redirectUrl, String code) {
        return accessTokenService.getAccessToken(clientId, clientSecret, redirectUrl, "authorization_code", code);
    }

}
