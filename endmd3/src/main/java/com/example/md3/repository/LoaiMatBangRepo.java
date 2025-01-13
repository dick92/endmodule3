package com.example.md3.repository;

import com.example.md3.model.LoaiMatBang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoaiMatBangRepo {
    public LoaiMatBang getLoaiMatBang(int idLoaiMatBang) {
        Database database = new Database();
        Connection connection = database.getConnection();
        String sql = "SELECT * FROM loaimatbang WHERE id_loai_mat_bang = " + idLoaiMatBang;
        LoaiMatBang loaiMatBang = new LoaiMatBang();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            loaiMatBang.setIdLoaiMatBang(idLoaiMatBang);
            while (resultSet.next()) {
                loaiMatBang.setTenLoaiMatBang(resultSet.getString("ten_loai_mat_bang"));
            }
            return loaiMatBang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<LoaiMatBang> findAll(){
        Database database = new Database();
        Connection connection = database.getConnection();
        String sql = "SELECT * FROM loaimatbang";
        List<LoaiMatBang> loaiMatBangs = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LoaiMatBang loaiMatBang = new LoaiMatBang();
                loaiMatBang.setIdLoaiMatBang(resultSet.getInt("id_loai_mat_bang"));
                loaiMatBang.setTenLoaiMatBang(resultSet.getString("ten_loai_mat_bang"));
                loaiMatBangs.add(loaiMatBang);
            }
            return loaiMatBangs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
