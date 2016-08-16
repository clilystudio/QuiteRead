package com.clilystudio.quiteread.db;

import com.clilystudio.quiteread.util.StringUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.io.File;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookFile")
public class BookFile {
    @Property(nameInDb = "file_path")
    public String filePath;
    @Property(nameInDb = "name")
    public String name;
    @Property(nameInDb = "progress")
    public float progress;
    @Property(nameInDb = "progress_chapter_index")
    public int progressChapterIndex;
    @Property(nameInDb = "progress_char_offset")
    public int progressCharOffset;
    @Property(nameInDb = "size")
    public String size;
    @Property(nameInDb = "top")
    public boolean top;
    @Property(nameInDb = "updated")
    public Date updated;

    public BookFile() {
    }

    public BookFile(File file) {
        this.name = file.getName();
        this.size = StringUtils.formatFileSize(file.length());
        this.filePath = file.getPath();
    }

    @Generated(hash = 1315109083)
    public BookFile(String filePath, String name, float progress,
            int progressChapterIndex, int progressCharOffset, String size,
            boolean top, Date updated) {
        this.filePath = filePath;
        this.name = name;
        this.progress = progress;
        this.progressChapterIndex = progressChapterIndex;
        this.progressCharOffset = progressCharOffset;
        this.size = size;
        this.top = top;
        this.updated = updated;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof BookFile)) {
            return false;
        }
        BookFile bookFile = (BookFile) object;
        return bookFile.name != null && bookFile.name.equals(this.name);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String string) {
        this.filePath = string;
    }

    public int getIntSize() {
        try {
            int n = Integer.parseInt(this.getSize());
            return n;
        } catch (Exception var1_2) {
            return 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getPathAndName() {
        return this.filePath;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float f2) {
        this.progress = f2;
    }

    public int getProgressChapterIndex() {
        return this.progressChapterIndex;
    }

    public void setProgressChapterIndex(int n) {
        this.progressChapterIndex = n;
    }

    public int getProgressCharOffset() {
        return this.progressCharOffset;
    }

    public void setProgressCharOffset(int n) {
        this.progressCharOffset = n;
    }

    public String getReadableProgress() {
        if (this.progress == 0.0f) {
            return "0%";
        }
        int n = (int) (100.0f * this.progress);
        if (n == 0) {
            n = 1;
        }
        return "" + n + "%";
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String string) {
        this.size = string;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date date) {
        this.updated = date;
    }

    @Override
    public int hashCode() {
        if (this.name != null) {
            return this.name.hashCode();
        }
        return 0;
    }

    public boolean isTop() {
        return this.top;
    }

    public void setTop(boolean bl) {
        this.top = bl;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public boolean getTop() {
        return this.top;
    }
}
