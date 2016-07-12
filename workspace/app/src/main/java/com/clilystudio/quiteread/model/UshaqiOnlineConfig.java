package com.clilystudio.quiteread.model;

import android.text.TextUtils;

public class UshaqiOnlineConfig {
    private String serverError;

    public String getServerError() {
        return this.serverError;
    }

    public boolean isServerError() {
        return !TextUtils.isEmpty(this.serverError);
    }

    public void setServerError(String string) {
        this.serverError = string;
    }
}
