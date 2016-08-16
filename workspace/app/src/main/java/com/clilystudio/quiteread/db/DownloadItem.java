package com.clilystudio.quiteread.db;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "DownloadItem")
public class DownloadItem {
    @Property(nameInDb = "package_name")
    public String packageName;
    @Property(nameInDb = "uid")
    public String uid;

    public DownloadItem() {
    }

    public DownloadItem(String string) {
        this.packageName = string;
    }

    @Generated(hash = 225052799)
    public DownloadItem(String packageName, String uid) {
        this.packageName = packageName;
        this.uid = uid;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean existsInDb(String string) {
        return !(TextUtils.isEmpty(string) || new Select().from(DownloadItem.class).where("package_name=?", string).execute().size() == 0);
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
