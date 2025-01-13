package com.example.md3.service;

import com.example.md3.model.MatBang;

import java.util.List;

public interface IMatBangService {
    public void addMatBang(MatBang matBang);
    void deleteMatBang(String maMatBang);
    List<MatBang> getAllMatBang(int idLoaiMatBang, double giaTien, int tang);
}
