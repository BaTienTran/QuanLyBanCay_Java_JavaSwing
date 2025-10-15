/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CTNhapKhoBUS;
import BUS.NhapKhoBUS;
import BUS.XuatKhoBUS;
import DTO.NhapKhoDTO;
import DTO.XuatKhoDTO;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ThongKe extends javax.swing.JPanel {

    NhapKhoBUS nhapKhoBUS = new NhapKhoBUS();
    ArrayList<NhapKhoDTO> listNhapKho = nhapKhoBUS.getAllNhapKho();
    long tongvon = nhapKhoBUS.getTongTien();
    String chuoiTongVon = String.valueOf(tongvon);
    
    XuatKhoBUS xuatKhoBUS = new XuatKhoBUS();
    ArrayList<XuatKhoDTO> listXuatKho = xuatKhoBUS.getAllXuatKho();
    long tongDoanhthu = xuatKhoBUS.getTongTien();
    String chuoiTongDoanhThu = String.valueOf(tongDoanhthu);
    
    public ThongKe() {
        initComponents();
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblPhieuNhap.setFocusable(false);
        tblPhieuNhap.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblPhieuNhap.setAutoCreateRowSorter(true);
        
        tblPhieuXuat.setFocusable(false);
        tblPhieuXuat.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblPhieuXuat.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblPhieuXuat.setAutoCreateRowSorter(true);
        
        hienThiNhapKho(listNhapKho);
        hienThiXuatKho(listXuatKho);
        txtTongVon.setText(convertToVNDlong(tongvon));
        txtTongDoanhThu.setText(convertToVNDlong(tongDoanhthu));
    }

    public void hienThiNhapKho(ArrayList<NhapKhoDTO> listNhapKho){
        DefaultTableModel dtm = (DefaultTableModel) tblPhieuNhap.getModel();
        dtm.setRowCount(0);
        for(NhapKhoDTO nhapKhoDTO : listNhapKho){
            String tien = convertToVND(nhapKhoDTO.getTongtien());
            Object[] row = {
                nhapKhoDTO.getMaphieunhap(),
                nhapKhoDTO.getThoigian(),
                tien,
            };
            dtm.addRow(row);
        }
        
        //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblPhieuNhap.getColumnCount(); i++) {
            tblPhieuNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public void hienThiXuatKho(ArrayList<XuatKhoDTO> listXuatKho){
        DefaultTableModel dtm = (DefaultTableModel) tblPhieuXuat.getModel();
        dtm.setRowCount(0);
        for(XuatKhoDTO xuatKhoDTO : listXuatKho){     
            Object[] row = {
                xuatKhoDTO.getMaphieuxuat(),
                xuatKhoDTO.getThoigian(),
                convertToVND(xuatKhoDTO.getTongtien()),
            };
            dtm.addRow(row);
        }
        
        //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblPhieuXuat.getColumnCount(); i++) {
            tblPhieuXuat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public static String convertToVND(int amount) {
        // Tạo một DecimalFormat để định dạng số tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedAmount = decimalFormat.format(amount);
        formattedAmount += " VND";       
        return formattedAmount;
    }
    
    public static String convertToVNDlong(long amount) {
        // Tạo một DecimalFormat để định dạng số tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedAmount = decimalFormat.format(amount);
        formattedAmount += " VND";       
        return formattedAmount;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        lblTongVon = new javax.swing.JLabel();
        txtTongVon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();
        lblTongVon1 = new javax.swing.JLabel();
        txtTongDoanhThu = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Thời gian", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tblPhieuNhap);

        lblTongVon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongVon.setText("Tổng vốn:");

        txtTongVon.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongVon)
                .addGap(18, 18, 18)
                .addComponent(txtTongVon, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongVon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongVon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhập kho", jPanel1);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu xuất", "Thời gian", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tblPhieuXuat);

        lblTongVon1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongVon1.setText("Tổng doanh thu:");

        txtTongDoanhThu.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongVon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongVon1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xuất kho", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTongVon;
    private javax.swing.JLabel lblTongVon1;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTextField txtTongDoanhThu;
    private javax.swing.JTextField txtTongVon;
    // End of variables declaration//GEN-END:variables
}
