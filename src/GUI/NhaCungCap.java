package GUI;

import BUS.NhaCungCapBUS;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import GUI.NCCap.ChiTietNCCap;
import GUI.NCCap.SuaNCCap;
import GUI.NCCap.ThemNCCap;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class NhaCungCap extends javax.swing.JPanel{
    NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
    ArrayList<NhaCungCapDTO> listNhaCungCap = nhaCungCapBUS.getAllNhaCungCap();
    ChiTietNCCap chiTietNCCap;
    SuaNCCap suaNCCap;
    ThemNCCap themNCCap;
    
    public NhaCungCap() {
        initComponents();
        addIcon();
        
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblNhaCungCap.setFocusable(false);
        tblNhaCungCap.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblNhaCungCap.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblNhaCungCap.setFocusable(false);
        tblNhaCungCap.setAutoCreateRowSorter(true);
        
        btnTimKiem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Thực hiện tìm kiếm khi nút tìm kiếm được nhấn
            String keyword = txtTimKiem.getText().trim();
            timKiemNhaCungCap(keyword);
        }
    });
        hienThiNhaCungCap(listNhaCungCap);
    }

    private void addIcon(){
            btnThem.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSua.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoa.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnChiTiet.setIcon(new FlatSVGIcon("./icon/detail.svg"));
    }

    private void timKiemNhaCungCap(String keyword) {
    DefaultTableModel model = (DefaultTableModel) tblNhaCungCap.getModel();
    model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng

    for (int i = 0; i < listNhaCungCap.size(); i++) {
        NhaCungCapDTO nhaCungCap = listNhaCungCap.get(i);
        if (String.valueOf(nhaCungCap.getMaNhaCungCap()).contains(keyword) ||
            nhaCungCap.getTenNhaCungCap().toLowerCase().contains(keyword.toLowerCase()) ) {
            Object[] row = {
                nhaCungCap.getMaNhaCungCap(),
                nhaCungCap.getTenNhaCungCap(),
                nhaCungCap.getDiaChi(),
                nhaCungCap.getEmail(),
                nhaCungCap.getSdt()
            };
            model.addRow(row); // Thêm dòng mới vào bảng với thông tin tìm kiếm được
        }
    }
}
        
    public void hienThiNhaCungCap(ArrayList<NhaCungCapDTO> listNhaCungCap){
        DefaultTableModel dtm = (DefaultTableModel) tblNhaCungCap.getModel();
        dtm.setRowCount(0);
        for(NhaCungCapDTO nhaCungCapDTO : listNhaCungCap){
            Object[] row = {
                nhaCungCapDTO.getMaNhaCungCap(),
                nhaCungCapDTO.getTenNhaCungCap(),
                nhaCungCapDTO.getDiaChi(),
                nhaCungCapDTO.getEmail(),
                nhaCungCapDTO.getSdt(),
            };
            dtm.addRow(row);
        }
        
        //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblNhaCungCap.getColumnCount(); i++) {
            tblNhaCungCap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(254, 254, 254));
        btnThem.setText("Thêm");
        btnThem.setFocusPainted(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlTop.add(btnThem);

        btnSua.setBackground(new java.awt.Color(254, 254, 254));
        btnSua.setText("Sửa");
        btnSua.setFocusPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlTop.add(btnSua);

        btnXoa.setBackground(new java.awt.Color(254, 254, 254));
        btnXoa.setText("Xóa");
        btnXoa.setFocusPainted(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlTop.add(btnXoa);

        btnChiTiet.setBackground(new java.awt.Color(254, 254, 254));
        btnChiTiet.setText("Chi tiết");
        btnChiTiet.setFocusPainted(false);
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        pnlTop.add(btnChiTiet);

        txtTimKiem.setMinimumSize(new java.awt.Dimension(300, 30));
        txtTimKiem.setPreferredSize(new java.awt.Dimension(200, 22));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        pnlTop.add(txtTimKiem);

        btnTimKiem.setBackground(new java.awt.Color(254, 254, 254));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setMaximumSize(new java.awt.Dimension(100, 50));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(100, 50));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        btnTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTimKiemKeyPressed(evt);
            }
        });
        pnlTop.add(btnTimKiem);

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

        tblNhaCungCap.setBackground(new java.awt.Color(250, 250, 250));
        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Email", "Số điện thoại"
            }
        ));
        jScrollPane1.setViewportView(tblNhaCungCap);

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

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
        timKiemNhaCungCap(keyword);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        themNCCap = new ThemNCCap();
        themNCCap.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
       if(tblNhaCungCap.getSelectedRow() != -1){
           int row = tblNhaCungCap.getSelectedRow();
           TableModel model = tblNhaCungCap.getModel();
           int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
           suaNCCap = new SuaNCCap(maNCC);
           suaNCCap.setVisible(true);
       } else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp");
       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(tblNhaCungCap.getSelectedRow() != -1){
            int row = tblNhaCungCap.getSelectedRow();
            TableModel model = tblNhaCungCap.getModel();
            int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
            nhaCungCapBUS = new NhaCungCapBUS();
            boolean thanhCong = nhaCungCapBUS.xoaNhaCungCap(maNCC);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp thành công");
                listNhaCungCap = nhaCungCapBUS.getAllNhaCungCap();
                hienThiNhaCungCap(listNhaCungCap);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        if(tblNhaCungCap.getSelectedRow() != -1){
            int row = tblNhaCungCap.getSelectedRow();
            TableModel model = tblNhaCungCap.getModel();
            int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
            chiTietNCCap = new ChiTietNCCap(maNCC);
            chiTietNCCap.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp");
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        listNhaCungCap = nhaCungCapBUS.getAllNhaCungCap();
        hienThiNhaCungCap(listNhaCungCap);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txtTimKiem.getText().trim();
            timKiemNhaCungCap(keyword);
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblNhaCungCap;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
