package com.clilystudio.quiteread;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.clilystudio.quiteread.model.Account;
import com.clilystudio.quiteread.model.BookInfo;
import com.clilystudio.quiteread.model.ChapterLink;
import com.clilystudio.quiteread.model.User;
import com.integralblue.httpresponsecache.HttpResponseCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplication extends Application {
    public static final String TAG = "QuiteBook";
    private static final String MIPUSH_APP_ID = "2882303761517133731";
    private static final String MIPUSH_APP_KEY = "5941713373731";
    private static MyApplication mApp = null;
//    private Reader mReader;
    private BookInfo mBookInfo;
    private int mReadMode;
    private String mBookId = null;
    private List<String> mBookCacheList;
    private Map<String, ChapterLink[]> mChapterCacheMap;

    public static MyApplication getInstance() {
        return mApp;
    }

    public final int getReadMode() {
        return this.mReadMode;
    }

    public final void setReadMode(int readMode) {
        this.mReadMode = readMode;
    }

    public final void saveAccoutInfo(Account account) {
        putString("account.token", account.getToken());
        User user = account.getUser();
        putString("user.id", user.getId());
        putString("user.name", user.getNickname());
        putString("user.avatar", user.getAvatar());
        putInt("user.lv", user.getLv());
        if (user.getGender() != null) {
            putString("user.gender", user.getGender());
        }
    }

    public final BookInfo getBookInfo() {
        return this.mBookInfo;
    }

    public final void setBookInfo(BookInfo bookInfo) {
        this.mBookInfo = bookInfo;
    }
//
//    public final Reader getReader() {
//        return this.mReader;
//    }
//
//    public final void setReader(Reader reader) {
//        this.mReader = reader;
//    }

    public final void removeProperties(String... keys) {
        SharedPreferences.Editor editor = getEditor(this);
        for (String key : keys) {
            editor.remove(key);
        }
        editor.apply();
    }

    public final boolean saveObject(Serializable object, String name) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = openFileOutput(name, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }

    public final Serializable loadObject(String name) {
        File file = getFileStreamPath(name);
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = openFileInput(name);
                ois = new ObjectInputStream(fis);
                return (Serializable) ois.readObject();
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public final String getBookId() {
        return this.mBookId;
    }

    public final void setBookId(String bookId) {
        this.mBookId = bookId;
    }

    public final Map<String, ChapterLink[]> getChapterCacheMap() {
        if (this.mChapterCacheMap == null) {
            this.mChapterCacheMap = new HashMap<>();
        }
        return this.mChapterCacheMap;
    }

    public final List<String> getBookCacheList() {
        if (this.mBookCacheList == null) {
            this.mBookCacheList = new ArrayList<>();
        }
        return this.mBookCacheList;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
//        String useHttpDns = OnlineConfigAgent.getInstance().getConfigParams(mApp, "use_http_dns");
//        DnsManager.setUseDns("1".equals(useHttpDns));
//        com.clilystudio.quiteread.hpay100.a.a.q(this);
        ActiveAndroid.initialize(this);
        new Thread() {
            @Override
            public void run() {
                File file = new File(getCacheDir(), "http2");
                try {
                    HttpResponseCache.install(file, 200 * 1024 * 1024);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
//        OnlineConfigAgent.getInstance().setOnlineConfigListener(new UmengOnlineConfigureListener() {
//            @Override
//            public void onDataReceived(JSONObject jsonObject) {
//                String string = OnlineConfigAgent.getInstance().getConfigParams(mApp, "set_default_api");
//                if (!TextUtils.isEmpty(string)) {
//                    ApiService.a(string);
//                }
//                ApiService.j(OnlineConfigAgent.getInstance().getConfigParams(mApp, "reader_web_url"), 4);
//            }
//        });
        if (shouldInit()) {
            MiPushClient.registerPush(this, MIPUSH_APP_ID, MIPUSH_APP_KEY);
            LoggerInterface newLogger = new LoggerInterface() {

                @Override
                public void setTag(String tag) {
                    // ignore
                }

                @Override
                public void log(String content, Throwable t) {
                    Log.d(TAG, content, t);
                }

                @Override
                public void log(String content) {
                    Log.d(TAG, content);
                }
            };
            Logger.setLogger(this, newLogger);
        }
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        if (PreferenceManager.getDefaultSharedPreferences(this).getLong("PREF_FIRST_LAUNCH_TIME", 0L) == 0L) {
            putLong("PREF_FIRST_LAUNCH_TIME", Calendar.getInstance().getTimeInMillis());
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    private boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = getEditor(this);
        editor.putString(key, value);
        editor.apply();
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = getEditor(this);
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = getEditor(this);
        editor.putLong(key, value);
        editor.apply();
    }

    private SharedPreferences.Editor getEditor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit();
    }
}
