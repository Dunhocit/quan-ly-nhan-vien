<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h2>Danh Sách Nhân Viên</h2>

<a href="NhanVienservlet?action=new">Thêm Nhân Viên</a>

<table border="1">
	<tr>
		<th>Mã Nhân Viên</th>
		<th>Tên Nhân Viên</th>
		<th>Giới Tính</th>
		<th>Ngày Sinh</th>
		<th>Số Điện Thoại</th>
		<th>Email</th>
		<th>Chức Vụ</th>
		<th>Lương</th>
		<th>Chức Năng</th>
	</tr>
	
	<c:forEach var="nv" items="${listNV }">
	
		<tr>
			<td>${nv.maNV }</td>
			<td>${nv.tenNV }</td>
			<td>${nv.gioiTinh }</td>
			<td>${nv.ngaySinh }</td>
			<td>${nv.sDT }</td>
			<td>${nv.eMail }</td>
			<td>${nv.chucVu }</td>
			<td>${nv.luong }</td>
			<td><a href="NhanVienservlet?action=edit&maNV=${nv.maNV }">Sửa</a>
			<a href="NhanVienservlet?action=delete&maNV=${nv.maNV }">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>