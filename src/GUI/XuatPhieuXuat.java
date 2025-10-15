package GUI;

import BUS.CTXuatKhoBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.NhapKhoBUS;
import BUS.SanPhamBUS;
import BUS.XuatKhoBUS;

import DTO.CTXuatKhoDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.XuatKhoDTO;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class XuatPhieuXuat extends javax.swing.JDialog {

    private ArrayList<CTXuatKhoDTO> listCTPhieuXuat = null;
    private int tongTien;
    private boolean checkXuat = false;
    int khachHang;
    int nhanVien;

    public XuatPhieuXuat(int khachHang, int nhanVien, ArrayList<CTXuatKhoDTO> listCTPhieuXuat) {

        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.listCTPhieuXuat = listCTPhieuXuat;

        initComponents();
        
        txtChiTiet.setEditable(false);

        for (CTXuatKhoDTO ctpn : this.listCTPhieuXuat) {
            this.tongTien += ctpn.getThanhtien();
        }
        this.setLocationRelativeTo(null);
        this.setModal(true);
        btnInPhieu.setEnabled(false);
    }

    public boolean getCheckXuat() {
        return checkXuat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChiTiet = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnInPhieu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtChiTiet.setEditable(false);
        jScrollPane1.setViewportView(txtChiTiet);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin phiếu xuất");
        jPanel1.add(jLabel1);

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setPreferredSize(new java.awt.Dimension(145, 40));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel2.add(btnXacNhan);

        btnInPhieu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInPhieu.setText("In phiếu nhập");
        btnInPhieu.setPreferredSize(new java.awt.Dimension(145, 40));
        btnInPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuActionPerformed(evt);
            }
        });
        jPanel2.add(btnInPhieu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        checkXuat = true;
        btnXacNhan.setEnabled(false);
        btnInPhieu.setEnabled(true);

        SanPhamBUS sanPhamBUS = new SanPhamBUS();
        ArrayList<SanPhamDTO> dssp = sanPhamBUS.getAllSanPham();

        txtChiTiet.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");

        // Lưu Phiếu nhập trước để xíu lấy cái mã
        XuatKhoDTO xuatKhoDTO = new XuatKhoDTO();
        xuatKhoDTO.setMakh(khachHang);
        xuatKhoDTO.setManv(nhanVien);
        xuatKhoDTO.setTongtien(tongTien);
        
        XuatKhoBUS xuatKhoBUS = new XuatKhoBUS();
        xuatKhoBUS.themXuatKho(xuatKhoDTO);

        int maPN = xuatKhoBUS.getLastID();
        CTXuatKhoBUS ctphieuxuatbus = new CTXuatKhoBUS();

        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVienDTO nhanvienDTO = nhanVienBUS.selectByID(nhanVien);
        
        KhachHangBUS khachHangBUS = new KhachHangBUS();
        KhachHangDTO khachHangDTO = khachHangBUS.getKhachHang(khachHang);
        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>CHI TIẾT PHIẾU XUẤT</h1>";
        hd += "Nhân viên: " + nhanvienDTO.getHoten() + "<br/>";
        hd += "Ngày lập: " + dtf.format(now) + "<br/>";
        hd += "Khách hàng: " + khachHangDTO.getTenKhachHang() + "<br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Mã SP</th>"
                + "<th>Tên SP</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        for (CTXuatKhoDTO ctpn : listCTPhieuXuat) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + ctpn.getMasp()+ "</td>";
            for (SanPhamDTO sp : dssp) {
                if (sp.getMaSP()== ctpn.getMasp()) {
                    hd += "<td style='text-align:left;'>" + sp.getTenSP()+ "</td>";
                    break;
                }
            }
            hd += "<td style='text-align:center;'>" + ctpn.getSoluong()+ "</td>";
            hd += "<td style='text-align:center;'>" + ctpn.getDongia()+ "</td>";
            hd += "<td style='text-align:center;'>" + ctpn.getThanhtien()+ "</td>";
            hd += "</tr>";

            //===================================================
            //===================LƯU CTPN VÀO DB=================
            //===================================================
            ctpn.setMaphieuxuat(maPN);
            ctphieuxuatbus.themCTXuatKho(ctpn);
        }
        
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";

        txtChiTiet.setText(hd);
        
        JOptionPane.showMessageDialog(this, "Xác nhận thành công!", "Thành công", JOptionPane.DEFAULT_OPTION);

    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnInPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuActionPerformed
        try {
            txtChiTiet.print();
        } catch (PrinterException e) {
        }
        this.dispose();
    }//GEN-LAST:event_btnInPhieuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieu;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtChiTiet;
    // End of variables declaration//GEN-END:variables
}
