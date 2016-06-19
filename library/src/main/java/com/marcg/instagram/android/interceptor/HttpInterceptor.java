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

package com.marcg.instagram.android.interceptor;

import com.marcg.instagram.android.InstagramManager;
import com.marcg.instagram.android.constants.ApiConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Marc Garcia on 03/06/2016.
 */
public class HttpInterceptor implements Interceptor {

    private static final Object syncObj = new Object();

    @Override
    public Response intercept(Chain chain) throws IOException {
        synchronized (syncObj) {
            Request request = chain.request();
            HttpUrl url = null;
            if (InstagramManager.getSession().getAccessToken() != null) {
                if (request.method().equals(ApiConstants.REQUEST_METHOD.GET.toString()) ||
                        request.method().equals(ApiConstants.REQUEST_METHOD.DELETE.toString())) {
                    url = request.url().newBuilder().addQueryParameter("access_token",
                            InstagramManager.getSession().getAccessToken()).build();
                } else if (request.method().equals(ApiConstants.REQUEST_METHOD.POST.toString()) &&
                        !request.url().toString().contains(ApiConstants.URL_GET_TOKEN)) {
                    url = request.url().newBuilder().addEncodedQueryParameter("access_token",
                            InstagramManager.getSession().getAccessToken()).build();
                }
                if (url != null) {
                    request = request.newBuilder().url(url).build();
                }
            }
            return chain.proceed(request);
        }
    }
}
