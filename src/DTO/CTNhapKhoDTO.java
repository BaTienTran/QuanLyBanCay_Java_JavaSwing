/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class CTNhapKhoDTO {
    private int maphieunhap;
    private int masp;
    private int soluong;
    private int dongia;
    private int thanhtien;

    public CTNhapKhoDTO() {
    }

    public CTNhapKhoDTO(int maphieunhap, int masp, int soluong, int dongia, int thanhtien) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "CTNhapKhoDTO{" + "maphieunhap=" + maphieunhap + ", masp=" + masp + ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }
    
}
