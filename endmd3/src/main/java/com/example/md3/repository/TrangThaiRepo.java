package com.example.md3.repository;

import com.example.md3.model.TrangThai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepo {
    public TrangThai getTrangThaiById(int idTrangThai) {
        Database database = new Database();
        Connection connection = database.getConnection();
        String sql = "SELECT * FROM trangthai WHERE id_trang_thai = " + idTrangThai;
        TrangThai trangThai = new TrangThai();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            trangThai.setIdTrangThai(idTrangThai);
            while (resultSet.next()) {
                trangThai.setTenTrangThai(resultSet.getString("ten_trang_thai"));
            }
            return trangThai;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<TrangThai> findAll(){
        Database database = new Database();
        Connection connection = database.getConnection();
        String sql = "SELECT * FROM trangthai";
        List<TrangThai> trangThais = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TrangThai trangThai = new TrangThai();
                trangThai.setIdTrangThai(resultSet.getInt("id_trang_thai"));
                trangThai.setTenTrangThai(resultSet.getString("ten_trang_thai"));
                trangThais.add(trangThai);
            }
            return trangThais;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
