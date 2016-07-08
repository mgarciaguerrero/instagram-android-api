instagram-android-api
========

Android wrapper for the Instagram API (Work in progress...)

## How to install

### 1. Add a dependency

Add it in your root build.gradle at the end of repositories:
```gradle
allproject{
    repositories {
    ...
    maven { url "https://jitpack.io" }
    }
}
```

Add the following dependency to your build.gradle:
```gradle
dependencies {
    compile 'com.github.mgarciaguerrero:Instagram-Android-API:0.0.1'
}
```

You can also do it manually, by downloading the source code, importing the `library` folder as an Android Library Module, and adding a dependency on your project to that module.

## How to use

### 1. Set up your application

On your application class, use this snippet:
```java
    @Override
    public void onCreate() {
        super.onCreate();

        //Init InstagramManager with context application
        InstagramManager.init(getApplicationContext());
    }
```

### 2. Set up your manifest
```xml
    <application>
        ...
        <meta-data
            android:name="instagram.ClientId"
            android:value="YOUR_INSTAGRAM_CLIENT_ID" />
        <meta-data
            android:name="instagram.ClientSecret"
            android:value="YOUR_INSTAGRAM_CLIENT_SECRET" />
        <meta-data
            android:name="instagram.RedirectUrl"
            android:value="YOUR_INSTAGRAM_REDIRECT_URL" />
    </application>
```

### 3. Library

To use this library you just need to use ```InstagramManager```. This library has been builded following The Instagram API Platform.

#### 3.1 Authentication

The Instagram API requires authentication but it is automatically managed by the library.

#### 3.2 Login

[TODO] -- add an example

#### 3.3 Permissons

* basic - to read a user’s profile info and media
* public_content - to read any public profile info and media on a user’s behalf
* follower_list - to read the list of followers and followed-by users
* comments - to post and delete comments on a user’s behalf
* relationships - to follow and unfollow accounts on a user’s behalf
* likes - to like and unlike media on a user’s behalf

[TODO] -- add an example

#### 3.3 Endpoints

All endpoints are available in InstagramManager and have been builded following the instagram documentation.

[TODO] -- retrofit

[TODO] -- add an example

## Interesting links

* [Instagram developers]

## Contributing & license

Special thanks to [Jorge Guerrero] for their thoughts and code.

Any contribution in order to make this library better will be welcome!


## License

    Copyright 2016 Marc Garcia Guerrero

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

   [Jorge Guerrero]: <http://jguerrerope.github.io/>
   [Instagram developers]: <https://www.instagram.com/developer/>
