package com.clilystudio.quiteread.model;

public class PostDetailComment {
    private PostComment[] comments;
    private boolean ok;

    public PostComment[] getComments() {
        return this.comments;
    }

    public void setComments(PostComment[] arrpostComment) {
        this.comments = arrpostComment;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean bl) {
        this.ok = bl;
    }
}