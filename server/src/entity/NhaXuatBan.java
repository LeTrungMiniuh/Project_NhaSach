package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "NhaXuatBan")
public class NhaXuatBan implements Serializable{

    @Id
    @Column(name = "maNXB", columnDefinition = "nvarchar(200)")
    private String maNXB;

    @Column(name = "tenNXB", columnDefinition = "nvarchar(200)")
    private String tenNXB;

	public NhaXuatBan(String maNXB, String tenNXB) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
	}
	public NhaXuatBan() {
		super();
	}
	public NhaXuatBan(String maNXB) {
		this(maNXB,"");
	}
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	
}
