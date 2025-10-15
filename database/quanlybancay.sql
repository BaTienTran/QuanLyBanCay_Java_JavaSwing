-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 08, 2024 lúc 03:32 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlybancay`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL DEFAULT 0,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `dongia` int(11) NOT NULL DEFAULT 0,
  `thanhtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`maphieunhap`, `masp`, `soluong`, `dongia`, `thanhtien`) VALUES
(2, 5, 10, 100000, 1000000),
(3, 1, 5, 17600, 88000),
(4, 3, 3, 25000, 75000),
(4, 4, 7, 30000, 210000),
(5, 4, 1, 10000, 10000),
(6, 4, 1, 10000, 10000),
(6, 5, 10, 10000, 100000),
(7, 4, 10, 10000, 100000),
(8, 4, 1, 25000, 25000),
(9, 3, 1, 10000, 10000),
(10, 1, 2, 50000, 100000),
(11, 4, 4, 24000, 96000),
(12, 1, 2, 24000, 48000),
(21, 5, 7, 7000, 49000),
(22, 3, 7, 10000, 70000),
(23, 4, 2, 70000, 140000),
(24, 5, 3, 24000, 72000),
(26, 3, 12, 13, 156),
(26, 4, 15, 17, 255),
(27, 3, 76, 100, 7600),
(28, 3, 7, 110, 770),
(29, 2, 200, 12, 2400),
(30, 4, 1, 100000000, 100000000),
(31, 2, 4, 100000, 400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `masp` int(11) NOT NULL DEFAULT 0,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `dongia` int(11) NOT NULL DEFAULT 0,
  `thanhtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieuxuat`
--

INSERT INTO `ctphieuxuat` (`maphieuxuat`, `masp`, `soluong`, `dongia`, `thanhtien`) VALUES
(1, 1, 2, 100000, 200000),
(2, 3, 10, 50000, 500000),
(3, 2, 1, 140000, 140000),
(3, 4, 1, 20000, 20000),
(4, 4, 1, 20000, 20000),
(5, 5, 1, 27000, 27000),
(7, 2, 2, 140000, 280000),
(8, 4, 1, 20000, 20000),
(9, 4, 2, 20000, 40000),
(10, 4, 2, 20000, 40000),
(11, 3, 15, 50000, 750000),
(12, 2, 3, 140000, 420000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `tenkhachhang` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1,
  `ngaythamgia` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkhachhang`, `diachi`, `sdt`, `trangthai`, `ngaythamgia`) VALUES
(1, 'Nguyễn Văn A', 'Gia Đức, Ân Đức, Hoài Ân, Bình Định', '0387913347', 1, '2024-03-19 09:52:29'),
(2, 'Trần Nhất Nhất', '205 Trần Hưng Đạo, Phường 10, Quận 5, Thành phố Hồ Chí Minh', '0123456789', 1, '2024-03-19 09:52:29'),
(3, 'Hoàng Gia Bo', 'Khoa Trường, Hoài Ân, Bình Định', '0987654321', 1, '2024-03-19 09:52:29'),
(4, 'Hồ Minh Hưng', 'Khoa Trường, Hoài Ân, Bình Định', '0867987456', 1, '2024-03-19 09:52:29'),
(29, 'Nguyễn Thị Minh Anh', '123 Phố Huế, Quận Hai Bà Trưng, Hà Nội', '0935123456', 1, '2024-03-23 17:59:57'),
(30, 'Trần Đức Minh', '789 Đường Lê Hồng Phong, Thành phố Đà Nẵng', '0983456789', 1, '2024-03-23 18:08:12'),
(31, 'Lê Hải Yến', '456 Tôn Thất Thuyết, Quận 4, Thành phố Hồ Chí Minh', '0977234567', 1, '2024-03-23 18:08:47'),
(32, 'Phạm Thanh Hằng', '102 Lê Duẩn, Thành phố Hải Phòng', '0965876543', 1, '2024-03-23 18:12:59'),
(33, 'Hoàng Đức Anh', '321 Lý Thường Kiệt, Thành phố Cần Thơ', '0946789012', 1, '2024-03-23 18:13:47'),
(34, 'Ngô Thanh Tùng', '987 Trần Hưng Đạo, Quận 1, Thành phố Hồ Chí Minh', '0912345678', 1, '2024-03-23 18:14:12'),
(35, 'Võ Thị Kim Ngân', '555 Nguyễn Văn Linh, Quận Nam Từ Liêm, Hà Nội', '0916789123', 1, '2024-03-23 18:15:11'),
(36, 'Đỗ Văn Tú', '777 Hùng Vương, Thành phố Huế', '0982345678', 1, '2024-03-23 18:15:56'),
(37, 'Lý Thanh Trúcs', '888 Nguyễn Thái Học, Quận Ba Đình, Hà Nộis', '0982123456', 1, '2024-03-23 18:16:22'),
(38, 'Bùi Văn Hoàng', '222 Đường 2/4, Thành phố Nha Trang', '0933789012', 1, '2024-03-23 18:16:53'),
(39, 'Lê Văn Thành', '23 Đường 3 Tháng 2, Quận 10, TP. Hồ Chí Minh', '0933456789', 0, '2024-03-23 18:17:46'),
(40, 'Nguyễn Thị Lan Anh', '456 Lê Lợi, Quận 1, TP. Hà Nội', '0965123456', 1, '2024-03-23 18:18:10'),
(41, 'hh', '234 Lê Hồng Phong, Quận 5, TP. Hồ Chí Minh', '0946789012', 0, '2024-03-23 18:18:34'),
(42, 'Hoàng Văn Nam', ' 567 Phố Huế, Quận Hai Bà Trưng, Hà Nội', '0912345678', 1, '2024-03-23 18:19:16'),
(43, 'd', 'd', 'd', 0, '2024-05-05 14:47:10'),
(44, 'ee', 'eee', 'ee', 0, '2024-05-06 02:14:59');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `manhacungcap` int(11) NOT NULL,
  `tennhacungcap` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`manhacungcap`, `tennhacungcap`, `diachi`, `email`, `sdt`, `trangthai`) VALUES
(1, 'Vườn đồi hoang', 'Q. Tân Bình, Tp. Hồ Chí Minh', 'lienhe@gmail.com', '0283510010', 1),
(2, 'Công ty Đại Phú Mỹ', 'Quận 7, TPHCM', 'contact@paviet.vn', '19009477', 1),
(3, 'Công Ty Ba Vì', 'Q. Bình Thạnh, Tp. Hồ Chí Minh', 'contact@baola.vn', '02835119060', 1),
(4, 'Công Ty Cây Xanh', 'Q. 1, Tp. Hồ Chí Minh (TPHCM)', 'info@nokia.com', '02838236894', 1),
(5, 'Vườn của Đậus', 'Q. Ngô Quyền, Tp. Hải Phòng', 'info@mihome.vn', '0365888888', 1),
(6, 'sss', 'Quận 1, Thành phố Hồ Chí Minh', 'contact@gmail.vo', '0988788456', 0),
(8, '22', '22', '22', '22', 0),
(9, 'sss', 'sss', 'a@g.co', '0999999999', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `sdt`, `trangthai`) VALUES
(1, 'Nguyễn Văn A', '0338641606', 1),
(2, 'Trần Văn Đông', '0935098654', 1),
(4, 'Lê Phương Tây', '0932831921', 1),
(5, 'Đinh Thị Na', '0932831982', 1),
(6, 'Nguyễn Văn D', '0231231234', 1),
(7, 'Nguyễn Văn B', '0987876567', 1),
(8, '12', '0233333333', 0),
(9, 'rr', '0999999999', 0),
(10, 'tt', '0999999999', 0),
(11, 'uu', '0999999999', 0),
(12, 'yy', '0009999999', 0),
(13, 'rre', '0999999999', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `manhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomquyen`
--

INSERT INTO `nhomquyen` (`manhomquyen`, `tennhomquyen`) VALUES
(1, 'Nhân viên'),
(2, 'Quản lý kho'),
(3, 'Quản trị'),
(4, 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `thoigian` date NOT NULL,
  `manhacungcap` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `tongtien` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maphieunhap`, `thoigian`, `manhacungcap`, `manv`, `tongtien`) VALUES
(2, '2024-04-15', 5, 5, 1000000),
(3, '2024-04-03', 1, 5, 88000),
(4, '2023-04-04', 3, 5, 285000),
(5, '2023-02-06', 5, 5, 10000),
(6, '2024-04-18', 2, 5, 100000),
(7, '2024-04-19', 4, 5, 100000),
(8, '2024-04-19', 5, 5, 145000),
(9, '2024-04-19', 6, 5, 105000),
(10, '2024-04-19', 4, 5, 100000),
(11, '2024-04-19', 5, 5, 96000),
(12, '2024-04-19', 5, 5, 48000),
(21, '2024-04-21', 6, 5, 49000),
(22, '2024-04-21', 3, 5, 70000),
(23, '2024-04-21', 3, 4, 140000),
(24, '2024-04-21', 6, 4, 72000),
(26, '2024-05-08', 5, 1, 411),
(27, '2024-05-08', 4, 1, 7600),
(28, '2024-05-08', 6, 1, 770),
(29, '2024-05-08', 5, 1, 2400),
(30, '2024-05-08', 4, 1, 100000000),
(31, '2024-05-08', 3, 1, 400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `thoigian` date NOT NULL,
  `tongtien` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `makh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`maphieuxuat`, `thoigian`, `tongtien`, `manv`, `makh`) VALUES
(1, '2024-04-19', 200000, 1, 1),
(2, '2024-04-21', 500000, 5, 4),
(3, '2024-04-21', 160000, 5, 29),
(4, '2024-04-21', 20000, 5, 30),
(5, '2024-04-21', 27000, 5, 30),
(7, '2024-04-21', 280000, 5, 29),
(8, '2024-04-21', 20000, 4, 4),
(9, '2024-04-21', 40000, 4, 33),
(10, '2024-04-21', 40000, 4, 30),
(11, '2024-05-08', 750000, 1, 30),
(12, '2024-05-08', 420000, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` int(11) NOT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `nhacungcap` int(11) DEFAULT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) DEFAULT 1,
  `giaxuat` bigint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`masp`, `tensp`, `nhacungcap`, `soluongton`, `trangthai`, `giaxuat`) VALUES
(1, 'Phong lan', 3, 14, 1, 150000),
(2, 'Sen đá', 1, 204, 1, 140000),
(3, 'Bình vôi', 3, 81, 1, 50000),
(4, 'Xương rồng', 1, 37, 1, 200000),
(5, 'Sen nhật', 6, 30, 0, 27000),
(6, 'hh', 6, 6666, 0, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `manv` int(11) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL DEFAULT '',
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`manv`, `matkhau`, `manhomquyen`, `tendangnhap`, `trangthai`) VALUES
(1, 'nhanvien', 1, 'nhanvien', 1),
(2, 'quanlykho', 2, 'quanlykho', 1),
(4, 'quantri', 3, 'quantri', 1),
(5, 'admin', 4, 'admin', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`maphieunhap`,`masp`) USING BTREE,
  ADD KEY `FK_sanpham_ctphieunhap` (`masp`);

--
-- Chỉ mục cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`,`masp`) USING BTREE,
  ADD KEY `FK_sanpham_ctphieuxuat` (`masp`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`manhacungcap`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Chỉ mục cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`manhomquyen`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `FK_ncc_phieunhap` (`manhacungcap`),
  ADD KEY `FK_nv_phieunhap` (`manv`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`),
  ADD KEY `FK_nv_phieuxuat` (`manv`),
  ADD KEY `FK_kh_phieuxuat` (`makh`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `FK_kho_sanpham` (`nhacungcap`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`manv`),
  ADD UNIQUE KEY `tendangnhap` (`tendangnhap`),
  ADD KEY `FK_taikhoan_nhomquyen` (`manhomquyen`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `manhacungcap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `manhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `FK_phieunhap_ctphieunhap` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`),
  ADD CONSTRAINT `FK_sanpham_ctphieunhap` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD CONSTRAINT `FK_phieuxuat_ctphieuxuat` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`maphieuxuat`),
  ADD CONSTRAINT `FK_sanpham_ctphieuxuat` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_ncc_phieunhap` FOREIGN KEY (`manhacungcap`) REFERENCES `nhacungcap` (`manhacungcap`),
  ADD CONSTRAINT `FK_nv_phieunhap` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_kh_phieuxuat` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `FK_nv_phieuxuat` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_kho_sanpham` FOREIGN KEY (`nhacungcap`) REFERENCES `nhacungcap` (`manhacungcap`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_taikhoan_nhanvien` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `FK_taikhoan_nhomquyen` FOREIGN KEY (`manhomquyen`) REFERENCES `nhomquyen` (`manhomquyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
