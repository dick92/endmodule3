package com.example.md3.repository;

import com.example.md3.model.MatBang;

import java.util.List;

public interface IMatBangRepo {
    public void addMatBang(MatBang matBang);
    void deleteMatBang(String maMatBang);
    List<MatBang> getAllMatBang(int idLoaiMatBang, double giaTien, int tang);
}
