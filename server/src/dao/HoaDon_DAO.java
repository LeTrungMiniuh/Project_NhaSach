package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import dao_interface.HoaDon_DAO_Interface;
import dao_interface.KhachHang_DAO_Interface;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class HoaDon_DAO extends UnicastRemoteObject implements HoaDon_DAO_Interface{

    private EntityManager entityManager;

    public HoaDon_DAO() throws RemoteException{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    
    public List<HoaDon> getallHoaDon() {
        List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
            String sql = "SELECT hoa.maHoaDon, nv.tenNV, hoa.ngayLapHoaDon, hoa.uuDai, s.tenSach, kh.tenKH, hoa.tongTien " +
                         "FROM HoaDon hoa " +
                         "LEFT JOIN NhanVien nv ON hoa.maNV = nv.maNV " +
                         "LEFT JOIN KhachHang kh ON hoa.maKH = kh.maKH " +
                         "LEFT JOIN Sach s ON hoa.maSach = s.maSach";

            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);

            // Execute the query and map the results to objects
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }


            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }

    
    public List<HoaDon> getallHoaDonDaHuy() {
    	List<HoaDon> dsHoaDon;
        try {
            
       	 String sql = "select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach, KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NOT NULL ORDER BY ngayLapHoaDon asc";
                    
            
            Query query = (Query) entityManager.createNativeQuery(sql);

            // Execute the query and map the results to objects
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }

 
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
    public List<HoaDon> getallHoaDonTrongTuanGanNhat() {
    	 List<HoaDon> dsHoaDon;
         try {
             // Construct native SQL query
        	 String sql = "SELECT hoa.maHoaDon, nv.tenNV, hoa.ngayLapHoaDon, hoa.uuDai, s.tenSach, kh.tenKH, hoa.tongTien " +
                     "FROM HoaDon hoa " +
                     "LEFT JOIN NhanVien nv ON hoa.maNV = nv.maNV " +
                     "LEFT JOIN KhachHang kh ON hoa.maKH = kh.maKH " +
                     "LEFT JOIN Sach s ON hoa.maSach = s.maSach " +
                     "WHERE hoa.ngayLapHoaDon BETWEEN DATEADD(DAY, -DATEDIFF(DAY, 0, GETDATE()), 0) AND DATEADD(DAY, -DATEDIFF(DAY, 0, GETDATE()) + 6, 0)";

             // Create native SQL Query
             Query query = (Query) entityManager.createNativeQuery(sql);

             // Execute the query and map the results to objects
             List<Object[]> resultList = query.getResultList();
             dsHoaDon = new ArrayList<>(resultList.size());
             for (Object[] row : resultList) {
                 HoaDon hoaDon = new HoaDon();
                 hoaDon.setMaHD((String) row[0]); 
                
                 
                 NhanVien nhanVien = new NhanVien(); 
                 nhanVien.setTenNV((String) row[1]);

                
                 
                 hoaDon.setNgayLapHD((Date) row[2]);
                
                 
                 hoaDon.setUuDai((Boolean) row[3]);
                 
                 Sach sach = new Sach();
                 sach.setTenSach((String) row[4]);
                 
                 
                 KhachHang khachHang = new KhachHang();
                 khachHang.setTenKH((String) row[5]); 
                 
                 
                 hoaDon.setTongTien((Double) row[6]);
                 
                 hoaDon.setNguoiLapHD(nhanVien);
                 hoaDon.setTenSach(sach);
                 hoaDon.setKhachHang(khachHang);
                 
                 
                 dsHoaDon.add(hoaDon);
             }

     

             
             if (dsHoaDon.isEmpty()) {
                 return Collections.emptyList();
             }

         } catch (Exception e) {
             e.printStackTrace();
             return Collections.emptyList();
         }

         return dsHoaDon;
    }

	public List<HoaDon> getallHoaDonThangNay(){
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL and MONTH(ngayLapHoaDon) = MONTH(GETDATE()) ORDER BY ngayLapHoaDon asc";
                    
            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);

           
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }


            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
	public List<HoaDon> getallHoaDonNgayHomNay(){
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
        	String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach, KhachHang.tenKH, tongTien from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL and ngayLapHoaDon >= cast(getdate() as date)\r\n"
					+ "and ngayLapHoaDon < cast(getdate()+1 as date) ORDER BY ngayLapHoaDon asc";
            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);

            // Execute the query and map the results to objects
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }

    

            
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
	public List<HoaDon> getHoaDonTheoMa(String id)
	{
		List<HoaDon> dsHoaDon;
        try {
            
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH where HoaDon.trangThai IS NULL and maHoaDon=?";

            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }

    

            
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
	public List<HoaDon> getHoaDonDaHuyTheoMa(String id)
	{
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH where HoaDon.trangThai IS NOT NULL and maHoaDon=?";

            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }

    

            
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
	public List<HoaDon> getGiamGia() {
	    List<HoaDon> dsHoaDon = new ArrayList<>();
	    try {
	        String jpql = "SELECT new HoaDon(hd.maHD, hd.uuDai) FROM HoaDon hd";


	        TypedQuery<HoaDon> query = entityManager.createQuery(jpql, HoaDon.class);

	        List<HoaDon> resultList = query.getResultList();
	        
	        dsHoaDon.addAll(resultList);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsHoaDon;
	}

	public boolean createHoaDonCoKH(HoaDon hd) {
	    try {
	        entityManager.getTransaction().begin();

	        String sqlQuery = "INSERT INTO HoaDon (MaHoaDon, MaNV, NgayLapHoaDon, UuDai, MaSach, MaKH, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        Query query = (Query) entityManager.createNativeQuery(sqlQuery);
	        query.setParameter(1, hd.getMaHD());
	        query.setParameter(2, hd.getNguoiLapHD().getMaNV());
	        query.setParameter(3, hd.getNgayLapHD());
	        query.setParameter(4, hd.isUuDai());
	        query.setParameter(5, hd.getTenSach().getMaSach());
	        
	        if (hd.getKhachHang() != null) {
	            query.setParameter(6, hd.getKhachHang().getMaKH());
	        } else {
	            query.setParameter(6, null);
	        }
	        
	        query.setParameter(7, hd.getTongTien());
	        
	        query.executeUpdate(); 

	        entityManager.getTransaction().commit();
	        System.out.println("Hóa đơn đã được tạo thành công.");
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (entityManager.getTransaction().isActive()) {
	            entityManager.getTransaction().rollback();
	        }
	        return false;
	    }
	}



	public boolean createHoaDonKhongCoKH(HoaDon hd)
	 {
	    try {
	        entityManager.getTransaction().begin(); 

	        String sqlQuery = "INSERT INTO HoaDon (MaHoaDon, MaNV, NgayLapHoaDon, UuDai, MaSach, MaKH, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        Query query = (Query) entityManager.createNativeQuery(sqlQuery);
	        query.setParameter(1, hd.getMaHD());
	        query.setParameter(2, hd.getNguoiLapHD().getMaNV());
	        query.setParameter(3, hd.getNgayLapHD());
	        query.setParameter(4, hd.isUuDai());
	        query.setParameter(5, hd.getTenSach().getMaSach());
	        
	        
	        if (hd.getKhachHang() != null) {
	            query.setParameter(6, hd.getKhachHang().getMaKH());
	        } else {
	            query.setParameter(6, null);
	        }
	        
	        query.setParameter(7, hd.getTongTien());
	        
	        query.executeUpdate(); 

	        entityManager.getTransaction().commit(); 
	        System.out.println("Hóa đơn đã được tạo thành công.");
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (entityManager.getTransaction().isActive()) {
	            entityManager.getTransaction().rollback();
	        }
	        return false;
	    }
	}
	public List<HoaDon> getHoaDonTheoThangVaNam(String month, String year) {
		List<HoaDon> dsHoaDon;
        try {
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai is null and MONTH(ngayLapHoaDon) = ? and YEAR(ngayLapHoaDon) =? ORDER BY ngayLapHoaDon asc ";

            // Create native SQL Query
            Query query = (Query) entityManager.createNativeQuery(sql);
            query.setParameter(1, month);
            query.setParameter(2, year);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD((String) row[0]); 
               
                
                NhanVien nhanVien = new NhanVien(); 
                nhanVien.setTenNV((String) row[1]);

               
                
                hoaDon.setNgayLapHD((Date) row[2]);
               
                
                hoaDon.setUuDai((Boolean) row[3]);
                
                Sach sach = new Sach();
                sach.setTenSach((String) row[4]);
                
                
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKH((String) row[5]); 
                
                
                hoaDon.setTongTien((Double) row[6]);
                
                hoaDon.setNguoiLapHD(nhanVien);
                hoaDon.setTenSach(sach);
                hoaDon.setKhachHang(khachHang);
                
                
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
/*	public List<HoaDon> getTongTienCacHoaDon(String month, String year) {
		List<HoaDon> dsHoaDon;
        try {
            
        	String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE MONTH(ngayLapHoaDon) = ? and YEAR(ngayLapHoaDon) = ? and HoaDon.trangThai IS NULL";
           
            Query query = (Query) entityManager.createNativeQuery(sql);
            query.setParameter(1, month);
            query.setParameter(2, year);
           
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] obj  : resultList) {
            	Double tongTien = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongTien);
                dsHoaDon.add(hoaDon);
            }

    
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }*/
	public List<HoaDon> getTongTienCacHoaDon(String month, String year) {
	    List<HoaDon> dsHoaDon = new ArrayList<>(); 
	    try {
	        String sql = "SELECT SUM(tongTien) FROM HoaDon "
	                     + "WHERE MONTH(ngayLapHoaDon) = ? AND YEAR(ngayLapHoaDon) = ? AND HoaDon.trangThai IS NULL";

	        Query query = (Query) entityManager.createNativeQuery(sql);
	        query.setParameter(1, month);
	        query.setParameter(2, year);

	        List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                double tongTien = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongTien);
                dsHoaDon.add(hoaDon);
            }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); 
	    }
	    return dsHoaDon;
	}


	public List<HoaDon> getTongSoHoaDonNgayHomQua() {
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
        	String sql="select  count(maHoaDon) as tongHoaDon\r\n"
					+ "from HoaDon\r\n"
					+ "where ngayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0)\r\n"
					+ "        AND ngayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0) and HoaDon.trangThai IS NULL";
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                // Chuyển đổi từ kiểu Integer sang kiểu int
                int tongHoaDon = (Integer) obj;
                HoaDon hoaDon = new HoaDon(tongHoaDon);
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
	/*public List<HoaDon> getTongSoHoaDonNgayHomNay() {
		List<HoaDon> dsHoaDon;
        try {
           
        	String sql="select count(maHoaDon) from HoaDon\r\n"
					+ "where cast(ngayLapHoaDon as Date) = cast(getdate() as Date) and HoaDon.trangThai IS NULL";
           
            Query query = (Query) entityManager.createNativeQuery(sql);
           
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object[] row : resultList) {
                HoaDon hoaDon = new HoaDon((int) row[0]);

                dsHoaDon.add(hoaDon);
            }

    

      
            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }*/
	public List<HoaDon> getTongSoHoaDonNgayHomNay() {
	    List<HoaDon> dsHoaDon = new ArrayList<>();
	    try {
	        // Construct native SQL query
	        String sql = "SELECT count(maHoaDon) FROM HoaDon "
	                   + "WHERE cast(ngayLapHoaDon as Date) = cast(getdate() as Date) and HoaDon.trangThai IS NULL";
	        
	        Query query = (Query) entityManager.createNativeQuery(sql);
	        
	        List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                
                int tongHoaDon = (Integer) obj;
                HoaDon hoaDon = new HoaDon(tongHoaDon);
                dsHoaDon.add(hoaDon);
            }


	        if (dsHoaDon.isEmpty()) {
	            return Collections.emptyList(); 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }

	    return dsHoaDon;
	}

	public List<HoaDon> getTongSoHoaDonTuanNay() {
	    List<HoaDon> dsHoaDon;
	    try {
	        String sql = "SELECT count(maHoaDon) as tongHoaDon "
	                     + "FROM HoaDon "
	                     + "WHERE  ngayLapHoaDon >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) "
	                     + "AND ngayLapHoaDon <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate())) and HoaDon.trangThai IS NULL";

	        Query query = (Query) entityManager.createNativeQuery(sql);
	        List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                int tongHoaDon = (Integer) obj;
                HoaDon hoaDon = new HoaDon(tongHoaDon);
                dsHoaDon.add(hoaDon);
            }


	        if (dsHoaDon.isEmpty()) {
	            return Collections.emptyList(); 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); 
	    }

	    return dsHoaDon;
	}

	public List<HoaDon> getTongSoHoaDonThangNay() {
		List<HoaDon> dsHoaDon;
        try {
        	String sql="select count(maHoaDon)\r\n"
					+ "from HoaDon\r\n"
					+ "where MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai IS NULL";
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                int tongHoaDon = (Integer) obj;
                HoaDon hoaDon = new HoaDon(tongHoaDon);
                dsHoaDon.add(hoaDon);
            }


    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
	public List<HoaDon> getTongDoanhThuHomNay() {
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
        	String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "where cast(ngayLapHoaDon as Date) = cast(getdate() as Date) and HoaDon.trangThai IS NULL";
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
            	Double tongDoanhThu  = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongDoanhThu);
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
	public List<HoaDon> getTongDoanhThuHomQua() {
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
        	String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "where ngayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0) AND ngayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0) and HoaDon.trangThai IS NULL";
			
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
                // Chuyển đổi từ kiểu Integer sang kiểu int
            	Double tongDoanhThu  = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongDoanhThu);
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
	public List<HoaDon> getTongDoanhThuTuanNay() {
		List<HoaDon> dsHoaDon;
        try {
            // Construct native SQL query
        	String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE  ngayLapHoaDon >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) AND ngayLapHoaDon <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate())) and HoaDon.trangThai IS NULL";
			
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
            	Double tongDoanhThu  = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongDoanhThu);
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dsHoaDon;
    }
	public List<HoaDon> getTongDoanhThuThangNay() {
		List<HoaDon> dsHoaDon;
        try {
        	String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai IS NULL";
            Query query = (Query) entityManager.createNativeQuery(sql);
            List<Object[]> resultList = query.getResultList();
            dsHoaDon = new ArrayList<>(resultList.size());
            for (Object obj : resultList) {
            	Double tongDoanhThu  = (Double) obj;
                HoaDon hoaDon = new HoaDon(tongDoanhThu);
                dsHoaDon.add(hoaDon);
            }

    

            if (dsHoaDon.isEmpty()) {
                return Collections.emptyList(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }

        return dsHoaDon;
    }
	public boolean xoaHD(HoaDon hd) {
	    EntityTransaction transaction = null;
	    try {
	        transaction = entityManager.getTransaction();
	        transaction.begin();
	        
	        int n = entityManager.createQuery("UPDATE HoaDon hd SET hd.trangThai = true WHERE hd.maHD = :maHD")
	                .setParameter("maHD", hd.getMaHD())
	                .executeUpdate();
	        
	        transaction.commit();
	        
	        return n > 0;
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	 public List<Object[]> getHoaDonByCurrentDay() {
		  try {
				String queryString="select ngayLapHoaDon,tongTien  from HoaDon join NhanVien on NhanVien.maNV=HoaDon.maNV join Sach on HoaDon.maSach=Sach.maSach WHERE MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai is null ORDER BY ngayLapHoaDon asc ";

	            Query query = (Query) entityManager.createNativeQuery(queryString);
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

 public List<Object[]> getHoaDonByMonthAndYear(String thang, String nam) {
     String queryString = "SELECT h.ngayLapHoaDon, h.tongTien FROM HoaDon h WHERE MONTH(h.ngayLapHoaDon) = :thang AND YEAR(h.ngayLapHoaDon) = :nam AND h.trangThai IS NULL ORDER BY h.ngayLapHoaDon ASC";
     Query query = (Query) entityManager.createNativeQuery(queryString);
     query.setParameter("thang", thang);
     query.setParameter("nam", nam);
     return query.getResultList();
 }
	
	public void close() {
        if (entityManager != null) {
        	entityManager.close();
        }
    }
}
