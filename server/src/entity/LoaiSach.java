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

@Entity
@Table(name = "LoaiSach")
public class LoaiSach implements Serializable{

    @Id
    @Column(name = "maLoaiSach", columnDefinition = "nvarchar(200)")
    private String maLoaiSach;

    @Column(name = "tenLoaiSach", columnDefinition = "nvarchar(200)")
    private String tenLoaiSach;

	public LoaiSach(String maLoaiSach, String tenLoaiSach) {
		super();
		this.maLoaiSach = maLoaiSach;
		this.tenLoaiSach = tenLoaiSach;
	}
	public LoaiSach() {
		super();
	}
	public LoaiSach(String maLoaiSach) {
		this(maLoaiSach, "");
	}
	public String getMaLoaiSach() {
		return maLoaiSach;
	}
	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	public String getTenLoaiSach() {
		return tenLoaiSach;
	}
	public void setTenLoaiSach(String tenLoaiSach) {
		this.tenLoaiSach = tenLoaiSach;
	}
}
