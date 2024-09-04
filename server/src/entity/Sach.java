package entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Sach")
public class Sach implements Serializable{

    @Id
    @Column(name = "maSach", columnDefinition = "nvarchar(200)")
    private String maSach;

    @Column(name = "tenSach", columnDefinition = "nvarchar(200)")
    private String tenSach;

    @Column(name = "namXuatBan")
    private Date namXB;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "ngonNgu", columnDefinition = "nvarchar(200)")
    private String ngonNgu;

    @Column(name = "tacGia", columnDefinition = "nvarchar(200)")
    private String tacgia;

    @ManyToOne
    @JoinColumn(name = "maNXB")
    private NhaXuatBan nhaxuatban;

    @ManyToOne
    @JoinColumn(name = "maLoaiSach")
    private LoaiSach loaisach;

    @Column(name = "trangThai")
    private boolean trangThai;

    @Column(name = "urlAnh", columnDefinition = "nvarchar(200)")
    private String urlAnh;
    
    

    public Sach() {
		super();
	}
    public Sach(String maSach, String tenSach, Date namXB, double donGia, String ngonNgu, String tacgia,
			NhaXuatBan nhaxuatban, LoaiSach loaisach, boolean trangThai, String urlAnh) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.namXB = namXB;
		this.donGia = donGia;
		this.ngonNgu = ngonNgu;
		this.tacgia = tacgia;
		this.nhaxuatban = nhaxuatban;
		this.loaisach = loaisach;
		this.trangThai= trangThai;
		this.urlAnh=urlAnh;
	}
    
    
	
	public Sach(String maSach, String tenSach) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
	}
	
	public String getUrlAnh() {
		return urlAnh;
	}
	public void setUrlAnh(String urlAnh) {
		this.urlAnh = urlAnh;
	}
	public Sach(String maSach)
	{
		this(maSach, "");
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public Date getNamXB() {
		return namXB;
	}
	public void setNamXB(Date namXB) {
		this.namXB = namXB;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public NhaXuatBan getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(NhaXuatBan nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public LoaiSach getLoaisach() {
		return loaisach;
	}
	public void setLoaisach(LoaiSach loaisach) {
		this.loaisach = loaisach;
	}

}
