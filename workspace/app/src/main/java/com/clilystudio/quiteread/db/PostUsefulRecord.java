package com.clilystudio.quiteread.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "PostUsefulRecord")
public class PostUsefulRecord {
    public static final int TYPE_NO = 2;
    public static final int TYPE_YES = 1;
    @Property(nameInDb = "postId")
    public String postId;
    @Property(nameInDb = "type")
    public int type = 0;
    @Property(nameInDb = "userId")
    public String userId;

    @Generated(hash = 1589520116)
    public PostUsefulRecord(String postId, int type, String userId) {
        this.postId = postId;
        this.type = type;
        this.userId = userId;
    }

    @Generated(hash = 168406968)
    public PostUsefulRecord() {
    }

    public static void create(String string, String string2, int n) {
        PostUsefulRecord postUsefulRecord = new PostUsefulRecord();
        postUsefulRecord.userId = string;
        postUsefulRecord.postId = string2;
        postUsefulRecord.type = n;
        postUsefulRecord.save();
    }

    public static PostUsefulRecord get(String string, String string2) {
        List list = new Select().from(PostUsefulRecord.class).where("userId = ? AND postId = ?", string, string2).execute();
        if (list != null && list.size() > 0) {
            return (PostUsefulRecord) list.get(0);
        }
        return null;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
