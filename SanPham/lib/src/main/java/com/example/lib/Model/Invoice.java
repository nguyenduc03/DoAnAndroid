package com.example.lib.Model;

import java.util.List;

public class Invoice {
    private  int id;
    private String NgayDat;
    private int TongTien;
    private List<product> lists;


    public Invoice(int id, String ngayDat, int tongTien, List<product> lists) {
        this.id = id;
        NgayDat = ngayDat;
        TongTien = tongTien;
        this.lists = lists;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(String ngayDat) {
        NgayDat = ngayDat;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<product> getLists() {
        return lists;
    }

    public void setLists(List<product> lists) {
        this.lists = lists;
    }
}
