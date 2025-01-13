package com.example.md3.repository;

import com.example.md3.model.LoaiMatBang;
import com.example.md3.model.MatBang;
import com.example.md3.model.TrangThai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepo implements IMatBangRepo {
    public void addMatBang(MatBang matBang) {}
    public void deleteMatBang(String maMatBang) {}
    public List<MatBang> getAllMatBang(int idLoaiMatBang, double giaTien, int tang) {
        Database database = new Database();
        Connection connection = database.getConnection();
        String sqlFilerLoai = "";
        String sqlFilerGia = "";
        String sqlFilerTang = "";
        if (idLoaiMatBang != 0) {
            sqlFilerLoai = " AND id_loai_mat_bang = " + idLoaiMatBang;
        }
        if (giaTien != 0) {
            sqlFilerGia = " AND giaTien = " + giaTien;
        }
        if (tang != 0) {
            sqlFilerTang = " AND tang = " + tang;
        }
        String sql = "SELECT * FROM matbang WHERE 1 = 1" + sqlFilerLoai + sqlFilerGia + sqlFilerTang + " ORDER BY dien_tich ASC";
        List<MatBang> matBangList= new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                TrangThaiRepo trangThaiRepo = new TrangThaiRepo();
                TrangThai trangThai = trangThaiRepo.getTrangThaiById(resultSet.getInt("id_trang_thai"));
                LoaiMatBangRepo loaiMatBangRepo = new LoaiMatBangRepo();
                LoaiMatBang loaiMatBang = loaiMatBangRepo.getLoaiMatBang(resultSet.getInt("id_loai_mat_bang"));
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(trangThai);
                matBang.setDienTich(resultSet.getDouble("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(loaiMatBang);
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getString("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getString("ngay_ket_thuc"));
                matBangList.add(matBang);
            }

            return matBangList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
