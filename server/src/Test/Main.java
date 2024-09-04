package Test;

import java.awt.GridLayout;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiKhachHang_DAO;
import dao.LoaiSach_DAO;
import dao.NhanVien_DAO;
import dao.QuanLy_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiKhachHang;
import entity.LoaiSach;
import entity.NhanVien;
import entity.QuanLy;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");

		//HoaDon_DAO hoaDonDAO = new HoaDon_DAO();

		/*
		 * HoaDon hd = new HoaDon("HD003", new NhanVien("NV01"),
		 * Date.valueOf("2024-04-16"), true, new Sach("MS000001"), null, 500000.0);
		 * 
		 * hoaDonDAO.createHoaDonCoKH(hd);
		 */

		
	/*	KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKH("1234567890");
		khachHang.setTenKH("John Doe");
		khachHang.setSDT("1234567890");
		khachHang.setEmail("john.doe@example.com");
		khachHang.setLoaiKhachHang(new LoaiKhachHang("LKH1"));
		// Set other properties as needed

		// Call createKH to persist the KhachHang
		khachHangDAO.createKH(khachHang);*/
		/* KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		 List<KhachHang> khachHangList = khachHangDAO.getKhachHangTheoTen("Bùi Xuân Dung");

		 
		// Kiểm tra xem danh sách khách hàng trả về có rỗng không
		if (khachHangList.isEmpty()) {
		    // Nếu danh sách rỗng, hiển thị thông báo cho người dùng
			 System.out.println( "khong tim thay");
		} else {
		    // Nếu danh sách không rỗng, hiển thị thông tin khách hàng
		    for (KhachHang khachHang : khachHangList) {
		        // Hiển thị thông tin của khách hàng
		        System.out.println("Mã khách hàng: " + khachHang.getMaKH());
		        System.out.println("Tên khách hàng: " + khachHang.getTenKH());
		        System.out.println("Số điện thoại: " + khachHang.getSDT());
		        System.out.println("Email: " + khachHang.getEmail());
		        System.out.println("Loại khách hàng: " + khachHang.getLoaiKhachHang().getTenLoaiKH());
		        System.out.println("Giới tính: " + (khachHang.isGioiTinh() ? "Nam" : "Nữ"));
		        System.out.println("Địa chỉ: " + khachHang.getDiaChi());
		        System.out.println("---------------------------");
		    }
		}*/
	        
		  //khachHangDAO.deleteKH("1234567890");
	/*	NhanVien_DAO nhanVienDAO = new NhanVien_DAO();
		List<NhanVien> danhSachNhanVien = nhanVienDAO.getNhanVienTheoTen("NV01");

		// Kiểm tra danh sách nhân viên có rỗng không
		if (!danhSachNhanVien.isEmpty()) {
		    // Danh sách không rỗng, xử lý các nhân viên trong danh sách
		    for (NhanVien nhanVien : danhSachNhanVien) {
		        System.out.println("Mã nhân viên: " + nhanVien.getMaNV());
		        System.out.println("Tên nhân viên: " + nhanVien.getTenNV());
		        // Xử lý các trường thông tin khác của nhân viên
		    }
		} else {
		    // Danh sách rỗng, thông báo cho người dùng
		    System.out.println("Không tìm thấy nhân viên có tên là 'Võ Hoàng Lộc'");
		}*/

}
}
