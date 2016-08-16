package com.clilystudio.quiteread.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.clilystudio.quiteread.db.AccountInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "AccountInfo".
*/
public class AccountInfoDao extends AbstractDao<AccountInfo, Void> {

    public static final String TABLENAME = "AccountInfo";

    /**
     * Properties of entity AccountInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PrevUnimpNotif = new Property(0, int.class, "prevUnimpNotif", false, "prev_unimp_notif");
        public final static Property Token = new Property(1, String.class, "token", false, "token");
    }


    public AccountInfoDao(DaoConfig config) {
        super(config);
    }
    
    public AccountInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AccountInfo\" (" + //
                "\"prev_unimp_notif\" INTEGER NOT NULL ," + // 0: prevUnimpNotif
                "\"token\" TEXT);"); // 1: token
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AccountInfo\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AccountInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPrevUnimpNotif());
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(2, token);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AccountInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPrevUnimpNotif());
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(2, token);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public AccountInfo readEntity(Cursor cursor, int offset) {
        AccountInfo entity = new AccountInfo( //
            cursor.getInt(offset + 0), // prevUnimpNotif
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // token
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AccountInfo entity, int offset) {
        entity.setPrevUnimpNotif(cursor.getInt(offset + 0));
        entity.setToken(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(AccountInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(AccountInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(AccountInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
