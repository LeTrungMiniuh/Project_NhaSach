package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVien_DAO_Interface extends Remote {
    
    List<NhanVien> getallNhanVien() throws RemoteException;
    
    List<NhanVien> getallNhanVienTangDanTheoTen() throws RemoteException;
    
    List<NhanVien> getallNhanVienGiamDanTheoTen() throws RemoteException;
    
    boolean createNV(NhanVien nv) throws RemoteException;
    
    boolean updateNV(NhanVien nv) throws RemoteException;
    
    List<NhanVien> getNhanVienTheoMa(String id) throws RemoteException;
    
    List<NhanVien> getNhanVienTheoTen(String tenNV) throws RemoteException;
    
    boolean updateTrangThaiNV(NhanVien nv) throws RemoteException;
    
    boolean updateMatKhau(NhanVien nv) throws RemoteException;
    
    public NhanVien getNhanVienByCredentials(String username, String password)throws RemoteException;
    
}
