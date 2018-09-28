package com.zjft.bdp.pojo;

public class Url {
    private String url;

    private String uid;

    private String ujson;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUjson() {
        return ujson;
    }

    public void setUjson(String ujson) {
        this.ujson = ujson == null ? null : ujson.trim();
    }
}