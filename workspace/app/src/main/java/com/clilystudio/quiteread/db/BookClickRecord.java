package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookClickRecords")
public class BookClickRecord {
    @Property(nameInDb = "book_id")
    public String book_id;
    @Property(nameInDb = "today_time")
    public String today_time;
    @Property(nameInDb = "send_status")
    private boolean send_status = false;

    @Generated(hash = 1176830723)
    public BookClickRecord(String book_id, String today_time, boolean send_status) {
        this.book_id = book_id;
        this.today_time = today_time;
        this.send_status = send_status;
    }

    @Generated(hash = 208228909)
    public BookClickRecord() {
    }

    public static BookClickRecord create(String string, String string2, boolean bl) {
        BookClickRecord bookClickRecord = new BookClickRecord();
        bookClickRecord.book_id = string;
        bookClickRecord.today_time = string2;
        bookClickRecord.send_status = bl;
        bookClickRecord.save();
        return bookClickRecord;
    }

    public static void deleteByBookId(String string) {
        if (string == null) {
            return;
        }
        new Delete().from(BookClickRecord.class).where("book_id = ?", string).execute();
    }

    public static List<BookClickRecord> getBookClickRecords(String string) {
        if (string == null) {
            return null;
        }
        return new Select().from(BookClickRecord.class).where("book_id = ?", string).execute();
    }

    public static List<BookClickRecord> getBookClickRecords(String string, String string2) {
        if (string == null || string2 == null) {
            return null;
        }
        return new Select().from(BookClickRecord.class).where("book_id = ? AND today_time = ?", string, string2).execute();
    }

    public boolean isSendStatus() {
        return this.send_status;
    }

    public void setSendStatus(boolean bl) {
        this.send_status = bl;
    }

    public boolean getSend_status() {
        return this.send_status;
    }

    public void setSend_status(boolean send_status) {
        this.send_status = send_status;
    }

    public String getToday_time() {
        return this.today_time;
    }

    public void setToday_time(String today_time) {
        this.today_time = today_time;
    }

    public String getBook_id() {
        return this.book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
