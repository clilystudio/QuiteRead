package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookSyncRecord")
public class BookSyncRecord {
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "type")
    private int type;
    @Property(nameInDb = "updated")
    private Date updated;
    @Property(nameInDb = "userId")
    private String userId;

    @Generated(hash = 666093854)
    public BookSyncRecord(String bookId, int type, Date updated, String userId) {
        this.bookId = bookId;
        this.type = type;
        this.updated = updated;
        this.userId = userId;
    }

    @Generated(hash = 1971690400)
    public BookSyncRecord() {
    }

    public static void create(String string, String string2, int n) {
        BookSyncRecord bookSyncRecord = new BookSyncRecord();
        bookSyncRecord.setUserId(string);
        bookSyncRecord.setType(n);
        bookSyncRecord.setBookId(string2);
        bookSyncRecord.setUpdated(new Date());
        bookSyncRecord.save();
    }

    public static List<BookSyncRecord> find(String string, int n) {
        From from = new Select().from(BookSyncRecord.class);
        Object[] arrobject = new Object[]{string, n};
        return from.where("( userId = ? or userId = \"\" ) and type = ? ", arrobject).orderBy(" id ").execute();
    }

    public static BookSyncRecord get(String string) {
        if (string == null) {
            return null;
        }
        return (BookSyncRecord) new Select().from(BookSyncRecord.class).where("bookId = ?", string).executeSingle();
    }

    public static int getTypeId(BookModifyType bookModifyType) {
        return bookModifyType.ordinal() + 1;
    }

    public static void updateOrCreate(String string, String string2, int n) {
        List<BookSyncRecord> list = new Select().from(BookSyncRecord.class).where(" bookId = ? ", string2).execute();
        if (list != null && list.size() > 0) {
            for (BookSyncRecord bookSyncRecord : list) {
                bookSyncRecord.setUserId(string);
                bookSyncRecord.setType(n);
                bookSyncRecord.setUpdated(new Date());
                bookSyncRecord.save();
            }
        } else {
            BookSyncRecord.create(string, string2, n);
        }
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String string) {
        this.bookId = string;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date date) {
        this.updated = date;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String string) {
        this.userId = string;
    }

    public enum BookModifyType {
        SHELF_ADD, SHELF_REMOVE, FEED_ADD, FEED_REMOVE, SYNC_SUCCESS
    }

}
