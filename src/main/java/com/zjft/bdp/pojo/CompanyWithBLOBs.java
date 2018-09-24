package com.zjft.bdp.pojo;

public class CompanyWithBLOBs extends Company {
    private String note;

    private String attr;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }
}