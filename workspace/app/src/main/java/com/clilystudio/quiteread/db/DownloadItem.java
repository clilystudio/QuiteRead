package com.clilystudio.quiteread.db;

import android.text.TextUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "DownloadItem")
public class DownloadItem extends Model {
    @Column(name = "package_name")
    public String packageName;
    @Column(name = "uid")
    public String uid;

    public DownloadItem() {
    }

    public DownloadItem(String string) {
        this.packageName = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean existsInDb(String string) {
        return !(TextUtils.isEmpty(string) || new Select().from(DownloadItem.class).where("package_name=?", string).execute().size() == 0);
    }
}