package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "MixTocRecords")
public class MixTocRecord {
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "chapterIndex")
    private int chapterIndex = -1;
    @Property(nameInDb = "chapterTitle")
    private String chapterTitle;
    @Property(nameInDb = "charIndex")
    private int charIndex = 0;
    @Property(nameInDb = "tocId")
    private String tocId;

    @Generated(hash = 608302737)
    public MixTocRecord(String bookId, int chapterIndex, String chapterTitle, int charIndex, String tocId) {
        this.bookId = bookId;
        this.chapterIndex = chapterIndex;
        this.chapterTitle = chapterTitle;
        this.charIndex = charIndex;
        this.tocId = tocId;
    }

    @Generated(hash = 1860680071)
    public MixTocRecord() {
    }

    public static MixTocRecord create(String string, String string2, int n, int n2) {
        MixTocRecord mixTocRecord = new MixTocRecord();
        mixTocRecord.setBookId(string);
        mixTocRecord.setTocId(string2);
        mixTocRecord.setChapterIndex(n);
        mixTocRecord.setCharIndex(n2);
        mixTocRecord.save();
        return mixTocRecord;
    }

    public static void deleteByBookId(String string) {
        new Delete().from(MixTocRecord.class).where("bookId = ?", string).execute();
    }

    public static MixTocRecord get(String string) {
        if (string == null) {
            return null;
        }
        return (MixTocRecord) new Select().from(MixTocRecord.class).where("tocId = ?", string).executeSingle();
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

    public int getCharIndex() {
        return this.charIndex;
    }

    public void setCharIndex(int n) {
        this.charIndex = n;
    }

    public String getTocId() {
        return this.tocId;
    }

    public void setTocId(String string) {
        this.tocId = string;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }
}
