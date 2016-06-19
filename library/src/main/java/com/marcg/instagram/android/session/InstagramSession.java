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

package com.marcg.instagram.android.session;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.marcg.instagram.android.InstagramManager;
import com.marcg.instagram.android.constants.SharedPreferencesConstants;
import com.marcg.instagram.android.ui.InstagramLoginWebViewFragment;

/**
 * Created by Marc Garcia on 31/03/2016.
 */
public final class InstagramSession {

    public boolean isActive() {
        String accessToken = getAccessToken();
        return accessToken != null && !accessToken.isEmpty();
    }

    public String getAccessToken() {
        return InstagramManager.getContext().getSharedPreferences(SharedPreferencesConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
                .getString(SharedPreferencesConstants.TOKEN_KEY, null);
    }

    private void saveAccessToken(String accessToken) {
        InstagramManager.getContext().getSharedPreferences(SharedPreferencesConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(SharedPreferencesConstants.TOKEN_KEY, accessToken)
                .commit();
    }

    public void setAccessToken(String accessToken) {
        saveAccessToken(accessToken);
    }

    public void logout() {
        saveAccessToken(null);
    }

    public void login(Activity activity) {
        login(activity, null);
    }

    public void login(final Activity activity, final String[] permission) {
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                try {
                    FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
                    Fragment prev = activity.getFragmentManager().findFragmentByTag("twitterLoginWebViewFragment");
                    if (prev != null) {
                        ft.remove(prev);
                    }

                    if (prev == null) {
                        InstagramLoginWebViewFragment webViewFragment = new InstagramLoginWebViewFragment();
                        webViewFragment.setCancelable(true);
                        if (permission != null) {
                            Bundle bundle = new Bundle();
                            bundle.putStringArray("permissions", permission);
                            webViewFragment.setArguments(bundle);
                        }
                        webViewFragment.show(ft, "instagramLoginWebViewFragment");
                    }
                } catch (IllegalStateException e){
                    Log.w("TAG", e.getMessage());
                    //Activity has been destroyed, do nothing
                }
            }
        });
    }
}
