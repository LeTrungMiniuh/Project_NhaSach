package junitTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import dao.Sach_DAO;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.Sach;

@TestInstance(Lifecycle.PER_CLASS)
public class Sach_DAO_Test {
    dao.Sach_DAO sach_DAO;

    @BeforeAll
    public void setUp() {
        try {
            sach_DAO = new Sach_DAO();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
   public void testGetAllSachConHang() {
		ArrayList<Sach> dsSach = (ArrayList<Sach>) sach_DAO.getallSachConHang();
		assertNotNull(dsSach);
		// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
		assertEquals(10, dsSach.size());
	}

    public void testGetAllSachHetHang() {
	List<Sach> dsSach = sach_DAO.getallSachHetHang();
	assertNotNull(dsSach);
	// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
	assertEquals(10, dsSach.size());
}   

public void testGetAllSach() {
	ArrayList<Sach> dsSach = (ArrayList<Sach>) sach_DAO.getallSach();
	assertNotNull(dsSach);
	// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
	assertEquals(10, dsSach.size());
}

public void testGetAllSachTangDanTheoTen() {
	ArrayList<Sach> dsSach = (ArrayList<Sach>) sach_DAO.getallSachTangDanTheoTen();
	assertNotNull(dsSach);
	// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
	assertEquals(10, dsSach.size());
}

public void testGetAllSachGiamDanTheoTen() {
    ArrayList<Sach> dsSach = (ArrayList<Sach>) sach_DAO.getallSachGiamDanTheoTen();
	assertNotNull(dsSach);
	// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
	assertEquals(10, dsSach.size());
}

    public void testGetSachTheoMa(String id) {
        Sach sach = (Sach) sach_DAO.getSachTheoMa(id);
		assertNotNull(sach);
		// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
		assertEquals(10, sach.getMaSach());
    }

    public void testGetSachTheoTen(String id) {
        Sach sach = (Sach) sach_DAO.getSachTheoTen(id);
		assertNotNull(sach);
		// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
		assertEquals(10, sach.getTenSach());
    }

    public void testCreate() {
	Sach sach = new Sach("maSach1", "tenSach1", new Date(), 100.0, "ngonNgu1", "tacGia1", new NhaXuatBan("maNXB1"), new LoaiSach("maLoaiSach1"), true, "urlAnh1");
	boolean isCreated = sach_DAO.create(sach);
	assertTrue(isCreated);
}
public void testUpdate1() {
	Sach sach = new Sach("maSach1", "tenSach1", new Date(), 100.0, "ngonNgu1", "tacGia1", new NhaXuatBan("maNXB1"), new LoaiSach("maLoaiSach1"), true, "urlAnh1");
	boolean isUpdated = sach_DAO.update(sach);
	assertTrue(isUpdated);
}

public void testUpdate() {
	Sach sach = new Sach("maSach1", "tenSach1", new Date(), 100.0, "ngonNgu1", "tacGia1", new NhaXuatBan("maNXB1"), new LoaiSach("maLoaiSach1"), true, "urlAnh1");
	boolean isUpdated = sach_DAO.update(sach);
	assertTrue(isUpdated);
}



    @AfterAll
    public void tearDown() {
        sach_DAO = null;
    }

}