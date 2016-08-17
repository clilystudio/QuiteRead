package com.clilystudio.quiteread;

import android.app.Application;

import com.clilystudio.quiteread.dao.DaoMaster;
import com.clilystudio.quiteread.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class MyApplication extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "quiteread.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
