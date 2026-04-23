package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import DAO.NhanVien;
import DAO.NhanVienDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NhanVienservlet
 */
@WebServlet("/NhanVienservlet")
public class NhanVienservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NhanVienDAO DAO = new NhanVienDAO();

    /**
     * Default constructor. 
     */
    public NhanVienservlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		try {
			if(action == null) {
				listNhanVien(request, response);
			}else if(action.equals("edit")) {
				showEdit(request, response);
			}else if(action.equals("delete")) {
				DeleteNhanVien(request, response);
			}else if(action.equals("new")) {
				request.getRequestDispatcher("jsp/form.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<NhanVien> list = DAO.getAll();
		request.setAttribute("listNV", list);
		request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
	}

	private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int maNV = Integer.parseInt(request.getParameter("maNV"));
		NhanVien nv = DAO.getBymaNV(maNV);
		request.setAttribute("nv", nv);
		request.getRequestDispatcher("jsp/form.jsp").forward(request, response);
	}

	private void DeleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int manNV = Integer.parseInt(request.getParameter("maNV"));
		DAO.delete(manNV);
		response.sendRedirect("NhanVienservlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String maNV = request.getParameter("maNV");
		try {
			if(maNV == null || maNV.isEmpty()) {
				insertNhanVien(request, response);
			}else {
				updateNhanVien(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void insertNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		NhanVien nv = new NhanVien(
				request.getParameter("tenNV"),
				request.getParameter("gioiTinh"),
				java.sql.Date.valueOf(request.getParameter("ngaySinh")),
				request.getParameter("sDT"),
				request.getParameter("eMail"),
				request.getParameter("chucVu"),
				Float.parseFloat(request.getParameter("luong"))
				);
		DAO.add(nv);
		response.sendRedirect("NhanVienservlet");
	}

	private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		NhanVien nv = new NhanVien(
				Integer.parseInt(request.getParameter("maNV")),
				request.getParameter("tenNV"),
				request.getParameter("gioiTinh"),
				java.sql.Date.valueOf(request.getParameter("ngaySinh")),
				request.getParameter("sDT"),
				request.getParameter("eMail"),
				request.getParameter("chucVu"),
				Float.parseFloat(request.getParameter("luong"))
				);
		DAO.update(nv);
		response.sendRedirect("NhanVienservlet");
	}

}
