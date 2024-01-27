package mx.com.cursodia.gamersapi.GamersAPIREST.beans;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "videojuegos")
public class Videojuego 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cve_vid", nullable = false, length = 20)
	private Long cve_vid;
	
	@Column(name = "tit_vid", nullable = false, length = 25)
	private String tit_vid;
	
	@Column(name = "pre_vid", nullable = false, precision = 10, scale = 2)
	private BigDecimal pre_vid;
	
	@Column(name = "inv_vid", nullable = false)
	private Integer inv_vid;
	
	@ManyToOne(fetch = FetchType.EAGER) //el fetch es la forma en la que recolecta la informacion
								   //utilizando el lazy load, carga solamente lo que se necesita cuando se necesita
	@JoinColumn(name = "cveprov_vid", referencedColumnName = "cve_prov", nullable = false)//indicar la columna la cual se esta enlazando
	@JsonManagedReference //Esta referencia esta siendo controlada (por @JsonBackReference de Proveedor.java)
	private Proveedor proveedor;
	
	public Videojuego() 
	{
		
	}

	//springboot va a gestionar cveprov_vid
	public Videojuego(Long cve_vid, String tit_vid, BigDecimal pre_vid, Integer inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;
		this.inv_vid = inv_vid;
	}

	public Long getCve_vid() {
		return cve_vid;
	}

	public void setCve_vid(Long cve_vid) {
		this.cve_vid = cve_vid;
	}

	public String getTit_vid() {
		return tit_vid;
	}

	public void setTit_vid(String tit_vid) {
		this.tit_vid = tit_vid;
	}

	public BigDecimal getPre_vid() {
		return pre_vid;
	}

	public void setPre_vid(BigDecimal pre_vid) {
		this.pre_vid = pre_vid;
	}

	public Integer getInv_vid() {
		return inv_vid;
	}

	public void setInv_vid(Integer inv_vid) {
		this.inv_vid = inv_vid;
	}

	@Override
	public String toString() {
		return "Videojuego [cve_vid=" + cve_vid + ", tit_vid=" + tit_vid + ", pre_vid=" + pre_vid + ", inv_vid=" + inv_vid + "]";
	}
	
	
	
	
	
}


