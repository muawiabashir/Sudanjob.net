package net.onlinemarketing.sudanjobnet.Activity;

import android.app.Application;
import android.util.Log;

import org.piwik.sdk.Piwik;
import org.piwik.sdk.Tracker;

import java.net.MalformedURLException;

/**
 * Created by muawia.ibrahim on 3/29/2016.
 */
public class PiwikApplication extends Application {
    private Tracker mPiwikTracker;

    public synchronized Tracker getTracker() {
        if (mPiwikTracker != null) {
            return mPiwikTracker;
        }

        try {
            mPiwikTracker = Piwik.getInstance(this).newTracker("http://www.sudanjob.net/piwik/piwik.php", 5);
        } catch (MalformedURLException e) {
        //   Log.w(Tracker.LOGGER_TAG, "url is malformed", e);
            return null;
        }

        return mPiwikTracker;
    }
    //...
}