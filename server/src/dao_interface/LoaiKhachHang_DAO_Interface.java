package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiKhachHang;

public interface LoaiKhachHang_DAO_Interface extends Remote {
    
    List<LoaiKhachHang> getallLoaiKhachHang() throws RemoteException;
    
    void closeEntityManager() throws RemoteException;
}
