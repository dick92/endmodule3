package com.example.md3.controller;

import com.example.md3.model.LoaiMatBang;
import com.example.md3.model.MatBang;
import com.example.md3.model.TrangThai;
import com.example.md3.service.LoaiMatBangService;
import com.example.md3.service.MatBangService;
import com.example.md3.service.TrangThaiService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexServlet", value = "")
public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MatBangService matBangService = new MatBangService();
        LoaiMatBangService loaiMatBangService = new LoaiMatBangService();
        List<LoaiMatBang> loaiMatBangs = loaiMatBangService.findAll();
        TrangThaiService trangThaiService = new TrangThaiService();
        List<TrangThai> trangThaiList = trangThaiService.findAll();
        req.setAttribute("loaiMatBangs", loaiMatBangs);
        req.setAttribute("trangThaiList", trangThaiList);
        int idLoaiMatBang = 0;
        int idTrangThai = 0;
        int giaThue = 0;
        if(req.getParameter("loaiMatBang") != null){
            idLoaiMatBang = Integer.parseInt(req.getParameter("loaiMatBang"));
        }
        if(req.getParameter("trangThai") != null){
            idTrangThai = Integer.parseInt(req.getParameter("trangThai"));
        }

        List<MatBang> matBangList = matBangService.getAllMatBang(idLoaiMatBang, 0, 0);
        System.out.println(matBangList);
        req.setAttribute("matBangList", matBangList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);


    }
}
