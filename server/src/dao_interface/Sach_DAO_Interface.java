package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.KhachHang;
import entity.Sach;

public interface Sach_DAO_Interface extends Remote {
    
    List<Sach> getallSachConHang() throws RemoteException;
    
    List<Sach> getallSachHetHang() throws RemoteException;
    
    List<Sach> getallSach() throws RemoteException;
    
    List<Sach> getallSachTangDanTheoTen() throws RemoteException;
    
    List<Sach> getallSachGiamDanTheoTen() throws RemoteException;
    
    List<Sach> getSachTheoMa(String id) throws RemoteException;
    
    List<Sach> getSachTheoTen(String ten) throws RemoteException;
    
    boolean create(Sach sach) throws RemoteException;
    
    boolean update(Sach sach) throws RemoteException;
    
    boolean delete(String maSach) throws RemoteException;
    
    boolean updateTrangThaiSach(Sach sach) throws RemoteException;
    
    boolean updateKH(KhachHang kh) throws RemoteException;
}
