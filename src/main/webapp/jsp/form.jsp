<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h2>Form Nhân Viên</h2>
<form action="NhanVienservlet" method="post">
<c:if test="${nv != null }">
<input type="hidden" name ="maNV" value="${nv.maNV }">
</c:if>
<table>
	<tr>
		<td>Tên Nhân Viên: </td>
		<td><input type="text" name="tenNV" value="${nv.tenNV }"></td>
	</tr>
	<tr>
		<td>Giới Tính: </td>
		<td><input type="text" name="gioiTinh" value="${nv.gioiTinh }"></td>
	</tr>
	<tr>
		<td>Ngày Sinh: </td>
		<td><input type="date" name="ngaySinh" value="${nv.ngaySinh }"></td>
	</tr>
	<tr>
		<td>Số Điện Thoại: </td>
		<td><input type="text" name="sDT" value="${nv.sDT }"></td>
	</tr>
	<tr>
		<td>Email: </td>
		<td><input type="text" name="eMail" value="${nv.eMail }"></td>
	</tr>
	<tr>
		<td>Chức Vụ: </td>
		<td><input type="text" name="chucVu" value="${nv.chucVu }"></td>
	</tr>
	<tr>
		<td>Lương</td>
		<td><input type="text" name="luong" value="${nv.luong }"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Save"></td>
	</tr>
</table>
</form>