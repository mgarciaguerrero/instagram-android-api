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

package com.marcg.instagram.android.ui;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.marcg.instagram.android.InstagramManager;
import com.marcg.instagram.android.callback.InstagramCallback;
import com.marcg.instagram.android.endpoints.responses.AuthResponse;
import com.marcg.instagram.android.instagram_android_sdk.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Marc Garcia on 31/03/2016.
 */
public class InstagramLoginWebViewFragment extends DialogFragment {

    private final String TAG = this.getClass().getSimpleName();

    private InstagramCallback instagramCallback;
    WebView webView;
    private View loadingLayout;
    private View loadedLayout;
    private View errorLayout;
    private TextView errorTextView;

    private String clientID;
    private String clientSecret;
    private String redirectURL;

    @Override
    public View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_webview_instagram, container, false);
//        setContentView(R.layout.fragment_webview_instagram);
        try {
            ApplicationInfo ai = getActivity().getPackageManager().getApplicationInfo(getActivity().getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            clientID = bundle.getString("instagram.ClientId");
            clientSecret = bundle.getString("instagram.ClientSecret");
            redirectURL = bundle.getString("instagram.RedirectUrl");
        } catch (PackageManager.NameNotFoundException e) {
            // TODO: thrown an exception
            Log.e("", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            // TODO: thrown an exception
            Log.e("", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }
        if (clientID != null && clientSecret != null && redirectURL != null) {
//            getDialog().setTitle(ResourceManager.getInstance(getActivity()).getString(Res.string.seat_driver_out_instagram_login_title));
            View view = inflater.inflate(R.layout.fragment_webview_instagram, container, false);
            webView = (WebView) view.findViewById(R.id.webview_instagram);
            loadingLayout = view.findViewById(R.id.webview_loading_layout);
            loadedLayout = view.findViewById(R.id.webview_normal_layout);
            errorLayout = view.findViewById(R.id.webview_error_layout);

            errorTextView = ((TextView) view.findViewById(R.id.socialfeedreader_webview_error));
            configureWebView();

            String[] stringsPermission = {"basic"};
            if (getArguments() != null && !getArguments().isEmpty() && getArguments().getStringArray("permissions") != null) {
                stringsPermission = getArguments().getStringArray("permissions");
            }
            webView.loadUrl(InstagramManager.getTokenAdapter().getCodeRequest(clientID, redirectURL, stringsPermission));
            return view;
        }else{
            // TODO: add an exception if items are not added on Manifest
            dismiss();
            return null;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
//        Intent intent = new Intent(TwitterUtil.BROADCAST_LOGIN_RESULT);
//        intent.putExtra(TwitterUtil.PARAM_LOGIN_RESULT, false);
//        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
        super.onCancel(dialog);
    }

    private void configureWebView() {

        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        webView.setWebViewClient(new InstagramWebViewClient());
        webView.setWebChromeClient(new InstagramWebChromeClient());

        CookieSyncManager.createInstance(getActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
//        webView.loadUrl(Auth.getCodeRequest(InstagramApp.CLIENT_ID, InstagramApp.REDIRECT_URL));
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.removeAllCookie();
//
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(false);
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.getSettings().setAppCacheEnabled(false);
//        webView.getSettings().setDatabaseEnabled(false);
//        webView.getSettings().setSaveFormData(false);
//
//        webView.clearCache(true);
//
//        webView.setWebViewClient(new InstagramWebViewClient());
//        webView.setWebChromeClient(new InstagramWebChromeClient());
    }

    private class InstagramWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(url.startsWith(redirectURL)) {
                loadingLayout.setVisibility(View.VISIBLE);
                loadedLayout.setVisibility(View.GONE);
                errorLayout.setVisibility(View.GONE);
//                final Intent intent = new Intent();
                if (url.contains("code")) {
                    String temp[] = url.split("=");
                    final String code = temp[1];

                    Call call = InstagramManager.getTokenAdapter().getToken(
                            clientID,
                            clientSecret,
                            redirectURL, code);

                    call.enqueue(new Callback<AuthResponse>() {
                        @Override
                        public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                            if (response != null && response.body() != null) {
                                InstagramManager.getSession().setAccessToken(response.body().getAccessToken());
                                if (instagramCallback != null) instagramCallback.onSuccess(response.body());
                            } else {
                                //TODO implements when accessToken is null
                            }
                            dismiss();
                        }

                        @Override
                        public void onFailure(Call<AuthResponse> call, Throwable t) {
//                            intent.putExtra("error", t.getMessage());
//                            setResult(Activity.RESULT_OK, intent);
//                            finish();
                            //TODO implements onFailure
                            dismiss();
                        }
                    });
                } else if (url.contains("error")) {
                    dismiss();
//                    String temp[] = url.split("=");
//                    String error = temp[temp.length - 1];
//                    intent.putExtra("error", error);
//                    setResult(Activity.RESULT_OK, intent);
//                    finish();
                }
                return true;
            }
            return false;
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.i("TAG", "onPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.i("TAG", "onPageFinished");
            loadingLayout.setVisibility(View.GONE);
            loadedLayout.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            errorLayout.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Log.i("TAG", "onReceivedError");
            if (!failingUrl.contains("context.ok")) {
                loadingLayout.setVisibility(View.GONE);
                loadedLayout.setVisibility(View.GONE);
                errorLayout.setVisibility(View.VISIBLE);
//                errorTextView.setText(ResourceManager.getInstance(getActivity()).getString(Res.string.seat_driver_out_twitter_login_error));
            }
        }
    }

    public void setInstagramCallback(InstagramCallback instagramCallback) {
        this.instagramCallback = instagramCallback;
    }

    private class InstagramWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

//        @Override
//        public boolean onJsConfirm(WebView view, String url, String message,
//                                   final JsResult result) {
//            new AlertDialog.Builder(getActivity()).setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    result.confirm();
//                }
//            }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    result.cancel();
//                }
//            }).create().show();
//
//            return true;
//        }
    }

}
