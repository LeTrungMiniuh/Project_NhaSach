package junitTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.LoaiKhachHang;
public class KhachHang_DAOTest {
	
	@Test
	public void testGetKhachHangTheoTen() throws RemoteException {
		
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		String tenKhachHang = "Bùi Xuân Dung";
		assertNotNull(khachHangDAO.getKhachHangTheoTen(tenKhachHang));
		assertTrue(khachHangDAO.getKhachHangTheoTen(tenKhachHang).size() > 0);
			
			
    }
	
	@Test
	public void testGetKhachHangTheoTenTangDang() throws RemoteException {
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		String tenKhachHang = "Bùi Xuân Dung";
		assertNotNull(khachHangDAO.getallKhachHangTangDanTheoTen());
		assertTrue(khachHangDAO.getallKhachHangTangDanTheoTen().size() > 0);
	}
	
	@Test
	public void testGetKhachHangTheoTenGiamDang() throws RemoteException {
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		String tenKhachHang = "Bùi Xuân Dung";
		assertNotNull(khachHangDAO.getallKhachHangGiamDanTheoTen());
		assertTrue(khachHangDAO.getallKhachHangGiamDanTheoTen().size() > 0);
	}

	@Test
	public void testGetKhachHangTheoMa() throws RemoteException {
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		String maKhachHang = "KH01";
		assertNotNull(khachHangDAO.getKhachHangTheoMa(maKhachHang));
	}
	@Test
	public void testGetallKhachHang() throws RemoteException {
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		assertNotNull(khachHangDAO.getallKhachHang());
		assertTrue(khachHangDAO.getallKhachHang().size() > 0);
	}
	
	@Test
	 public void testCreateKH() throws RemoteException {
        // Given
        String maKH = "KH001";
        String tenKH = "Nguyen Van A";
        String sDT = "0123456789";
        String email = "nguyenvana@example.com";
        LoaiKhachHang loaiKH = new LoaiKhachHang("KHNM", "Khách Hàng Bình Thường");
        boolean gioiTinh = true;
        String diaChi = "123 Duong ABC, TP.HCM";
        
        KhachHang khachHang = new KhachHang(maKH, tenKH, sDT, email, loaiKH, gioiTinh, diaChi);
        KhachHang_DAO khachHangDAO = new KhachHang_DAO();
        // When
        boolean result = khachHangDAO.createKH(khachHang);
        // Then
  	    assertTrue(result);
    }
	
	
	
	@Test
	public void testUpdateKH() throws RemoteException {
        // Given
        String maKH = "KH01";
        String tenKH = "Nguyen Van A";
        String sDT = "0123456789";
        String email = "nguyenvanA@gmail.com";
        LoaiKhachHang loaiKH = new LoaiKhachHang("KHVIP", "Khách Hàng VIP");
        boolean gioiTinh = false;;
        String diaChi = "124 Duong CBA, TP.HCM";
        
	    KhachHang khupdate = new KhachHang(maKH, tenKH, sDT, email, loaiKH, gioiTinh, diaChi);
	    KhachHang_DAO khachHangDAO = new KhachHang_DAO();
	    // When
	      	boolean result = khachHangDAO.updateKH(khupdate);
	     // Then
	     assertTrue(result);
	
	}
	
	
    @Test
	public void testDeleteKH() throws RemoteException {
		// Given
		String maKH = "KH01";
		KhachHang khachHang = new KhachHang(maKH);
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		// When
		boolean result = khachHangDAO.deleteKH(khachHang);
		// Then
		assertTrue(result);
	}
    
    
    
	
	
	
	
}


