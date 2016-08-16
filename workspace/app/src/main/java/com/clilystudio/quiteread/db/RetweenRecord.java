package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "RetweenRecord")
public class RetweenRecord {
    @Property(nameInDb = "tweetId")
    private String tweetId;
    @Property(nameInDb = "userId")
    private String userId;

    @Generated(hash = 1470766683)
    public RetweenRecord(String tweetId, String userId) {
        this.tweetId = tweetId;
        this.userId = userId;
    }

    @Generated(hash = 1693003640)
    public RetweenRecord() {
    }

    public static void cancelRetween(String string, String string2) {
        new Delete().from(RetweenRecord.class).where(" userId = ? and tweetId = ? ", string, string2).execute();
    }

    public static void clear(String string) {
        new Delete().from(RetweenRecord.class).where(" userId = ? ", string).execute();
    }

    public static List<RetweenRecord> findAll(String string) {
        return new Select().distinct().from(RetweenRecord.class).where(" userId = ? ").execute();
    }

    public static boolean isRetweened(String string, String string2) {
        return !new Select().from(RetweenRecord.class).where(" userId = ? and tweetId = ?", string, string2).execute().isEmpty();
    }

    public static void save2DB(String string, String string2) {
        RetweenRecord retweenRecord = new RetweenRecord();
        retweenRecord.setUserId(string);
        retweenRecord.setTweetId(string2);
        retweenRecord.save();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void save2DB(List<RetweenRecord> list) {
        ActiveAndroid.beginTransaction();
        try {
            for (RetweenRecord aList : list) {
                aList.save();
            }
            ActiveAndroid.setTransactionSuccessful();
            return;
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public String getTweetId() {
        return this.tweetId;
    }

    public void setTweetId(String string) {
        this.tweetId = string;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String string) {
        this.userId = string;
    }
}
