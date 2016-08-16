package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "SourceRecord")
public class SourceRecord {
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "sogouMd")
    private String sogouMd;
    @Property(nameInDb = "source")
    private String source;
    @Property(nameInDb = "sourceId")
    private String sourceId;

    @Generated(hash = 517911044)
    public SourceRecord(String bookId, String sogouMd, String source, String sourceId) {
        this.bookId = bookId;
        this.sogouMd = sogouMd;
        this.source = source;
        this.sourceId = sourceId;
    }

    @Generated(hash = 98267261)
    public SourceRecord() {
    }

    public static void create(String string, String string2, String string3) {
        SourceRecord sourceRecord = new SourceRecord();
        sourceRecord.bookId = string;
        sourceRecord.source = string2;
        sourceRecord.sourceId = string3;
        sourceRecord.save();
    }

    public static void create(String string, String string2, String string3, String string4) {
        SourceRecord sourceRecord = new SourceRecord();
        sourceRecord.bookId = string;
        sourceRecord.source = string2;
        sourceRecord.sourceId = string3;
        sourceRecord.sogouMd = string4;
        sourceRecord.save();
    }

    public static void delete(String string) {
        new Delete().from(SourceRecord.class).where("bookId = ?", string).execute();
    }

    public static SourceRecord get(String string, String string2) {
        if (string == null || string2 == null) {
            return null;
        }
        return (SourceRecord) new Select().from(SourceRecord.class).where("bookId = ? AND source = ?", string, string2).executeSingle();
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String string) {
        this.bookId = string;
    }

    public String getSogouMd() {
        return this.sogouMd;
    }

    public void setSogouMd(String string) {
        this.sogouMd = string;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String string) {
        this.source = string;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String string) {
        this.sourceId = string;
    }
}
