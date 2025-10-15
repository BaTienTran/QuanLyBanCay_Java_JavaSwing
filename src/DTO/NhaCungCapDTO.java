package DTO;
public class NhaCungCapDTO {
    private int maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;
    private String email;
    private String sdt;
    private int trangThai;
    public NhaCungCapDTO() {
    }
    public NhaCungCapDTO(int maNhaCungCap, String tenNhaCungCap, 
            String diaChi, String email, String sdt, int trangThai) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    
    @Override
    public String toString() {
        return "NhaCungCapDTO{" + "maNhaCungCap=" + 
                maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + 
                ", diaChi=" + diaChi + ", email=" + email + ", sdt=" + sdt + ", "
                + "trangThai=" + trangThai + '}';
    }
    
    public NhaCungCapDTO(int maNhaCungCap, String tenNhaCungCap, String diaChi, String email, String sdt) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }
    public NhaCungCapDTO(String tenNhaCungCap, String diaChi, String email, String sdt, int trangThai) {
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    public NhaCungCapDTO(String tenNhaCungCap, String diaChi, String email, String sdt) {
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }
    
    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }
    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public int getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
