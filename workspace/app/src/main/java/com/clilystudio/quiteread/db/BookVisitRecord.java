package com.clilystudio.quiteread.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookVisitRecord")
public class BookVisitRecord {
    @Property(nameInDb = "bookId")
    private String bookId;
    @Property(nameInDb = "hasGroup")
    private boolean hasGroup;

    public BookVisitRecord() {
    }

    public BookVisitRecord(String string) {
        this.bookId = string;
    }

    @Generated(hash = 2140646535)
    public BookVisitRecord(String bookId, boolean hasGroup) {
        this.bookId = bookId;
        this.hasGroup = hasGroup;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String string) {
        this.bookId = string;
    }

    public boolean hasGroup() {
        return this.hasGroup;
    }

    public void setHasGroup(boolean bl) {
        this.hasGroup = bl;
    }

    public boolean getHasGroup() {
        return this.hasGroup;
    }
}
