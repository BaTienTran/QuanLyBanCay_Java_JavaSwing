/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class SanPhamDTO {
    private int maSP;
    private String tenSP;
    private int nhaCC;
    private int soLuongTon;
    private int trangThai;
    private int giaXuat;

    public SanPhamDTO() {
    }

    public SanPhamDTO(int maSP, String tenSP, int nhaCC, int soLuongTon, int trangThai, int giaXuat) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaCC = nhaCC;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.giaXuat = giaXuat;
    }

    public SanPhamDTO(String tenSP, int nhaCC, int soLuongTon, int trangThai, int giaXuat) {
        this.tenSP = tenSP;
        this.nhaCC = nhaCC;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.giaXuat = giaXuat;
    }

    public SanPhamDTO(String tenSP, int nhaCC, int soLuongTon, int giaXuat) {
        this.tenSP = tenSP;
        this.nhaCC = nhaCC;
        this.soLuongTon = soLuongTon;
        this.giaXuat = giaXuat;
    }

    public SanPhamDTO(int maSP, String tenSP, int nhaCC, int soLuongTon, int giaXuat) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaCC = nhaCC;
        this.soLuongTon = soLuongTon;
        this.giaXuat = giaXuat;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getNhaCC() {
        return nhaCC;
    }

    public void setNhaCC(int nhaCC) {
        this.nhaCC = nhaCC;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(int giaXuat) {
        this.giaXuat = giaXuat;
    }

    @Override
    public String toString() {
        return "SanPhamDTO{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", nhaCC=" + nhaCC + ", soLuongTon=" + soLuongTon + ", giaXuat=" + giaXuat + '}';
    }
    
    
}
