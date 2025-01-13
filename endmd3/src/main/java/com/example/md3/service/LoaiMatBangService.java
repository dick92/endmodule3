package com.example.md3.service;

import com.example.md3.model.LoaiMatBang;
import com.example.md3.repository.LoaiMatBangRepo;

import java.util.List;

public class LoaiMatBangService {
    LoaiMatBangRepo loaiMatBangRepo;
    public List<LoaiMatBang> findAll(){
        loaiMatBangRepo = new LoaiMatBangRepo();
        return loaiMatBangRepo.findAll();
    }
}
