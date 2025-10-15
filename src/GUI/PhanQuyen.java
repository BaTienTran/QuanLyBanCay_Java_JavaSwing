package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhomQuyenBUS;
import BUS.TaiKhoanBUS;
import DTO.NhaCungCapDTO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import GUI.NCCap.ChiTietNCCap;
import GUI.NCCap.SuaNCCap;
import GUI.NCCap.ThemNCCap;
import GUI.TKhoan.PhanQuyenTKhoan;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class PhanQuyen extends javax.swing.JPanel {
    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    ArrayList<TaiKhoanDTO> listTaiKhoan = taiKhoanBUS.getAllTaiKhoan();
    
    public PhanQuyen() {
        initComponents();
        addIcon();
        
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblTaiKhoan.setFocusable(false);
        tblTaiKhoan.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblTaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblTaiKhoan.setFocusable(false);
        tblTaiKhoan.setAutoCreateRowSorter(true);
        
        hienThiTaiKhoan(listTaiKhoan);
    }

    private void addIcon(){
            btnPhanQuyen.setIcon(new FlatSVGIcon("./icon/edit.svg"));
        }
    
    public void hienThiTaiKhoan(ArrayList<TaiKhoanDTO> listTaiKhoan){
        DefaultTableModel dtm = (DefaultTableModel) tblTaiKhoan.getModel();
        dtm.setRowCount(0);
        for(TaiKhoanDTO taiKhoanDTO : listTaiKhoan){
            NhomQuyenBUS nhomQuyenBUS = new NhomQuyenBUS();
            NhomQuyenDTO nhomQuyenDTO = nhomQuyenBUS.getNhomQuyen(taiKhoanDTO.getManhomquyen());
            
            Object[] row = {
                taiKhoanDTO.getManv(),
                taiKhoanDTO.getTendangnhap(),
                nhomQuyenDTO.getTenNhomQuyen(),
            };
            dtm.addRow(row);
        }
        
        //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblTaiKhoan.getColumnCount(); i++) {
            tblTaiKhoan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnPhanQuyen = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));

        btnPhanQuyen.setBackground(new java.awt.Color(254, 254, 254));
        btnPhanQuyen.setText("Phân quyền");
        btnPhanQuyen.setFocusPainted(false);
        btnPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanQuyenActionPerformed(evt);
            }
        });
        pnlTop.add(btnPhanQuyen);

        btnLamMoi.setBackground(new java.awt.Color(254, 254, 254));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnlTop.add(btnLamMoi);

        pnlCenter.setBackground(new java.awt.Color(254, 254, 254));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);

        tblTaiKhoan.setBackground(new java.awt.Color(250, 250, 250));
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Quyền"
            }
        ));
        jScrollPane1.setViewportView(tblTaiKhoan);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
            .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanQuyenActionPerformed
        // TODO add your handling code here:
       if(tblTaiKhoan.getSelectedRow() != -1){
           int row = tblTaiKhoan.getSelectedRow();
           TableModel model = tblTaiKhoan.getModel();
           int manv = Integer.parseInt(model.getValueAt(row, 0).toString());
           PhanQuyenTKhoan phanQuyen = new PhanQuyenTKhoan(manv);
           phanQuyen.setVisible(true);
       } else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản");
       }
    }//GEN-LAST:event_btnPhanQuyenActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        listTaiKhoan = taiKhoanBUS.getAllTaiKhoan();
        hienThiTaiKhoan(listTaiKhoan);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnPhanQuyen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
