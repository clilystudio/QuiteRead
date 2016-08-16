package com.clilystudio.quiteread.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.clilystudio.quiteread.db.BookClickRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BookClickRecords".
*/
public class BookClickRecordDao extends AbstractDao<BookClickRecord, Void> {

    public static final String TABLENAME = "BookClickRecords";

    /**
     * Properties of entity BookClickRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Book_id = new Property(0, String.class, "book_id", false, "book_id");
        public final static Property Today_time = new Property(1, String.class, "today_time", false, "today_time");
        public final static Property Send_status = new Property(2, boolean.class, "send_status", false, "send_status");
    }


    public BookClickRecordDao(DaoConfig config) {
        super(config);
    }
    
    public BookClickRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BookClickRecords\" (" + //
                "\"book_id\" TEXT," + // 0: book_id
                "\"today_time\" TEXT," + // 1: today_time
                "\"send_status\" INTEGER NOT NULL );"); // 2: send_status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BookClickRecords\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BookClickRecord entity) {
        stmt.clearBindings();
 
        String book_id = entity.getBook_id();
        if (book_id != null) {
            stmt.bindString(1, book_id);
        }
 
        String today_time = entity.getToday_time();
        if (today_time != null) {
            stmt.bindString(2, today_time);
        }
        stmt.bindLong(3, entity.getSend_status() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BookClickRecord entity) {
        stmt.clearBindings();
 
        String book_id = entity.getBook_id();
        if (book_id != null) {
            stmt.bindString(1, book_id);
        }
 
        String today_time = entity.getToday_time();
        if (today_time != null) {
            stmt.bindString(2, today_time);
        }
        stmt.bindLong(3, entity.getSend_status() ? 1L: 0L);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public BookClickRecord readEntity(Cursor cursor, int offset) {
        BookClickRecord entity = new BookClickRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // book_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // today_time
            cursor.getShort(offset + 2) != 0 // send_status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BookClickRecord entity, int offset) {
        entity.setBook_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setToday_time(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSend_status(cursor.getShort(offset + 2) != 0);
     }
    
    @Override
    protected final Void updateKeyAfterInsert(BookClickRecord entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(BookClickRecord entity) {
        return null;
    }

    @Override
    public boolean hasKey(BookClickRecord entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
