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
public class XuatKhoDTO {
    private int maphieuxuat;
    private Date thoigian;
    private int tongtien;
    private int manv;
    private int makh;

    public XuatKhoDTO() {
    }

    public XuatKhoDTO(int maphieuxuat, Date thoigian, int tongtien, int manv, int makh) {
        this.maphieuxuat = maphieuxuat;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
        this.manv = manv;
        this.makh = makh;
    }

    public int getMaphieuxuat() {
        return maphieuxuat;
    }

    public void setMaphieuxuat(int maphieuxuat) {
        this.maphieuxuat = maphieuxuat;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    @Override
    public String toString() {
        return "XuatKhoDTO{" + "maphieuxuat=" + maphieuxuat + ", thoigian=" + thoigian + ", tongtien=" + tongtien + ", manv=" + manv + ", makh=" + makh + '}';
    }
    
}
