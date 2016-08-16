package com.clilystudio.quiteread.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "VoteRecords")
public class VoteRecord {
    @Property(nameInDb = "account_id")
    public String account_id;
    @Property(nameInDb = "post_id")
    public String post_id;
    @Property(nameInDb = "vote_item_index")
    public int vote_item_index = -1;

    @Generated(hash = 1767793774)
    public VoteRecord(String account_id, String post_id, int vote_item_index) {
        this.account_id = account_id;
        this.post_id = post_id;
        this.vote_item_index = vote_item_index;
    }

    @Generated(hash = 1624182228)
    public VoteRecord() {
    }

    public static void create(String string, String string2, int n) {
        VoteRecord voteRecord = new VoteRecord();
        voteRecord.account_id = string;
        voteRecord.post_id = string2;
        voteRecord.vote_item_index = n;
        voteRecord.save();
    }

    public static List<VoteRecord> getVoteRecords(String string, String string2) {
        return new Select().from(VoteRecord.class).where("account_id = ? AND post_id = ?", string, string2).execute();
    }

    public int getVote_item_index() {
        return this.vote_item_index;
    }

    public void setVote_item_index(int vote_item_index) {
        this.vote_item_index = vote_item_index;
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
