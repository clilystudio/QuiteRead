package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "PostAgreeRecord")
public class PostAgreeRecord {
    @Property(nameInDb = "account_id")
    public String account_id;
    @Property(nameInDb = "post_id")
    public String post_id;

    @Generated(hash = 1540310366)
    public PostAgreeRecord(String account_id, String post_id) {
        this.account_id = account_id;
        this.post_id = post_id;
    }

    @Generated(hash = 1850193439)
    public PostAgreeRecord() {
    }

    public static void add(String string, String string2) {
        PostAgreeRecord postAgreeRecord = new PostAgreeRecord();
        postAgreeRecord.account_id = string;
        postAgreeRecord.post_id = string2;
        postAgreeRecord.save();
    }

    public static PostAgreeRecord get(String string, String string2) {
        List list = new Select().from(PostAgreeRecord.class).where("account_id = ? AND post_id = ?", string, string2).execute();
        if (list != null && list.size() > 0) {
            return (PostAgreeRecord) list.get(0);
        }
        return null;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getAccount_id() {
        return this.account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
}
