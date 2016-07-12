package com.clilystudio.quiteread.model;

import com.clilystudio.quiteread.db.BookFile;

public class ResponseBookFile {
    private String name;
    private String size;

    public ResponseBookFile(BookFile bookFile) {
        this.size = bookFile.getSize();
        this.name = bookFile.getName();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String string) {
        this.size = string;
    }
}
