package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao_interface.Sach_DAO_Interface;
import entity.KhachHang;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Sach_DAO extends UnicastRemoteObject implements Sach_DAO_Interface {
    
	 private EntityManager entityManager;

	    public Sach_DAO() throws RemoteException {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
	        entityManager = entityManagerFactory.createEntityManager();
	    }

    public List<Sach> getallSachConHang() {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.trangThai = true", Sach.class);
        return query.getResultList();
    }

    public List<Sach> getallSachHetHang() {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.trangThai = false", Sach.class);
        return query.getResultList();
    }

    public List<Sach> getallSach() {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s", Sach.class);
        return query.getResultList();
    }

    public List<Sach> getallSachTangDanTheoTen() {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.trangThai = true ORDER BY s.tenSach ASC", Sach.class);
        return query.getResultList();
    }

    public List<Sach> getallSachGiamDanTheoTen() {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.trangThai = true ORDER BY s.tenSach DESC", Sach.class);
        return query.getResultList();
    }

    public List<Sach> getSachTheoMa(String id) {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.maSach = :id", Sach.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Sach> getSachTheoTen(String ten) {
        TypedQuery<Sach> query = entityManager.createQuery(
            "SELECT s FROM Sach s WHERE s.tenSach = :ten", Sach.class);
        query.setParameter("ten", ten);
        return query.getResultList();
    }

    public boolean create(Sach sach) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sach);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Sach sach) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(sach);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maSach) {
        try {
            Sach sach = entityManager.find(Sach.class, maSach);
            if (sach != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(sach);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateTrangThaiSach(Sach sach) {
        try {
            entityManager.getTransaction().begin();
            sach.setTrangThai(false); 
            entityManager.merge(sach);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateKH(KhachHang kh) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(kh);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
