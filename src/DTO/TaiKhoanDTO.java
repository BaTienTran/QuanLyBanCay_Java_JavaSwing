/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import java.util.Objects;

public class TaiKhoanDTO {
    private int manv;
    private String tendangnhap;
    private String matkhau;
    private int manhomquyen;
    private int trangthai;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(int manv, String tendangnhap, String matkhau, int manhomquyen, int trangthai) {
        this.manv = manv;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.manhomquyen = manhomquyen;
        this.trangthai = trangthai;
    }

    public TaiKhoanDTO(int manv, String tendangnhap, String matkhau, int manhomquyen) {
        this.manv = manv;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.manhomquyen = manhomquyen;
    }

    public TaiKhoanDTO(int manv, String tendangnhap, int manhomquyen) {
        this.manv = manv;
        this.tendangnhap = tendangnhap;
        this.manhomquyen = manhomquyen;
    }

    public TaiKhoanDTO(String tendangnhap, String matkhau, int nhomQuyen) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.manhomquyen = nhomQuyen;}

    public TaiKhoanDTO(String tendangnhap, String matkhau) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }
    
    public TaiKhoanDTO(TaiKhoanDTO taiKhoanDTO, String matKhau){
        this();
        this.matkhau = matKhau;
    }


    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getManhomquyen() {
        return manhomquyen;
    }

    public void setManhomquyen(int manhomquyen) {
        this.manhomquyen = manhomquyen;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "TaiKhoanDTO{" + "manv=" + manv + ", tendangnhap=" + tendangnhap + ", matkhau=" + matkhau + ", manhomquyen=" + manhomquyen + ", trangthai=" + trangthai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoanDTO other = (TaiKhoanDTO) obj;
        if (!Objects.equals(this.tendangnhap, other.tendangnhap)) {
            return false;
        }
        return Objects.equals(this.matkhau, other.matkhau);
    }


    
    
}

