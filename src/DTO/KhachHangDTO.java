/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class KhachHangDTO {
    private int maKhachHang;
    private String tenKhachHang;
    private String diachi;
    private String sDT;
    private int trangThai;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int maKhachHang, String tenKhachHang, String diachi, String sDT, int trangThai) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diachi = diachi;
        this.sDT = sDT;
        this.trangThai = trangThai;
    }

    public KhachHangDTO(int maKhachHang, String tenKhachHang, String diachi, String sDT) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diachi = diachi;
        this.sDT = sDT;
    }

    public KhachHangDTO(String tenKhachHang, String diachi, String sDT) {
        this.tenKhachHang = tenKhachHang;
        this.diachi = diachi;
        this.sDT = sDT;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
