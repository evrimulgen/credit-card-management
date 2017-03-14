package com.github.mzule.fantasyslide.common;

import com.github.mzule.fantasyslide.AppConfig;
import com.github.mzule.fantasyslide.C;
import com.github.mzule.fantasyslide.base.BaseApplication;
import com.github.mzule.fantasyslide.domain.CityORM;
import com.litesuits.orm.LiteOrm;

import rx.Observable;

/**
 * Created by shanhong on 3/14/17.
 */

public class OrmLite {

    static LiteOrm sLiteOrm;

    public static LiteOrm getInstance() {
        getOrmHolder();
        return sLiteOrm;
    }

    private static OrmLite getOrmHolder() {
        return OrmHolder.sInstance;
    }

    private OrmLite() {
        if (sLiteOrm == null) {
            sLiteOrm = LiteOrm.newSingleInstance(BaseApplication.getAppContext(), C.ORM_NAME);

        }
        sLiteOrm.setDebugged(AppConfig.DEBUG);
    }

    private static class OrmHolder {
        private static final OrmLite sInstance = new OrmLite();
    }

    public static <T> void OrmTest(Class<T> t) {
        Observable.from(getInstance().query(t))
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new SimpleSubscriber<T>() {
                    @Override
                    public void onNext(T t) {
                        if (t instanceof CityORM) {
                            PLog.w(((CityORM) t).getName());
                        }
                    }
                });
    }
}