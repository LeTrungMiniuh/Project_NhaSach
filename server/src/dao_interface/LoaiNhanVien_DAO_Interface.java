package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiNhanVien;

public interface LoaiNhanVien_DAO_Interface extends Remote {
    
    List<LoaiNhanVien> getallLoaiNhanVien() throws RemoteException;
    
    void closeEntityManager() throws RemoteException;
}
