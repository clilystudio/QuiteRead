package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "TweetCache")
public class TweetCache {
    public static final String HOT_USER_ID = "zhuishushenqi_hot_user_id";
    public static final int TYPE_HOT = 2;
    public static final int TYPE_MY = 3;
    public static final int TYPE_TIMELINE = 1;
    @Property(nameInDb = "content")
    private String content;
    @Property(nameInDb = "type")
    private int type;
    @Property(nameInDb = "userId")
    private String userId;

    @Generated(hash = 869996053)
    public TweetCache(String content, int type, String userId) {
        this.content = content;
        this.type = type;
        this.userId = userId;
    }

    @Generated(hash = 2102072745)
    public TweetCache() {
    }

    public static void clear(String string) {
        new Delete().from(TweetCache.class).where(" userId = ? ", string).execute();
    }

    public static void delete(String string, int n) {
        From from = new Delete().from(TweetCache.class);
        Object[] arrobject = new Object[]{string, n};
        from.where(" userId = ? and type = ?", arrobject).execute();
    }

    public static List<TweetCache> find(String string, int n) {
        From from = new Select().from(TweetCache.class);
        Object[] arrobject = new Object[]{string, n};
        return from.where(" userId = ? and type = ? ", arrobject).orderBy(" id ").execute();
    }

    public static void save2DB(String string, int n, String string2) {
        TweetCache tweetCache = new TweetCache();
        tweetCache.setUserId(string);
        tweetCache.setType(n);
        tweetCache.setContent(string2);
        tweetCache.save();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String string) {
        this.userId = string;
    }
}
