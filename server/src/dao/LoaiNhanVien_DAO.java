package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao_interface.LoaiNhanVien_DAO_Interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import entity.LoaiNhanVien;

public class LoaiNhanVien_DAO extends UnicastRemoteObject implements LoaiNhanVien_DAO_Interface {
    private EntityManager entityManager;

    public LoaiNhanVien_DAO() throws RemoteException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<LoaiNhanVien> getallLoaiNhanVien() {
        List<LoaiNhanVien> dsLoaiNhanVien = new ArrayList<>();
        try {
            String jpql = "SELECT lnv FROM LoaiNhanVien lnv";
            TypedQuery<LoaiNhanVien> query = entityManager.createQuery(jpql, LoaiNhanVien.class);
            dsLoaiNhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiNhanVien;
    }

    public void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
