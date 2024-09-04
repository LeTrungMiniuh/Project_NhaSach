package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao_interface.LoaiKhachHang_DAO_Interface;
import entity.LoaiKhachHang;
import entity.LoaiSach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LoaiKhachHang_DAO extends UnicastRemoteObject implements LoaiKhachHang_DAO_Interface{
    private EntityManager entityManager;

    public LoaiKhachHang_DAO() throws RemoteException{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<LoaiKhachHang> getallLoaiKhachHang() {
        List<LoaiKhachHang> dsLoaiKhachHang = new ArrayList<>();
        try {
           
            String jpql = "SELECT lkh FROM LoaiKhachHang lkh";
            TypedQuery<LoaiKhachHang> query = entityManager.createQuery(jpql, LoaiKhachHang.class);
            dsLoaiKhachHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiKhachHang;
    }

    public void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
