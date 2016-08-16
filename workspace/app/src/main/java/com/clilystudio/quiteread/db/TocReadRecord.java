package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "TocReadRecords")
public class TocReadRecord {
    @Property(nameInDb = "book_id")
    private String book_id;
    @Property(nameInDb = "chapter_num")
    private int chapter_num = -1;
    @Property(nameInDb = "chapter_title")
    private String chapter_title;
    @Property(nameInDb = "character_num")
    private int character_num = 0;
    @Property(nameInDb = "toc_id")
    private String toc_id;
    @Property(nameInDb = "toc_name")
    private String toc_name;

    @Generated(hash = 2006785598)
    public TocReadRecord(String book_id, int chapter_num, String chapter_title, int character_num, String toc_id,
            String toc_name) {
        this.book_id = book_id;
        this.chapter_num = chapter_num;
        this.chapter_title = chapter_title;
        this.character_num = character_num;
        this.toc_id = toc_id;
        this.toc_name = toc_name;
    }

    @Generated(hash = 606789150)
    public TocReadRecord() {
    }

    public static void create(String string, String string2, String string3, String string4, int n, int n2) {
        TocReadRecord tocReadRecord = new TocReadRecord();
        tocReadRecord.book_id = string;
        tocReadRecord.toc_id = string2;
        tocReadRecord.toc_name = string3;
        tocReadRecord.chapter_title = string4;
        tocReadRecord.chapter_num = n;
        tocReadRecord.character_num = n2;
        tocReadRecord.save();
    }

    public static void deleteByBookId(String string) {
        new Delete().from(TocReadRecord.class).where("book_id = ?", string).execute();
    }

    public static TocReadRecord get(String string) {
        if (string == null) {
            return null;
        }
        return (TocReadRecord) new Select().from(TocReadRecord.class).where("toc_id = ?", string).executeSingle();
    }

    public String getBookId() {
        return this.book_id;
    }

    public void setBookId(String string) {
        this.book_id = string;
    }

    public int getChapterIndex() {
        return this.chapter_num;
    }

    public void setChapterIndex(int n) {
        this.chapter_num = n;
    }

    public String getChapterTitle() {
        return this.chapter_title;
    }

    public void setChapterTitle(String string) {
        this.chapter_title = string;
    }

    public int getCharIndex() {
        return this.character_num;
    }

    public void setCharIndex(int n) {
        this.character_num = n;
    }

    public String getHost() {
        return this.toc_name;
    }

    public void setHost(String string) {
        this.toc_name = string;
    }

    public String getTocId() {
        return this.toc_id;
    }

    public void setTocId(String string) {
        this.toc_id = string;
    }

    public String getToc_name() {
        return this.toc_name;
    }

    public void setToc_name(String toc_name) {
        this.toc_name = toc_name;
    }

    public String getToc_id() {
        return this.toc_id;
    }

    public void setToc_id(String toc_id) {
        this.toc_id = toc_id;
    }

    public int getCharacter_num() {
        return this.character_num;
    }

    public void setCharacter_num(int character_num) {
        this.character_num = character_num;
    }

    public String getChapter_title() {
        return this.chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public int getChapter_num() {
        return this.chapter_num;
    }

    public void setChapter_num(int chapter_num) {
        this.chapter_num = chapter_num;
    }

    public String getBook_id() {
        return this.book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
