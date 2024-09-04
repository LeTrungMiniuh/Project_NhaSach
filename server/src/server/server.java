package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiKhachHang_DAO;
import dao.LoaiNhanVien_DAO;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.QuanLy_DAO;
import dao.Sach_DAO;
import dao_interface.LoaiNhanVien_DAO_Interface;

public class server {
    public static void main(String[] args) {
        try {
        	//sử dụng 
            // Tạo sổ đăng kí trên cổng 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Tạo một phiên bản triển khai DAO của bạn
            KhachHang_DAO khachHangDAO = new KhachHang_DAO();
            LoaiKhachHang_DAO loaiKhachHangDAO = new LoaiKhachHang_DAO();
            LoaiNhanVien_DAO loaiNhanVien_DAO = new LoaiNhanVien_DAO();
            LoaiSach_DAO loaiSach_DAO = new LoaiSach_DAO();
            NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
            NhaXuatBan_DAO nhaXuatBan_DAO = new NhaXuatBan_DAO();
            QuanLy_DAO quanLy_DAO = new QuanLy_DAO();
            Sach_DAO sach_DAO = new Sach_DAO();
            HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
            
            // Liên kết phiên bản với sổ đăng ký với một tên cụ thể
            registry.rebind("KhachHangDAO", khachHangDAO);
            registry.rebind("LoaiKhachHangDAO", loaiKhachHangDAO);
            registry.rebind("LoaiNhanVienDAO", loaiNhanVien_DAO);
            registry.rebind("LoaiSachDAO", loaiSach_DAO);
            registry.rebind("NhanVienDAO", nhanVien_DAO);
            registry.rebind("NhaXuatBanDAO", nhaXuatBan_DAO);
            registry.rebind("QuanLyDAO", quanLy_DAO);
            registry.rebind("SachDAO", sach_DAO);
            registry.rebind("HoaDonDAO", hoaDon_DAO);

            
            System.out.println("Server is ready 1099...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
