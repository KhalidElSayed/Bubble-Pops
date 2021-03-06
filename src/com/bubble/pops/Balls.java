/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bubble.pops;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Balls extends Activity {
    //EventListener mListener = new EventListener();

    private static final String LOG_TAG = "libRS_jni";
    private static final boolean DEBUG  = false;
    private static final boolean LOG_ENABLED = DEBUG;
    
    private BallsView mView;

    // get the current looper (from your Activity UI thread for instance

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Create our Preview view and set it as the content of our
        // Activity     
        setContentView(R.layout.main);
        mView = (BallsView) findViewById(R.id.balls_view);
    }

    @Override
    protected void onResume() {
        // Ideally a game should implement onResume() and onPause()
        // to take appropriate action when the activity looses focus
        super.onResume();
        mView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mView.pause();
        Runtime.getRuntime().exit(0);
    }

    static void log(String message) {
        if (LOG_ENABLED) {
            Log.v(LOG_TAG, message);
        }
    }


}

