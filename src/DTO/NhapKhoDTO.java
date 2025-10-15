/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author PC
 */
public class NhapKhoDTO {
    private int maphieunhap;
    private Date thoigian;
    private int manhacungcap;
    private int manv;
    private int tongtien;

    public NhapKhoDTO(int maphieunhap, Date thoigian, int manhacungcap, int manv, int tongtien) {
        this.maphieunhap = maphieunhap;
        this.thoigian = thoigian;
        this.manhacungcap = manhacungcap;
        this.manv = manv;
        this.tongtien = tongtien;
    }

    public NhapKhoDTO() {
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public int getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
