package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "DnsCache")
public class DnsCacheRecord {
    @Property(nameInDb = "expiredTime")
    private Date expiredTime;
    @Property(nameInDb = "host")
    private String host;
    @Property(nameInDb = "ip")
    private String ip;

    @Generated(hash = 464109939)
    public DnsCacheRecord(Date expiredTime, String host, String ip) {
        this.expiredTime = expiredTime;
        this.host = host;
        this.ip = ip;
    }

    @Generated(hash = 996945023)
    public DnsCacheRecord() {
    }

    public Date getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(Date date) {
        this.expiredTime = date;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String string) {
        this.host = string;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String string) {
        this.ip = string;
    }

    public boolean isExpired() {
        return new Date().getTime() > this.expiredTime.getTime();
    }
}
