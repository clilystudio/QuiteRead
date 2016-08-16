package com.clilystudio.quiteread.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.clilystudio.quiteread.db.RetweenRecord;
import com.clilystudio.quiteread.db.TocReadRecord;
import com.clilystudio.quiteread.db.BookSyncRecord;
import com.clilystudio.quiteread.db.BookVisitRecord;
import com.clilystudio.quiteread.db.MixTocRecord;
import com.clilystudio.quiteread.db.BookTopicEnterRecord;
import com.clilystudio.quiteread.db.BookDlRecord;
import com.clilystudio.quiteread.db.BookClickRecord;
import com.clilystudio.quiteread.db.PostUsefulRecord;
import com.clilystudio.quiteread.db.SourceWebReadRecord;
import com.clilystudio.quiteread.db.SyncAccount;
import com.clilystudio.quiteread.db.TweetCache;
import com.clilystudio.quiteread.db.DownloadItem;
import com.clilystudio.quiteread.db.VoteRecord;
import com.clilystudio.quiteread.db.BookReadRecord;
import com.clilystudio.quiteread.db.SourceRecord;
import com.clilystudio.quiteread.db.DnsCacheRecord;
import com.clilystudio.quiteread.db.PostAgreeRecord;
import com.clilystudio.quiteread.db.BookFile;
import com.clilystudio.quiteread.db.AccountInfo;

import com.clilystudio.quiteread.dao.RetweenRecordDao;
import com.clilystudio.quiteread.dao.TocReadRecordDao;
import com.clilystudio.quiteread.dao.BookSyncRecordDao;
import com.clilystudio.quiteread.dao.BookVisitRecordDao;
import com.clilystudio.quiteread.dao.MixTocRecordDao;
import com.clilystudio.quiteread.dao.BookTopicEnterRecordDao;
import com.clilystudio.quiteread.dao.BookDlRecordDao;
import com.clilystudio.quiteread.dao.BookClickRecordDao;
import com.clilystudio.quiteread.dao.PostUsefulRecordDao;
import com.clilystudio.quiteread.dao.SourceWebReadRecordDao;
import com.clilystudio.quiteread.dao.SyncAccountDao;
import com.clilystudio.quiteread.dao.TweetCacheDao;
import com.clilystudio.quiteread.dao.DownloadItemDao;
import com.clilystudio.quiteread.dao.VoteRecordDao;
import com.clilystudio.quiteread.dao.BookReadRecordDao;
import com.clilystudio.quiteread.dao.SourceRecordDao;
import com.clilystudio.quiteread.dao.DnsCacheRecordDao;
import com.clilystudio.quiteread.dao.PostAgreeRecordDao;
import com.clilystudio.quiteread.dao.BookFileDao;
import com.clilystudio.quiteread.dao.AccountInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig retweenRecordDaoConfig;
    private final DaoConfig tocReadRecordDaoConfig;
    private final DaoConfig bookSyncRecordDaoConfig;
    private final DaoConfig bookVisitRecordDaoConfig;
    private final DaoConfig mixTocRecordDaoConfig;
    private final DaoConfig bookTopicEnterRecordDaoConfig;
    private final DaoConfig bookDlRecordDaoConfig;
    private final DaoConfig bookClickRecordDaoConfig;
    private final DaoConfig postUsefulRecordDaoConfig;
    private final DaoConfig sourceWebReadRecordDaoConfig;
    private final DaoConfig syncAccountDaoConfig;
    private final DaoConfig tweetCacheDaoConfig;
    private final DaoConfig downloadItemDaoConfig;
    private final DaoConfig voteRecordDaoConfig;
    private final DaoConfig bookReadRecordDaoConfig;
    private final DaoConfig sourceRecordDaoConfig;
    private final DaoConfig dnsCacheRecordDaoConfig;
    private final DaoConfig postAgreeRecordDaoConfig;
    private final DaoConfig bookFileDaoConfig;
    private final DaoConfig accountInfoDaoConfig;

    private final RetweenRecordDao retweenRecordDao;
    private final TocReadRecordDao tocReadRecordDao;
    private final BookSyncRecordDao bookSyncRecordDao;
    private final BookVisitRecordDao bookVisitRecordDao;
    private final MixTocRecordDao mixTocRecordDao;
    private final BookTopicEnterRecordDao bookTopicEnterRecordDao;
    private final BookDlRecordDao bookDlRecordDao;
    private final BookClickRecordDao bookClickRecordDao;
    private final PostUsefulRecordDao postUsefulRecordDao;
    private final SourceWebReadRecordDao sourceWebReadRecordDao;
    private final SyncAccountDao syncAccountDao;
    private final TweetCacheDao tweetCacheDao;
    private final DownloadItemDao downloadItemDao;
    private final VoteRecordDao voteRecordDao;
    private final BookReadRecordDao bookReadRecordDao;
    private final SourceRecordDao sourceRecordDao;
    private final DnsCacheRecordDao dnsCacheRecordDao;
    private final PostAgreeRecordDao postAgreeRecordDao;
    private final BookFileDao bookFileDao;
    private final AccountInfoDao accountInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        retweenRecordDaoConfig = daoConfigMap.get(RetweenRecordDao.class).clone();
        retweenRecordDaoConfig.initIdentityScope(type);

        tocReadRecordDaoConfig = daoConfigMap.get(TocReadRecordDao.class).clone();
        tocReadRecordDaoConfig.initIdentityScope(type);

        bookSyncRecordDaoConfig = daoConfigMap.get(BookSyncRecordDao.class).clone();
        bookSyncRecordDaoConfig.initIdentityScope(type);

        bookVisitRecordDaoConfig = daoConfigMap.get(BookVisitRecordDao.class).clone();
        bookVisitRecordDaoConfig.initIdentityScope(type);

        mixTocRecordDaoConfig = daoConfigMap.get(MixTocRecordDao.class).clone();
        mixTocRecordDaoConfig.initIdentityScope(type);

        bookTopicEnterRecordDaoConfig = daoConfigMap.get(BookTopicEnterRecordDao.class).clone();
        bookTopicEnterRecordDaoConfig.initIdentityScope(type);

        bookDlRecordDaoConfig = daoConfigMap.get(BookDlRecordDao.class).clone();
        bookDlRecordDaoConfig.initIdentityScope(type);

        bookClickRecordDaoConfig = daoConfigMap.get(BookClickRecordDao.class).clone();
        bookClickRecordDaoConfig.initIdentityScope(type);

        postUsefulRecordDaoConfig = daoConfigMap.get(PostUsefulRecordDao.class).clone();
        postUsefulRecordDaoConfig.initIdentityScope(type);

        sourceWebReadRecordDaoConfig = daoConfigMap.get(SourceWebReadRecordDao.class).clone();
        sourceWebReadRecordDaoConfig.initIdentityScope(type);

        syncAccountDaoConfig = daoConfigMap.get(SyncAccountDao.class).clone();
        syncAccountDaoConfig.initIdentityScope(type);

        tweetCacheDaoConfig = daoConfigMap.get(TweetCacheDao.class).clone();
        tweetCacheDaoConfig.initIdentityScope(type);

        downloadItemDaoConfig = daoConfigMap.get(DownloadItemDao.class).clone();
        downloadItemDaoConfig.initIdentityScope(type);

        voteRecordDaoConfig = daoConfigMap.get(VoteRecordDao.class).clone();
        voteRecordDaoConfig.initIdentityScope(type);

        bookReadRecordDaoConfig = daoConfigMap.get(BookReadRecordDao.class).clone();
        bookReadRecordDaoConfig.initIdentityScope(type);

        sourceRecordDaoConfig = daoConfigMap.get(SourceRecordDao.class).clone();
        sourceRecordDaoConfig.initIdentityScope(type);

        dnsCacheRecordDaoConfig = daoConfigMap.get(DnsCacheRecordDao.class).clone();
        dnsCacheRecordDaoConfig.initIdentityScope(type);

        postAgreeRecordDaoConfig = daoConfigMap.get(PostAgreeRecordDao.class).clone();
        postAgreeRecordDaoConfig.initIdentityScope(type);

        bookFileDaoConfig = daoConfigMap.get(BookFileDao.class).clone();
        bookFileDaoConfig.initIdentityScope(type);

        accountInfoDaoConfig = daoConfigMap.get(AccountInfoDao.class).clone();
        accountInfoDaoConfig.initIdentityScope(type);

        retweenRecordDao = new RetweenRecordDao(retweenRecordDaoConfig, this);
        tocReadRecordDao = new TocReadRecordDao(tocReadRecordDaoConfig, this);
        bookSyncRecordDao = new BookSyncRecordDao(bookSyncRecordDaoConfig, this);
        bookVisitRecordDao = new BookVisitRecordDao(bookVisitRecordDaoConfig, this);
        mixTocRecordDao = new MixTocRecordDao(mixTocRecordDaoConfig, this);
        bookTopicEnterRecordDao = new BookTopicEnterRecordDao(bookTopicEnterRecordDaoConfig, this);
        bookDlRecordDao = new BookDlRecordDao(bookDlRecordDaoConfig, this);
        bookClickRecordDao = new BookClickRecordDao(bookClickRecordDaoConfig, this);
        postUsefulRecordDao = new PostUsefulRecordDao(postUsefulRecordDaoConfig, this);
        sourceWebReadRecordDao = new SourceWebReadRecordDao(sourceWebReadRecordDaoConfig, this);
        syncAccountDao = new SyncAccountDao(syncAccountDaoConfig, this);
        tweetCacheDao = new TweetCacheDao(tweetCacheDaoConfig, this);
        downloadItemDao = new DownloadItemDao(downloadItemDaoConfig, this);
        voteRecordDao = new VoteRecordDao(voteRecordDaoConfig, this);
        bookReadRecordDao = new BookReadRecordDao(bookReadRecordDaoConfig, this);
        sourceRecordDao = new SourceRecordDao(sourceRecordDaoConfig, this);
        dnsCacheRecordDao = new DnsCacheRecordDao(dnsCacheRecordDaoConfig, this);
        postAgreeRecordDao = new PostAgreeRecordDao(postAgreeRecordDaoConfig, this);
        bookFileDao = new BookFileDao(bookFileDaoConfig, this);
        accountInfoDao = new AccountInfoDao(accountInfoDaoConfig, this);

        registerDao(RetweenRecord.class, retweenRecordDao);
        registerDao(TocReadRecord.class, tocReadRecordDao);
        registerDao(BookSyncRecord.class, bookSyncRecordDao);
        registerDao(BookVisitRecord.class, bookVisitRecordDao);
        registerDao(MixTocRecord.class, mixTocRecordDao);
        registerDao(BookTopicEnterRecord.class, bookTopicEnterRecordDao);
        registerDao(BookDlRecord.class, bookDlRecordDao);
        registerDao(BookClickRecord.class, bookClickRecordDao);
        registerDao(PostUsefulRecord.class, postUsefulRecordDao);
        registerDao(SourceWebReadRecord.class, sourceWebReadRecordDao);
        registerDao(SyncAccount.class, syncAccountDao);
        registerDao(TweetCache.class, tweetCacheDao);
        registerDao(DownloadItem.class, downloadItemDao);
        registerDao(VoteRecord.class, voteRecordDao);
        registerDao(BookReadRecord.class, bookReadRecordDao);
        registerDao(SourceRecord.class, sourceRecordDao);
        registerDao(DnsCacheRecord.class, dnsCacheRecordDao);
        registerDao(PostAgreeRecord.class, postAgreeRecordDao);
        registerDao(BookFile.class, bookFileDao);
        registerDao(AccountInfo.class, accountInfoDao);
    }
    
    public void clear() {
        retweenRecordDaoConfig.clearIdentityScope();
        tocReadRecordDaoConfig.clearIdentityScope();
        bookSyncRecordDaoConfig.clearIdentityScope();
        bookVisitRecordDaoConfig.clearIdentityScope();
        mixTocRecordDaoConfig.clearIdentityScope();
        bookTopicEnterRecordDaoConfig.clearIdentityScope();
        bookDlRecordDaoConfig.clearIdentityScope();
        bookClickRecordDaoConfig.clearIdentityScope();
        postUsefulRecordDaoConfig.clearIdentityScope();
        sourceWebReadRecordDaoConfig.clearIdentityScope();
        syncAccountDaoConfig.clearIdentityScope();
        tweetCacheDaoConfig.clearIdentityScope();
        downloadItemDaoConfig.clearIdentityScope();
        voteRecordDaoConfig.clearIdentityScope();
        bookReadRecordDaoConfig.clearIdentityScope();
        sourceRecordDaoConfig.clearIdentityScope();
        dnsCacheRecordDaoConfig.clearIdentityScope();
        postAgreeRecordDaoConfig.clearIdentityScope();
        bookFileDaoConfig.clearIdentityScope();
        accountInfoDaoConfig.clearIdentityScope();
    }

    public RetweenRecordDao getRetweenRecordDao() {
        return retweenRecordDao;
    }

    public TocReadRecordDao getTocReadRecordDao() {
        return tocReadRecordDao;
    }

    public BookSyncRecordDao getBookSyncRecordDao() {
        return bookSyncRecordDao;
    }

    public BookVisitRecordDao getBookVisitRecordDao() {
        return bookVisitRecordDao;
    }

    public MixTocRecordDao getMixTocRecordDao() {
        return mixTocRecordDao;
    }

    public BookTopicEnterRecordDao getBookTopicEnterRecordDao() {
        return bookTopicEnterRecordDao;
    }

    public BookDlRecordDao getBookDlRecordDao() {
        return bookDlRecordDao;
    }

    public BookClickRecordDao getBookClickRecordDao() {
        return bookClickRecordDao;
    }

    public PostUsefulRecordDao getPostUsefulRecordDao() {
        return postUsefulRecordDao;
    }

    public SourceWebReadRecordDao getSourceWebReadRecordDao() {
        return sourceWebReadRecordDao;
    }

    public SyncAccountDao getSyncAccountDao() {
        return syncAccountDao;
    }

    public TweetCacheDao getTweetCacheDao() {
        return tweetCacheDao;
    }

    public DownloadItemDao getDownloadItemDao() {
        return downloadItemDao;
    }

    public VoteRecordDao getVoteRecordDao() {
        return voteRecordDao;
    }

    public BookReadRecordDao getBookReadRecordDao() {
        return bookReadRecordDao;
    }

    public SourceRecordDao getSourceRecordDao() {
        return sourceRecordDao;
    }

    public DnsCacheRecordDao getDnsCacheRecordDao() {
        return dnsCacheRecordDao;
    }

    public PostAgreeRecordDao getPostAgreeRecordDao() {
        return postAgreeRecordDao;
    }

    public BookFileDao getBookFileDao() {
        return bookFileDao;
    }

    public AccountInfoDao getAccountInfoDao() {
        return accountInfoDao;
    }

}
