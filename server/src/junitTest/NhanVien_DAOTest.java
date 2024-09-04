package junitTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import dao.NhanVien_DAO;
import entity.NhanVien;

public class NhanVien_DAOTest {

	@Test
	public void testGetAllNhanVien() throws RemoteException {
	  
	  NhanVien_DAO nvDAO = new NhanVien_DAO();
	  List<NhanVien> nhanViens = nvDAO.getallNhanVien();
	  
	  
	  assertNotNull(nhanViens);
	  assertTrue(nhanViens.size() > 0); 
	  }
	
	@Test
	public void testGetNhanVienTheoMa_MaHopLe() throws RemoteException {
	  String maNVHopLe = "NV01";
	  NhanVien_DAO nvDAO = new NhanVien_DAO();
	  List<NhanVien> nhanViens = nvDAO.getNhanVienTheoMa(maNVHopLe);

	  assertNotNull(nhanViens);
	  assertEquals(1, nhanViens.size());
	  assertEquals(maNVHopLe, nhanViens.get(0).getMaNV());
	}

	
	@Test
	public void testGetNhanVienTheoMa_MaKhongHopLe() throws RemoteException {
		
	  String maNVKhongHopLe = "ABC123";
	  NhanVien_DAO nvDAO = new NhanVien_DAO();
	  List<NhanVien> nhanViens = nvDAO.getNhanVienTheoMa(maNVKhongHopLe);
	  
	  assertNotNull(nhanViens);
	  assertTrue(nhanViens.isEmpty());
	}
	@Test
	public void testCreateNV_DuLieuHopLe() throws RemoteException {
		
	  NhanVien nvMoi = new NhanVien("NV02", "Nguyen Van B", null, 
	                                 "123456789", "0123456789", new Date(), new Date(),
	                                 "Ha Noi", "nguoiB@gmail.com", true, "matKhauB", true, "linkAnhNV");
	  
	  NhanVien_DAO nvDAO = new NhanVien_DAO();
	  boolean result = nvDAO.createNV(nvMoi);
	  
	  assertTrue(result);
	  
	}
	
	@Test
	public void testUpdateNV_DuLieuHopLe() throws RemoteException {
	  String maNVCapNhat = "NV0001"; 
	  NhanVien nvCapNhat = new NhanVien(maNVCapNhat, "Nguyen Van A (Cap Nhat)", null);
	  nvCapNhat.setCCCD("123456789012345678");
	  nvCapNhat.setSDT("0987654321");
	  nvCapNhat.setNgaySinh(new Date()); 
	  nvCapNhat.setNgayVaoLam(new Date()); 
	  nvCapNhat.setDiaChi("Ha Noi"); 
	  nvCapNhat.setEmail("nguoiACapNhat@gmail.com");
	  nvCapNhat.setGioiTinh(false); 
	  nvCapNhat.setMatKhau("matKhauCapNhat"); 
	  nvCapNhat.setTrangThai(true);
	  nvCapNhat.setUrlAnhNV("linkAnhNVCapNhat"); 
	  
	  NhanVien_DAO nvDAO = new NhanVien_DAO();
	  boolean result = nvDAO.updateNV(nvCapNhat);
	  
	  assertTrue(result);
	  
	  NhanVien nvDaCapNhat = nvDAO.getNhanVienTheoMa(maNVCapNhat).get(0);
	  assertEquals(nvCapNhat.getCCCD(), nvDaCapNhat.getCCCD());
	  assertEquals(nvCapNhat.getSDT(), nvDaCapNhat.getSDT());
	}

	
}
