package com.clilystudio.quiteread.db;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookDlRecord")
public class BookDlRecord {
    public static final int END = 4;
    public static final int IDLE = 0;
    public static final int PAUSE = 3;
    public static final int PENDING = 1;
    public static final int PREPARE = 5;
    public static final int RUN = 2;
    @Property(nameInDb = "author")
    private String author;
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "bookTitle")
    private String bookTitle;
    @Property(nameInDb = "created")
    private Date created;
    @Property(nameInDb = "mode")
    private int mode = -1;
    @Property(nameInDb = "progress")
    private int progress = 0;
    @Property(nameInDb = "start")
    private int start;
    @Property(nameInDb = "status")
    private int status = 0;
    @Property(nameInDb = "tocId")
    private String tocId;
    @Property(nameInDb = "total")
    private int total;

    @Generated(hash = 1311635543)
    public BookDlRecord(String author, String bookId, String bookTitle, Date created, int mode, int progress, int start, int status,
            String tocId, int total) {
        this.author = author;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.created = created;
        this.mode = mode;
        this.progress = progress;
        this.start = start;
        this.status = status;
        this.tocId = tocId;
        this.total = total;
    }

    @Generated(hash = 371334419)
    public BookDlRecord() {
    }

    public static boolean containsTocInfo(BookDlRecord bookDlRecord) {
        return !TextUtils.isEmpty(bookDlRecord.getBookTitle()) && !TextUtils.isEmpty(bookDlRecord.getBookId());
    }

    public static void create(String string, String string2, String string3, String string4, int n, int n2, int n3, int n4) {
        BookDlRecord bookDlRecord = new BookDlRecord();
        bookDlRecord.bookId = string;
        bookDlRecord.bookTitle = string2;
        bookDlRecord.author = string3;
        bookDlRecord.tocId = string4;
        bookDlRecord.mode = n;
        bookDlRecord.start = n2;
        bookDlRecord.total = n3;
        bookDlRecord.status = n4;
        bookDlRecord.created = new Date();
        bookDlRecord.save();
    }

    public static void delete(String string) {
        new Delete().from(BookDlRecord.class).where("bookId = ?", string).execute();
    }

    public static BookDlRecord get(String string) {
        if (string == null) {
            return null;
        }
        return (BookDlRecord) new Select().from(BookDlRecord.class).where("bookId = ?", string).executeSingle();
    }

    public static BookDlRecord get(String string, int n) {
        if (string == null) {
            return null;
        }
        From from = new Select().from(BookDlRecord.class);
        Object[] arrobject = new Object[]{string, n};
        return (BookDlRecord) from.where("bookId = ? AND mode = ?", arrobject).executeSingle();
    }

    public static List<BookDlRecord> getAll() {
        return new Select().from(BookDlRecord.class).orderBy("created ASC").execute();
    }

    public static List<BookDlRecord> getAllPause() {
        From from = new Select().from(BookDlRecord.class);
        Object[] arrobject = new Object[]{3};
        return from.where("status = ? ", arrobject).execute();
    }

    public static List<BookDlRecord> getAllPending() {
        From from = new Select().from(BookDlRecord.class);
        Object[] arrobject = new Object[]{1};
        return from.where("status = ? ", arrobject).orderBy("created ASC").execute();
    }

    public static List<BookDlRecord> getAllPrepareAsc() {
        From from = new Select().from(BookDlRecord.class);
        Object[] arrobject = new Object[]{5};
        return from.where("status = ? ", arrobject).orderBy("created ASC").execute();
    }

    public static List<BookDlRecord> getAllRun() {
        From from = new Select().from(BookDlRecord.class);
        Object[] arrobject = new Object[]{2};
        return from.where("status = ? ", arrobject).execute();
    }

    public static void reset(BookDlRecord bookDlRecord, int n, int n2) {
        bookDlRecord.start = n;
        bookDlRecord.total = n2;
        bookDlRecord.status = 1;
        bookDlRecord.created = new Date();
        bookDlRecord.save();
    }

    public static void update(BookDlRecord bookDlRecord, String string, int n, int n2, int n3, int n4) {
        bookDlRecord.tocId = string;
        bookDlRecord.mode = n;
        bookDlRecord.start = n2;
        bookDlRecord.total = n3;
        bookDlRecord.status = n4;
        bookDlRecord.created = new Date();
        bookDlRecord.save();
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String string) {
        this.author = string;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String string) {
        this.bookId = string;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void setBookTitle(String string) {
        this.bookTitle = string;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int n) {
        this.progress = n;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int n) {
        this.start = n;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public String getTocId() {
        return this.tocId;
    }

    public void setTocId(String string) {
        this.tocId = string;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int n) {
        this.total = n;
    }
}
