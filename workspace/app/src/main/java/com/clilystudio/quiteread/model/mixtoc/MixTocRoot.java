package com.clilystudio.quiteread.model.mixtoc;

import com.clilystudio.quiteread.model.Toc;

public class MixTocRoot {
    private Toc mixToc;
    private boolean ok;

    public Toc getMixToc() {
        return this.mixToc;
    }

    public void setMixToc(Toc toc) {
        this.mixToc = toc;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean bl) {
        this.ok = bl;
    }
}
