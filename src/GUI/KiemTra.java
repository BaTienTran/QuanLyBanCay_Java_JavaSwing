/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

public class KiemTra {
    static transient Scanner sc = new Scanner(System.in);
    
    public static String kiemTraNhapTen() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            if(!dauVao.isEmpty() && dauVao.matches("[\\pL\\pMn*\\s*]+")) {
                //xóa ký tự khoảng trắng đầu và cuối chuỗi
                dauVao = dauVao.trim();
                //xóa các khoảng trắng dư trong chuỗi
                dauVao = dauVao.replaceAll("\\s+", " ");
                //viết hoa mỗi chữ cái đầu của mỗi từ
                dauVao = dauVao.toLowerCase();
                String[] chuoi = dauVao.split(" ");
                dauVao = "";
                for (int i = 0 ; i < chuoi.length ; i++) {
                    dauVao += String.valueOf(chuoi[i].charAt(0)).toUpperCase() + chuoi[i].substring(1);
                    //thêm khoảng trắng vào sau mỗi từ (trừ từ cuối)
                    if(i < chuoi.length - 1) {
                        dauVao += " ";
                    }
                }
                return dauVao;
            }
            else {
                System.out.print("Tên không hợp lệ! Vui lòng nhập lại: ");
            }
        }
    }
    //Start: ID CHECK
    public static String kiemTraNhapMaTaiKhoan() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("TK" + "[0-9]{3}")) {
                return dauVao;  
            }
            else {
                System.out.println("Nhập sai định dạng mã tài khoản: TK___. Ví dụ: TK001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    public static String kiemTraNhapMaKhachHang() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("KH" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã khách hàng: KH___. Ví dụ: KH001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaNhaCungCap() { 
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("NCC" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã nhà cung cấp: NCC___. Ví dụ: NCC001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaNhanVien() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("NV" + "[0-9]{3}")) {
                return dauVao;  
            }
            else {
                System.out.println("Nhập sai định dạng mã nhân viên: NV___. Ví dụ: NV001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaSanPham() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("(SP)" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã sản phẩm: SP___. Ví dụ: SP001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    public static String kiemTraNhapMaPhieuNhap() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("PN" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã phiếu nhập: PN___. Ví dụ: PN001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    

    public static String kiemTraNhapSDT() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim();
            // Số đầu là số 0, sau đó là 9 đến 10 chữ số
            if(!dauVao.isEmpty() && dauVao.matches("0[0-9]{9,10}")) {
                return dauVao;
            }
            else {
                System.out.println("Sai định dạng số điện thoại: 0__________. Ví dụ: 0906666666");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    // Start: NUMBER CHECK
    public static int kiemTraNhapSoNguyen() {
        int dauVao;
        while(true) {
            try {
                dauVao = Integer.parseInt(sc.nextLine());
                return dauVao;
            }
            catch(NumberFormatException exception) {
                System.out.print("Sai kiểu dữ liệu! Vui lòng nhập lại: ");
            }
        }
    }

    public static int kiemTraSoNguyenDuong() {
        int dauVao;
        while(true) {
            dauVao = kiemTraNhapSoNguyen();
            if(dauVao > 0) {
                return dauVao;
            }
            else {
                System.out.print("Số nhập vào phải lớn hơn 0! Mời nhập lại: ");
            }
        }
    }

    public static Double kiemTraNhapSoThuc() {
        double dauVao;
        while(true) {
            try {
                dauVao = Double.parseDouble(sc.nextLine());
                return dauVao;
            }
            catch (NumberFormatException exception) {
                System.out.print("Nhập sai kiểu dữ liệu! Mời nhập lại: ");
            }
        }
    }
}
