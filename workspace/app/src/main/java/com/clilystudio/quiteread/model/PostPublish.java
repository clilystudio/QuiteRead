package com.clilystudio.quiteread.model;

public class PostPublish {
    private String _id;
    private String code;
    private String msg;
    private boolean ok;
    private String postId;

    public String getCode() {
        return this.code;
    }

    public void setCode(String string) {
        this.code = string;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String string) {
        this.msg = string;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String string) {
        this.postId = string;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String string) {
        this._id = string;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean bl) {
        this.ok = bl;
    }
}