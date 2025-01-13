<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Danh Sach Mat Bang</title>
</head>
<body>
<h1>Danh Sach Mat bang</h1>
<br/>
<form method="get" action="" class="w-75 m-auto mt-3">
    <div class="row">
        <div class="col-md-4">
            <label for="loaiMatBang" class="form-label">Loai Mat Bang</label>
            <select id="loaiMatBang" name="loaiMatBang" class="form-select">
                <c:forEach var="loaiMatBang" items="${loaiMatBangs}">
                    <option value="${loaiMatBang.idLoaiMatBang}">${loaiMatBang.tenLoaiMatBang}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-4">
            <label for="trangThai" class="form-label">Trang Thai</label>
            <select id="trangThai" name="trangThai" class="form-select">
                <c:forEach var="trangThai" items="${trangThaiList}">
                    <option value="${trangThai.idTrangThai}">${trangThai.tenTrangThai}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-4 d-flex align-items-end">
            <button type="submit" class="btn btn-primary">Filter</button>
        </div>
    </div>
</form>
<table class="table w-75 m-auto table-hover shadow-sm border rounded-lg mt-3">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã MB</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">Dien Tich</th>
        <th scope="col">Tang</th>
        <th scope="col">Loai Mat Bang</th>
        <th scope="col">Gia Tien</th>
        <th scope="col">Ngay Bat Dau</th>
        <th scope="col">Ngay Ket Thuc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="matbang" items="${matBangList}" varStatus="status">
        <tr>
            <th scope="row">${status.index + 1}</th>
            <td>${matbang.maMatBang}</td>
            <td>${matbang.trangThai.tenTrangThai}</td>
            <td>${matbang.dienTich}</td>
            <td>${matbang.tang}</td>
            <td>${matbang.loaiMatBang.tenLoaiMatBang}</td>
            <td>${matbang.giaTien}</td>
            <td>${matbang.ngayBatDau}</td>
            <td>${matbang.ngayKetThuc}</td>
        </tr>
    </c:forEach>


    </tbody>
</table>
</body>
</html>