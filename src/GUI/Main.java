package GUI;

import BUS.NhomQuyenBUS;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import javax.swing.SwingConstants;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {
    
    NhaCungCap nhaCungCap;
    NhapKho nhapKho;
    KhachHang khachHang;
    XuatKho xuatKho;
    SanPham sanPham;
    NhanVien nhanVien;
    ThongKe thongKe;
    TaiKhoan taiKhoan;
    PhanQuyen phanQuyen;
    Login login;
    
    int quyen=0;
    private final Color defaultColor = new Color(0,102,0);
    private final Color hoverColor = new Color(0, 150, 251);
    
    public Main(TaiKhoanDTO taiKhoanDTO) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        addIconTaskbar();
        addHoverBtn();
        quyen = taiKhoanDTO.getManhomquyen();
        hienThiButton(quyen);
        lbluser.setText(taiKhoanDTO.getTendangnhap());
        NhomQuyenBUS nhomQuyenBUS = new NhomQuyenBUS();
        NhomQuyenDTO nhomQuyenDTO = nhomQuyenBUS.getNhomQuyen(taiKhoanDTO.getManhomquyen());
        lblNhomQuyen.setText(nhomQuyenDTO.getTenNhomQuyen());
    }

    private void addIconTaskbar() {
        
        btnDangXuat.setText("<html>&nbsp;&nbsp;&nbsp;Đăng xuất</html>");
        btnKhachHang.setText("<html>&nbsp;&nbsp;&nbsp;Khách hàng</html>");
        btnNhaCungCap.setText("<html>&nbsp;&nbsp;&nbsp;Nhà cung cấp</html>");
        btnNhanVien.setText("<html>&nbsp;&nbsp;&nbsp;Nhân viên</html>");
        btnNhapKho.setText("<html>&nbsp;&nbsp;&nbsp;Nhập kho</html>");
        btnXuatKho.setText("<html>&nbsp;&nbsp;&nbsp; Xuất kho</html>");
        btnSanPham.setText("<html>&nbsp;&nbsp;&nbsp;Sản phẩm</html>");
        btnTaiKhoan.setText("<html>&nbsp;&nbsp;&nbsp;Tài khoản</html>");
        btnThongKe.setText("<html>&nbsp;&nbsp;&nbsp;Thống kê</html>");
        btnPhanQuyen.setText("<html>&nbsp;&nbsp;&nbsp;Phân quyền</html>");
        
        btnSanPham.setIcon(new FlatSVGIcon("./icon/product.svg"));
        btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);

        btnNhapKho.setIcon(new FlatSVGIcon("./icon/import.svg"));
        btnNhapKho.setHorizontalAlignment(SwingConstants.LEFT);

        btnKhachHang.setIcon(new FlatSVGIcon("./icon/customer.svg"));
        btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);

        btnNhaCungCap.setIcon(new FlatSVGIcon("./icon/supplier.svg"));
        btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);

        btnNhanVien.setIcon(new FlatSVGIcon("./icon/staff.svg"));
        btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);

        btnTaiKhoan.setIcon(new FlatSVGIcon("./icon/account.svg"));
        btnTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);

        btnThongKe.setIcon(new FlatSVGIcon("./icon/statistical.svg"));
        btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnXuatKho.setIcon(new FlatSVGIcon("./icon/cart.svg"));
        btnXuatKho.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnPhanQuyen.setIcon(new FlatSVGIcon("./icon/permission.svg"));
        btnPhanQuyen.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnDangXuat.setIcon(new FlatSVGIcon("./icon/log_out.svg"));
        btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    private void addHoverEffect(JButton button) {
        button.setBorderPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor); // Khi di chuột vào, đổi màu nền 

            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor); // Khi di chuột ra khỏi, đổi lại màu nền mặc định
            }
        });
    }

    // hàm taskbar
    public void addTaskBar(Container mainContent, JPanel panel) {
        mainContent.setLayout(new BorderLayout());
        panel.setSize(mainContent.getSize());
        mainContent.removeAll();
        mainContent.add(panel, BorderLayout.CENTER);
        mainContent.setVisible(true);
        mainContent.revalidate();
        mainContent.repaint();
    }
    
    private void addHoverBtn() {
        addHoverEffect(btnDangXuat);
        addHoverEffect(btnKhachHang);
        addHoverEffect(btnNhaCungCap);
        addHoverEffect(btnNhanVien);
        addHoverEffect(btnNhapKho);
        addHoverEffect(btnXuatKho);
        addHoverEffect(btnSanPham);
        addHoverEffect(btnTaiKhoan);
        addHoverEffect(btnThongKe);
        addHoverEffect(btnPhanQuyen);
        // Thêm hiệu ứng hover cho từng button
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menuTaskbar = new javax.swing.JPanel();
        user = new javax.swing.JPanel();
        lbluser = new javax.swing.JLabel();
        menuBtn = new javax.swing.JPanel();
        btnNhaCungCap = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnNhapKho = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnXuatKho = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        btnPhanQuyen = new javax.swing.JButton();
        pnlLogOut = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        lblNhomQuyen = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuTaskbar.setBackground(new java.awt.Color(0, 102, 0));

        user.setBackground(new java.awt.Color(0, 102, 0));

        lbluser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbluser.setForeground(new java.awt.Color(255, 255, 0));
        lbluser.setText("Admin");
        user.add(lbluser);

        menuBtn.setBackground(new java.awt.Color(0, 102, 0));

        btnNhaCungCap.setBackground(new java.awt.Color(0, 102, 0));
        btnNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        btnNhaCungCap.setText("Nhà cung cấp");
        btnNhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhaCungCap.setFocusPainted(false);
        btnNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCapActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(0, 102, 0));
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhanVien.setFocusPainted(false);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnNhapKho.setBackground(new java.awt.Color(0, 102, 0));
        btnNhapKho.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapKho.setText("Nhập kho");
        btnNhapKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapKho.setFocusPainted(false);
        btnNhapKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapKhoActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(0, 102, 0));
        btnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhachHang.setFocusPainted(false);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(0, 102, 0));
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSanPham.setFocusPainted(false);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnXuatKho.setBackground(new java.awt.Color(0, 102, 0));
        btnXuatKho.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatKho.setText("Xuất kho");
        btnXuatKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatKho.setFocusPainted(false);
        btnXuatKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatKhoActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(0, 102, 0));
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống kê");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.setFocusPainted(false);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnTaiKhoan.setBackground(new java.awt.Color(0, 102, 0));
        btnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiKhoan.setText("Tài khoản");
        btnTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiKhoan.setFocusPainted(false);
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        btnPhanQuyen.setBackground(new java.awt.Color(0, 102, 0));
        btnPhanQuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanQuyen.setText("Phân quyền");
        btnPhanQuyen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanQuyen.setFocusPainted(false);
        btnPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanQuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBtnLayout = new javax.swing.GroupLayout(menuBtn);
        menuBtn.setLayout(menuBtnLayout);
        menuBtnLayout.setHorizontalGroup(
            menuBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(btnNhapKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnXuatKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPhanQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuBtnLayout.setVerticalGroup(
            menuBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatKho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLogOut.setBackground(new java.awt.Color(0, 102, 0));

        btnDangXuat.setBackground(new java.awt.Color(0, 102, 0));
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.setFocusPainted(false);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogOutLayout = new javax.swing.GroupLayout(pnlLogOut);
        pnlLogOut.setLayout(pnlLogOutLayout);
        pnlLogOutLayout.setHorizontalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLogOutLayout.setVerticalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogOutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblNhomQuyen.setForeground(new java.awt.Color(204, 204, 204));
        lblNhomQuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhomQuyen.setText("NhomQuyen");

        javax.swing.GroupLayout menuTaskbarLayout = new javax.swing.GroupLayout(menuTaskbar);
        menuTaskbar.setLayout(menuTaskbarLayout);
        menuTaskbarLayout.setHorizontalGroup(
            menuTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuTaskbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhomQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuTaskbarLayout.setVerticalGroup(
            menuTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaskbarLayout.createSequentialGroup()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblNhomQuyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1228, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuTaskbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(menuTaskbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCapActionPerformed
        // TODO add your handling code here:
        nhaCungCap = new NhaCungCap();
        addTaskBar(content, nhaCungCap);
    }//GEN-LAST:event_btnNhaCungCapActionPerformed

    private void btnNhapKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapKhoActionPerformed
        // TODO add your handling code here:
        nhapKho = new NhapKho(quyen);
        addTaskBar(content, nhapKho);
    }//GEN-LAST:event_btnNhapKhoActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        khachHang = new KhachHang();
        addTaskBar(content, khachHang);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnXuatKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatKhoActionPerformed
        // TODO add your handling code here:
        xuatKho = new XuatKho(quyen);
        addTaskBar(content, xuatKho);
    }//GEN-LAST:event_btnXuatKhoActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        sanPham = new SanPham();
        addTaskBar(content, sanPham);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        nhanVien = new NhanVien();
        addTaskBar(content, nhanVien);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        thongKe = new ThongKe();
        addTaskBar(content, thongKe);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        // TODO add your handling code here:
        taiKhoan = new TaiKhoan();
        addTaskBar(content, taiKhoan);
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanQuyenActionPerformed
        // TODO add your handling code here:
        phanQuyen = new PhanQuyen();
        addTaskBar(content, phanQuyen);
    }//GEN-LAST:event_btnPhanQuyenActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        login = new Login();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed
    public void hienThiButton(int quyen) {
        if (quyen == 1) {
            btnNhapKho.setVisible(false);
            btnNhaCungCap.setVisible(false); 
            btnTaiKhoan.setVisible(false);
            btnPhanQuyen.setVisible(false); 
            btnNhanVien.setVisible(false);
            btnThongKe.setVisible(false);
        } if (quyen == 2) {
            btnXuatKho.setVisible(false);
            btnKhachHang.setVisible(false); 
            btnTaiKhoan.setVisible(false);
            btnPhanQuyen.setVisible(false); 
            btnNhanVien.setVisible(false);
            btnThongKe.setVisible(false);
        }

        if (quyen == 4) {
            btnSanPham.setVisible(false);
            btnNhapKho.setVisible(false);
            btnXuatKho.setVisible(false);
            btnKhachHang.setVisible(false);
            btnNhaCungCap.setVisible(false);
            btnNhanVien.setVisible(false);
            btnThongKe.setVisible(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnNhaCungCap;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnNhapKho;
    private javax.swing.JButton btnPhanQuyen;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuatKho;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel content;
    private javax.swing.JLabel lblNhomQuyen;
    private javax.swing.JLabel lbluser;
    private javax.swing.JPanel menuBtn;
    private javax.swing.JPanel menuTaskbar;
    private javax.swing.JPanel pnlLogOut;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables
}
