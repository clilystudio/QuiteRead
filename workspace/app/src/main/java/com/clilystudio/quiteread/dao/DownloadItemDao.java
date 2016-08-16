package com.clilystudio.quiteread.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.clilystudio.quiteread.db.DownloadItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DownloadItem".
*/
public class DownloadItemDao extends AbstractDao<DownloadItem, Void> {

    public static final String TABLENAME = "DownloadItem";

    /**
     * Properties of entity DownloadItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PackageName = new Property(0, String.class, "packageName", false, "package_name");
        public final static Property Uid = new Property(1, String.class, "uid", false, "uid");
    }


    public DownloadItemDao(DaoConfig config) {
        super(config);
    }
    
    public DownloadItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DownloadItem\" (" + //
                "\"package_name\" TEXT," + // 0: packageName
                "\"uid\" TEXT);"); // 1: uid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DownloadItem\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DownloadItem entity) {
        stmt.clearBindings();
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(1, packageName);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(2, uid);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DownloadItem entity) {
        stmt.clearBindings();
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(1, packageName);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(2, uid);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DownloadItem readEntity(Cursor cursor, int offset) {
        DownloadItem entity = new DownloadItem( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // packageName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // uid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DownloadItem entity, int offset) {
        entity.setPackageName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DownloadItem entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DownloadItem entity) {
        return null;
    }

    @Override
    public boolean hasKey(DownloadItem entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}