package com.clilystudio.quiteread.db;


import com.clilystudio.quiteread.model.Account;
import com.clilystudio.quiteread.model.BookGenderRecommend;
import com.clilystudio.quiteread.model.BookInfo;
import com.clilystudio.quiteread.model.RemoteBookShelf;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "BookReadRecords")
public class BookReadRecord {
    @Property(nameInDb = "have_cp")
    public int have_cp;
    @Property(nameInDb = "lastActionTime")
    public long lastActionTime;
    @Property(nameInDb = "readTime")
    public Date readTime;
    @Property(nameInDb = "recommended")
    public boolean recommended;
    @Property(nameInDb = "account")
    private String account;
    @Property(nameInDb = "author")
    private String author;
    @Property(nameInDb = "book_id")
    private String book_id;
    @Property(nameInDb = "chapterCount")
    private int chapterCount;
    @Property(nameInDb = "chapterCountAtFeed")
    private int chapterCountAtFeed;
    @Property(nameInDb = "chapterTitle")
    private String chapterTitle;
    @Property(nameInDb = "cover")
    private String cover;
    @Property(nameInDb = "deleted")
    private boolean deleted = false;
    @Property(nameInDb = "downloadedSource")
    private String downloadedSource;
    @Property(nameInDb = "feedFat")
    private boolean feedFat = false;
    @Property(nameInDb = "feeding")
    private boolean feeding = false;
    @Property(nameInDb = "is_top")
    private boolean is_top = false;
    @Property(nameInDb = "is_unread")
    private boolean is_unread = false;
    @Property(nameInDb = "last_chapter")
    private String last_chapter;
    @Property(nameInDb = "localModifiedDate")
    private Date localModifiedDate;
    @Property(nameInDb = "readMode")
    private int readMode = -1;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "tocIndex")
    private int tocIndex;
    @Property(nameInDb = "toc_id")
    private String toc_id;
    @Property(nameInDb = "updated")
    private Date updated;

    @Generated(hash = 530397691)
    public BookReadRecord(int have_cp, long lastActionTime, Date readTime, boolean recommended, String account, String author,
            String book_id, int chapterCount, int chapterCountAtFeed, String chapterTitle, String cover, boolean deleted,
            String downloadedSource, boolean feedFat, boolean feeding, boolean is_top, boolean is_unread, String last_chapter,
            Date localModifiedDate, int readMode, String title, int tocIndex, String toc_id, Date updated) {
        this.have_cp = have_cp;
        this.lastActionTime = lastActionTime;
        this.readTime = readTime;
        this.recommended = recommended;
        this.account = account;
        this.author = author;
        this.book_id = book_id;
        this.chapterCount = chapterCount;
        this.chapterCountAtFeed = chapterCountAtFeed;
        this.chapterTitle = chapterTitle;
        this.cover = cover;
        this.deleted = deleted;
        this.downloadedSource = downloadedSource;
        this.feedFat = feedFat;
        this.feeding = feeding;
        this.is_top = is_top;
        this.is_unread = is_unread;
        this.last_chapter = last_chapter;
        this.localModifiedDate = localModifiedDate;
        this.readMode = readMode;
        this.title = title;
        this.tocIndex = tocIndex;
        this.toc_id = toc_id;
        this.updated = updated;
    }

    @Generated(hash = 553899228)
    public BookReadRecord() {
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void addAccountInfo(BookReadRecord bookReadRecord) {
        Account account = am.e();
        if (account != null) {
            bookReadRecord.setAccount(account.getUser().getId());
        } else {
            bookReadRecord.setAccount(null);
        }
        bookReadRecord.setLocalModifiedDate(new Date());
        bookReadRecord.save();
    }

    public static void create(BookGenderRecommend.RecommendBook recommendBook) {
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(recommendBook);
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
    }

    public static void create(BookInfo bookInfo) {
        BookReadRecord.trulyDelete(bookInfo.getId());
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(bookInfo);
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
        BusProvider.getInstance().post(new BookAddedEvent(bookReadRecord.getBookId()));
    }

    public static void create(BookInfo bookInfo, String string, int n, int n2, int n3) {
        String string2 = bookInfo.getId();
        BookReadRecord.trulyDelete(string2);
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(bookInfo);
        bookReadRecord.toc_id = string;
        bookReadRecord.readMode = n3;
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
        MixTocRecord.create(string2, string, n, n2);
        BusProvider.getInstance().post(new BookAddedEvent(string2));
    }

    public static void create(BookInfo bookInfo, String string, String string2, String string3, int n, int n2, int n3) {
        String string4 = bookInfo.getId();
        BookReadRecord.trulyDelete(string4);
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(bookInfo);
        bookReadRecord.toc_id = string;
        bookReadRecord.readMode = n3;
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
        TocReadRecord.create(string4, string, string2, string3, n, n2);
        BusProvider.getInstance().post(new BookAddedEvent(string4));
    }

    public static void create(RemoteBookShelf.Book book, boolean bl) {
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(book);
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
    }

    private static BookReadRecord createBookRecord(BookGenderRecommend.RecommendBook recommendBook) {
        BookReadRecord bookReadRecord = new BookReadRecord();
        bookReadRecord.book_id = recommendBook.get_id();
        bookReadRecord.setTitle(recommendBook.getTitle());
        bookReadRecord.setCover(recommendBook.getCover());
        bookReadRecord.last_chapter = recommendBook.getLastChapter();
        bookReadRecord.setUpdated(recommendBook.getUpdated());
        bookReadRecord.setChapterCount(recommendBook.getChaptersCount());
        bookReadRecord.setAuthor(recommendBook.getAuthor());
        bookReadRecord.setRecommended(true);
        return bookReadRecord;
    }

    private static BookReadRecord createBookRecord(BookInfo bookInfo) {
        BookReadRecord bookReadRecord = new BookReadRecord();
        bookReadRecord.book_id = bookInfo.getId();
        bookReadRecord.setTitle(bookInfo.getTitle());
        bookReadRecord.setCover(bookInfo.getCover());
        bookReadRecord.last_chapter = bookInfo.getLastChapter();
        bookReadRecord.setUpdated(bookInfo.getUpdated());
        bookReadRecord.setChapterCount(bookInfo.getChaptersCount());
        bookReadRecord.setAuthor(bookInfo.getAuthor());
        if (bookInfo.isHasCp()) {
            bookReadRecord.setHave_cp(1);
            return bookReadRecord;
        }
        bookReadRecord.setHave_cp(2);
        return bookReadRecord;
    }

    private static BookReadRecord createBookRecord(RemoteBookShelf.Book book) {
        BookReadRecord bookReadRecord = new BookReadRecord();
        bookReadRecord.book_id = book.getId();
        bookReadRecord.setTitle(book.getTitle());
        bookReadRecord.setCover(book.getCover());
        bookReadRecord.last_chapter = book.getLastChapter();
        bookReadRecord.setUpdated(book.getUpdated());
        bookReadRecord.setChapterCount(book.getChaptersCount());
        bookReadRecord.setAuthor(book.getAuthor());
        if (book.isHasCp()) {
            bookReadRecord.setHave_cp(1);
            bookReadRecord.setReadMode(9);
            return bookReadRecord;
        }
        bookReadRecord.setHave_cp(2);
        return bookReadRecord;
    }

    public static void createFeed(RemoteBookShelf.Book book) {
        BookReadRecord bookReadRecord = BookReadRecord.createBookRecord(book);
        bookReadRecord.setFeeding(true);
        bookReadRecord.setChapterCountAtFeed(book.getChaptersCount());
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
    }

    public static void delete(BookReadRecord bookReadRecord) {
        if (bookReadRecord == null) {
            return;
        }
        bookReadRecord.setDeleted(true);
        bookReadRecord.setFeeding(false);
        bookReadRecord.setFeedFat(false);
        BookReadRecord.addAccountInfo(bookReadRecord);
        bookReadRecord.save();
        String string = bookReadRecord.getBookId();
        BookReadRecord.deleteTocRecord(string);
        BookReadRecord.deleteModeRecord(string);
        BookReadRecord.deleteDlRecord(string);
    }

    public static void delete(String string) {
        BookReadRecord.delete(BookReadRecord.get(string));
    }

    public static void deleteAndSync(String string) {
        BookReadRecord.delete(string);
        BusProvider.getInstance().post(new BookRemovedEvent(string));
    }

    private static void deleteDlRecord(String string) {
        BookDlRecord.delete(string);
    }

    private static void deleteModeRecord(String string) {
        SourceRecord.delete(string);
    }

    private static void deleteTocRecord(String string) {
        TocReadRecord.deleteByBookId(string);
        MixTocRecord.deleteByBookId(string);
    }

    public static BookReadRecord get(String string) {
        if (string == null) {
            return null;
        }
        return (BookReadRecord) new Select().from(BookReadRecord.class).where("book_id = ?", string).executeSingle();
    }

    public static List<BookReadRecord> getAll() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0};
        return from.where("deleted = ?", arrobject).execute();
    }

    public static List<BookReadRecord> getAllFeedFat() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{1, 1};
        return from.where("feeding = ? AND feedFat = ?", arrobject).execute();
    }

    public static List<BookReadRecord> getAllFeeding() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{1};
        return from.where("feeding = ? ", arrobject).execute();
    }

    public static List<BookReadRecord> getAllFeedingOrderByCount() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{1};
        return from.where("feeding = ? ", arrobject).orderBy("(chapterCount - chapterCountAtFeed) DESC").execute();
    }

    public static List<BookReadRecord> getAllNoFeed() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0, 0};
        return from.where("deleted = ? AND feeding = ?", arrobject).execute();
    }

    public static List<BookReadRecord> getAllNotDeleted() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0};
        return from.where("deleted = ?", arrobject).orderBy("is_top DESC,readTime DESC").execute();
    }

    public static List<BookReadRecord> getAllWithDelNoFeed() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0};
        return from.where("feeding = ?", arrobject).execute();
    }

    public static List<BookReadRecord> getAllWithTopNoFeed() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0, 0};
        return from.where("deleted = ? AND feeding = ?", arrobject).orderBy("is_top DESC,updated DESC").execute();
    }

    public static List<BookReadRecord> getAllWithTopNoFeedByRead() {
        From from = new Select().from(BookReadRecord.class);
        Object[] arrobject = new Object[]{0, 0};
        return from.where("deleted = ? AND feeding = ?", arrobject).orderBy("is_top DESC,readTime DESC").execute();
    }

    public static BookReadRecord getOnShelf(String string) {
        if (string == null) {
            return null;
        }
        return (BookReadRecord) new Select().from(BookReadRecord.class).where("book_id = ? AND deleted = 0", string).executeSingle();
    }

    public static void trulyDelete(String string) {
        new Delete().from(BookReadRecord.class).where("book_id = ?", string).execute();
    }

    public String buildDesc() {
        Object[] arrobject = new Object[]{t.e(this.getUpdated()), this.last_chapter};
        return String.format("%s:%s", arrobject);
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String string) {
        this.account = string;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String string) {
        this.author = string;
    }

    public String getBookId() {
        return this.book_id;
    }

    public void setBookId(String string) {
        this.book_id = string;
    }

    public int getChapterCount() {
        return this.chapterCount;
    }

    public void setChapterCount(int n) {
        this.chapterCount = n;
    }

    public int getChapterCountAtFeed() {
        return this.chapterCountAtFeed;
    }

    public void setChapterCountAtFeed(int n) {
        this.chapterCountAtFeed = n;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public void setChapterTitle(String string) {
        this.chapterTitle = string;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String string) {
        this.cover = string;
    }

    public String getDownloadedSource() {
        return this.downloadedSource;
    }

    public void setDownloadedSource(String string) {
        this.downloadedSource = string;
    }

    public String getFullCover() {
        return ApiService.a + this.getCover() + "-covers";
    }

    public int getHave_cp() {
        return this.have_cp;
    }

    public void setHave_cp(int n) {
        this.have_cp = n;
    }

    public long getLastActionTime() {
        return this.lastActionTime;
    }

    public void setLastActionTime(long l) {
        this.lastActionTime = l;
    }

    public String getLastChapter() {
        return this.last_chapter;
    }

    public void setLastChapter(String string) {
        this.last_chapter = string;
    }

    public Date getLocalModifiedDate() {
        if (this.localModifiedDate == null) {
            return new Date(0);
        }
        return this.localModifiedDate;
    }

    public void setLocalModifiedDate(Date date) {
        this.localModifiedDate = date;
    }

    public int getReadMode() {
        return this.readMode;
    }

    public void setReadMode(int n) {
        this.readMode = n;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getTocId() {
        return this.toc_id;
    }

    public void setTocId(String string) {
        this.toc_id = string;
    }

    public int getTocIndex() {
        return this.tocIndex;
    }

    public void setTocIndex(int n) {
        this.tocIndex = n;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date date) {
        this.updated = date;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean bl) {
        this.deleted = bl;
    }

    public boolean isFeedFat() {
        return this.feedFat;
    }

    public void setFeedFat(boolean bl) {
        this.feedFat = bl;
    }

    public boolean isFeeding() {
        return this.feeding;
    }

    public void setFeeding(boolean bl) {
        this.feeding = bl;
    }

    public boolean isRecommended() {
        return this.recommended;
    }

    public void setRecommended(boolean bl) {
        this.recommended = bl;
    }

    public boolean isTop() {
        return this.is_top;
    }

    public void setTop(boolean bl) {
        this.is_top = bl;
    }

    public boolean isUnread() {
        return this.is_unread;
    }

    public void setUnread(boolean bl) {
        this.is_unread = bl;
    }

    public String getToc_id() {
        return this.toc_id;
    }

    public void setToc_id(String toc_id) {
        this.toc_id = toc_id;
    }

    public String getLast_chapter() {
        return this.last_chapter;
    }

    public void setLast_chapter(String last_chapter) {
        this.last_chapter = last_chapter;
    }

    public boolean getIs_unread() {
        return this.is_unread;
    }

    public void setIs_unread(boolean is_unread) {
        this.is_unread = is_unread;
    }

    public boolean getIs_top() {
        return this.is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public boolean getFeeding() {
        return this.feeding;
    }

    public boolean getFeedFat() {
        return this.feedFat;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public String getBook_id() {
        return this.book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public boolean getRecommended() {
        return this.recommended;
    }

    public Date getReadTime() {
        return this.readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}
