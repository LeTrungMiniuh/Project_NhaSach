package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.KhachHang;

public interface KhachHang_DAO_Interface extends Remote {
    
    List<KhachHang> getallKhachHang() throws RemoteException;
    
    List<KhachHang> getallKhachHangTangDanTheoTen() throws RemoteException;
    
    List<KhachHang> getallKhachHangGiamDanTheoTen() throws RemoteException;
    
    KhachHang getKhachHangTheoMa(String id) throws RemoteException;
    
    List<KhachHang> getKhachHangTheoTen(String name) throws RemoteException;
    
    boolean createKH(KhachHang kh) throws RemoteException;
    
    boolean deleteKH(String id) throws RemoteException;
    
    boolean updateKH(KhachHang kh) throws RemoteException;
}
