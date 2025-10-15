package DTO;

import java.util.Date;
import java.util.Objects;

public class NhanVienDTO {

    private int manv;
    private String hoten;
    private String sdt;
    private int trangthai;

    public NhanVienDTO() {
    }

    public NhanVienDTO(int manv, String hoten, String sdt, int trangthai) {
        this.manv = manv;
        this.hoten = hoten;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }

    public NhanVienDTO(String hoten, String sdt, int trangthai) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }

    public NhanVienDTO(int ma, String ten, String sdt) {
        this.manv = ma;
        this.hoten = ten;
        this.sdt = sdt;
    }

    public NhanVienDTO(String tenNhanVien, String soDienThoai) {
        this.hoten = tenNhanVien;
        this.sdt = soDienThoai;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
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
        final NhanVienDTO other = (NhanVienDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", hoten=" + hoten + '}';
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

}