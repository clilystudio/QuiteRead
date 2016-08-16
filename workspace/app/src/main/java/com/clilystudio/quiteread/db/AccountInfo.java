package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "AccountInfo")
public class AccountInfo {
    @Property(nameInDb = "prev_unimp_notif")
    private int prevUnimpNotif;
    @Property(nameInDb = "token")
    private String token;

    public AccountInfo() {
    }

    public AccountInfo(String string, int n) {
        this.token = string;
        this.prevUnimpNotif = n;
    }

    @Generated(hash = 326137279)
    public AccountInfo(int prevUnimpNotif, String token) {
        this.prevUnimpNotif = prevUnimpNotif;
        this.token = token;
    }

    public static AccountInfo getByToken(String string) {
        List list = new Select().from(AccountInfo.class).where("token = ?", string).execute();
        if (list.size() == 0) {
            return null;
        }
        return (AccountInfo) list.get(0);
    }

    public static AccountInfo getOrCreate(String string) {
        AccountInfo accountInfo = AccountInfo.getByToken(string);
        if (accountInfo != null) {
            return accountInfo;
        }
        AccountInfo accountInfo2 = new AccountInfo();
        accountInfo2.setToken(string);
        return accountInfo2;
    }

    public static int getPreUnimpCount(String string) {
        List list = new Select().from(AccountInfo.class).where("token = ?", string).execute();
        if (list.size() == 0) {
            return 0;
        }
        return ((AccountInfo) list.get(0)).getPrevUnimpNotif();
    }

    public int getPrevUnimpNotif() {
        return this.prevUnimpNotif;
    }

    public void setPrevUnimpNotif(int n) {
        this.prevUnimpNotif = n;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string) {
        this.token = string;
    }
}
