package com.clilystudio.quiteread.model;

import java.io.Serializable;

public class Root implements Serializable {
    private static final long serialVersionUID = 6384383576696578173L;
    private String code;
    private boolean ok;

    public String getCode() {
        return this.code;
    }

    public void setCode(String string) {
        this.code = string;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean bl) {
        this.ok = bl;
    }
}
