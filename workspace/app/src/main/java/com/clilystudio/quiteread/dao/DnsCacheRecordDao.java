package com.clilystudio.quiteread.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.clilystudio.quiteread.db.DnsCacheRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DnsCache".
*/
public class DnsCacheRecordDao extends AbstractDao<DnsCacheRecord, Void> {

    public static final String TABLENAME = "DnsCache";

    /**
     * Properties of entity DnsCacheRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ExpiredTime = new Property(0, java.util.Date.class, "expiredTime", false, "expiredTime");
        public final static Property Host = new Property(1, String.class, "host", false, "host");
        public final static Property Ip = new Property(2, String.class, "ip", false, "ip");
    }


    public DnsCacheRecordDao(DaoConfig config) {
        super(config);
    }
    
    public DnsCacheRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DnsCache\" (" + //
                "\"expiredTime\" INTEGER," + // 0: expiredTime
                "\"host\" TEXT," + // 1: host
                "\"ip\" TEXT);"); // 2: ip
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DnsCache\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DnsCacheRecord entity) {
        stmt.clearBindings();
 
        java.util.Date expiredTime = entity.getExpiredTime();
        if (expiredTime != null) {
            stmt.bindLong(1, expiredTime.getTime());
        }
 
        String host = entity.getHost();
        if (host != null) {
            stmt.bindString(2, host);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(3, ip);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DnsCacheRecord entity) {
        stmt.clearBindings();
 
        java.util.Date expiredTime = entity.getExpiredTime();
        if (expiredTime != null) {
            stmt.bindLong(1, expiredTime.getTime());
        }
 
        String host = entity.getHost();
        if (host != null) {
            stmt.bindString(2, host);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(3, ip);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DnsCacheRecord readEntity(Cursor cursor, int offset) {
        DnsCacheRecord entity = new DnsCacheRecord( //
            cursor.isNull(offset + 0) ? null : new java.util.Date(cursor.getLong(offset + 0)), // expiredTime
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // host
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // ip
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DnsCacheRecord entity, int offset) {
        entity.setExpiredTime(cursor.isNull(offset + 0) ? null : new java.util.Date(cursor.getLong(offset + 0)));
        entity.setHost(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIp(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DnsCacheRecord entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DnsCacheRecord entity) {
        return null;
    }

    @Override
    public boolean hasKey(DnsCacheRecord entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
