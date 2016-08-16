package com.clilystudio.quiteread.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.clilystudio.quiteread.db.PostAgreeRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PostAgreeRecord".
*/
public class PostAgreeRecordDao extends AbstractDao<PostAgreeRecord, Void> {

    public static final String TABLENAME = "PostAgreeRecord";

    /**
     * Properties of entity PostAgreeRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Account_id = new Property(0, String.class, "account_id", false, "account_id");
        public final static Property Post_id = new Property(1, String.class, "post_id", false, "post_id");
    }


    public PostAgreeRecordDao(DaoConfig config) {
        super(config);
    }
    
    public PostAgreeRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PostAgreeRecord\" (" + //
                "\"account_id\" TEXT," + // 0: account_id
                "\"post_id\" TEXT);"); // 1: post_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PostAgreeRecord\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PostAgreeRecord entity) {
        stmt.clearBindings();
 
        String account_id = entity.getAccount_id();
        if (account_id != null) {
            stmt.bindString(1, account_id);
        }
 
        String post_id = entity.getPost_id();
        if (post_id != null) {
            stmt.bindString(2, post_id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PostAgreeRecord entity) {
        stmt.clearBindings();
 
        String account_id = entity.getAccount_id();
        if (account_id != null) {
            stmt.bindString(1, account_id);
        }
 
        String post_id = entity.getPost_id();
        if (post_id != null) {
            stmt.bindString(2, post_id);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public PostAgreeRecord readEntity(Cursor cursor, int offset) {
        PostAgreeRecord entity = new PostAgreeRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // account_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // post_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PostAgreeRecord entity, int offset) {
        entity.setAccount_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPost_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(PostAgreeRecord entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(PostAgreeRecord entity) {
        return null;
    }

    @Override
    public boolean hasKey(PostAgreeRecord entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
