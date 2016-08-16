package com.clilystudio.quiteread.db;

import com.clilystudio.quiteread.am;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.clilystudio.quiteread.model.Account;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "SyncAccount")
public class SyncAccount {
    @Property(nameInDb = "uid")
    public String uid;
    @Property(nameInDb = "update_time")
    public Date updateTime;

    @Generated(hash = 1087905127)
    public SyncAccount(String uid, Date updateTime) {
        this.uid = uid;
        this.updateTime = updateTime;
    }

    @Generated(hash = 317931897)
    public SyncAccount() {
    }

    public static boolean needSync(Date date) {
        if (date == null) {
            return false;
        }
        Account account = am.e();
        if (account == null) {
            return false;
        }
        String string = account.getUser().getId();
        List list = new Select().from(SyncAccount.class).where("uid = ?", string).execute();
        return list.isEmpty() || ((SyncAccount) list.get(0)).updateTime.getTime() < date.getTime();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void save(Date date) {
        SyncAccount syncAccount;
        Account account = am.e();
        if (account == null) {
            return;
        }
        String string = account.getUser().getId();
        List list = new Select().from(SyncAccount.class).where("uid = ?", string).execute();
        if (list.isEmpty()) {
            syncAccount = new SyncAccount();
            syncAccount.uid = string;
        } else {
            syncAccount = (SyncAccount) list.get(0);
        }
        syncAccount.updateTime = date;
        syncAccount.save();
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
