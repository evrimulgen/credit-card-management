package com.github.mzule.fantasyslide.common;

import rx.Subscriber;

/**
 * Created by shanhong on 3/14/17.
 */

public abstract class SimpleSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        PLog.e(e.toString());
    }
}
