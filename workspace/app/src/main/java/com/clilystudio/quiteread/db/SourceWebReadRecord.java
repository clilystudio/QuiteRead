package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "SourceWebReadRecord")
public class SourceWebReadRecord {
    @Property(nameInDb = "_id")
    private String _id;
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "chapterIndex")
    private int chapterIndex;
    @Property(nameInDb = "cmd")
    private String cmd;
    @Property(nameInDb = "readMode")
    private int readMode = -1;

    @Generated(hash = 2050493127)
    public SourceWebReadRecord(String _id, String bookId, int chapterIndex, String cmd, int readMode) {
        this._id = _id;
        this.bookId = bookId;
        this.chapterIndex = chapterIndex;
        this.cmd = cmd;
        this.readMode = readMode;
    }

    @Generated(hash = 635304056)
    public SourceWebReadRecord() {
    }

    public static void create(String string, int n, int n2) {
        SourceWebReadRecord sourceWebReadRecord = new SourceWebReadRecord();
        sourceWebReadRecord.bookId = string;
        sourceWebReadRecord.readMode = n;
        sourceWebReadRecord.chapterIndex = n2;
        sourceWebReadRecord.save();
    }

    public static void create(String string, int n, String string2) {
        SourceWebReadRecord sourceWebReadRecord = new SourceWebReadRecord();
        sourceWebReadRecord.bookId = string;
        sourceWebReadRecord.readMode = n;
        sourceWebReadRecord.cmd = string2;
        sourceWebReadRecord.save();
    }

    public static SourceWebReadRecord get(String string, int n) {
        if (string == null) {
            return null;
        }
        From from = new Select().from(SourceWebReadRecord.class);
        Object[] arrobject = new Object[]{string, n};
        return (SourceWebReadRecord) from.where("(bookId = ?) AND (readMode = ?)", arrobject).executeSingle();
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String string) {
        this.bookId = string;
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public void setChapterIndex(int n) {
        this.chapterIndex = n;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String string) {
        this.cmd = string;
    }

    public int getReadMode() {
        return this.readMode;
    }

    public void setReadMode(int n) {
        this.readMode = n;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
