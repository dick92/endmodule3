package com.example.md3.service;

import com.example.md3.model.MatBang;
import com.example.md3.repository.MatBangRepo;

import java.util.List;

public class MatBangService {
    public void addMatBang(MatBang matBang) {
    }

    public void deleteMatBang(String maMatBang) {
    }

    public List<MatBang> getAllMatBang(int idLoaiMatBang, double giaTien, int tang) {
        MatBangRepo matBangRepo = new MatBangRepo();
        return matBangRepo.getAllMatBang(idLoaiMatBang, giaTien, tang);
    }
}
