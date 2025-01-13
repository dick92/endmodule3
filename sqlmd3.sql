
CREATE DATABASE IF NOT EXISTS TComplexManagement;
USE TComplexManagement;
-- Tạo bảng TrangThai
CREATE TABLE TrangThai (
    id_trang_thai INT AUTO_INCREMENT PRIMARY KEY,
    ten_trang_thai VARCHAR(50) NOT NULL
);
-- Tạo bảng LoaiMatBang
CREATE TABLE LoaiMatBang (
    id_loai_mat_bang INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_mat_bang VARCHAR(50) NOT NULL
);
-- Tạo bảng MatBang
CREATE TABLE MatBang (
    ma_mat_bang VARCHAR(10) PRIMARY KEY, -- Mã mặt bằng phải đúng định dạng XXX-XX-XX
    id_trang_thai INT NOT NULL, -- Tham chiếu trạng thái
    dien_tich DOUBLE NOT NULL, -- Diện tích phải > 20m2
    tang INT NOT NULL, -- Tầng: từ 1 đến 15
    id_loai_mat_bang INT NOT NULL, -- Tham chiếu loại mặt bằng
    gia_tien DOUBLE NOT NULL, -- Giá tiền > 1.000.000 VNĐ
    ngay_bat_dau DATE NOT NULL, -- Ngày bắt đầu
    ngay_ket_thuc DATE NOT NULL, -- Ngày kết thúc
    FOREIGN KEY (id_trang_thai) REFERENCES TrangThai(id_trang_thai),
    FOREIGN KEY (id_loai_mat_bang) REFERENCES LoaiMatBang(id_loai_mat_bang)
);
-- Chèn dữ liệu mẫu cho bảng TrangThai
INSERT INTO TrangThai (ten_trang_thai) VALUES
('Trống'),
('Hạ tầng'),
('Đầy đủ');
-- Chèn dữ liệu mẫu cho bảng LoaiMatBang
INSERT INTO LoaiMatBang (ten_loai_mat_bang) VALUES
('Văn phòng chia sẻ'),
('Văn phòng trọn gói');
-- Chèn dữ liệu mẫu cho bảng MatBang
INSERT INTO MatBang (ma_mat_bang, id_trang_thai, dien_tich, tang, id_loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc)
VALUES
('ABC-12-34', 1, 25, 5, 1, 2000000, '2023-01-01', '2023-07-01'),
('DEF-56-78', 2, 30, 10, 2, 3000000, '2023-02-01', '2023-08-01'),
('GHI-90-12', 3, 45, 8, 2, 5000000, '2023-03-01', '2023-09-01');
-- Xem dữ liệu
SELECT * FROM MatBang;