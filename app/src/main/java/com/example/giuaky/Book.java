package com.example.giuaky;

public class Book {
    private String Ten;
    private String MoTa;
    private int Hinh;

    public Book(String ten, String mota, int hinh) {
        this.Ten = ten;
        this.MoTa = mota;
        this.Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
