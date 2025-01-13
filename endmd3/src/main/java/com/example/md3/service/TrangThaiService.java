package com.example.md3.service;

import com.example.md3.model.TrangThai;
import com.example.md3.repository.TrangThaiRepo;

import java.util.List;

public class TrangThaiService {
    TrangThaiRepo trangThaiRepo;
    public List<TrangThai> findAll(){
        trangThaiRepo = new TrangThaiRepo();
        return trangThaiRepo.findAll();
    }
}
