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

import com.marcg.instagram.android.InstagramManager;
import com.marcg.instagram.android.constants.ApiConstants;
import com.marcg.instagram.android.interceptor.HttpInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marc Garcia on 31/03/2016.
 */
class BaseAdapter {

    private static Retrofit retrofit;
    private static HttpLoggingInterceptor.Level LEVEL_LOG = HttpLoggingInterceptor.Level.BODY;

    protected BaseAdapter() {
        init();
    }

    private static void init() {
        if(retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.BASE_URL)
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public static <T>T createService(Class<T> _class){
        return retrofit.create(_class);
    }

    private static OkHttpClient getClient(){
        OkHttpClient.Builder builderClientHttp = new OkHttpClient().newBuilder();
        // Interceptor added to refresh token
        builderClientHttp.interceptors().add(new HttpInterceptor());
        // Show HTTPS logs
        if(InstagramManager.isActiveLogs()){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(LEVEL_LOG);
            builderClientHttp.addInterceptor(interceptor);
        }
        return builderClientHttp.build();
    }
}
