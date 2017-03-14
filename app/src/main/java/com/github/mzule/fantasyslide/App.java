package com.github.mzule.fantasyslide;

import android.app.Application;

import com.github.mzule.fantasyslide.scrollview.DiscreteScrollViewOptions;

/**
 * Created by shanhong on 3/14/17.
 */

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DiscreteScrollViewOptions.init(this);
    }
}
