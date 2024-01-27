package mx.com.cursodia.gamersapi.GamersAPIREST.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name= "proveedores")
public class Proveedor 
{
	@Id									//que no ↓ se pueden repetir
	@GeneratedValue(strategy = GenerationType.IDENTITY) //instrucciones para el framework para que sepa como generar mas entidades
	@Column(name = "cve_prov")
	private Integer cve_prov;
	
	@Column(name = "nom_prov", nullable = false, length = 25)
	private String nom_prov;
	
	@Column(name = "email_prov", length = 20)
	private String email_prov;
	
	@Column(name = "tel_prov", length = 15)
	private String tel_prov;
	
	@OneToMany(mappedBy = "proveedor")
	//esta anotacion es para decirle al framework que hacer y no estar buscando constantemente en un ciclo
	@JsonBackReference //esto va a controlar la referencia JsonManagedReference que se encuentra en Videojuego.java
	private List<Videojuego> videojuegos;

	public Proveedor() 
	{
		super();
	}

	public Proveedor(Integer cve_prov, String nom_prov, String email_prov, String tel_prov) 
	{
		super();
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
		this.email_prov = email_prov;
		this.tel_prov = tel_prov;
	}


	public Integer getCve_prov() {
		return cve_prov;
	}

	public void setCve_prov(Integer cve_prov) {
		this.cve_prov = cve_prov;
	}

	public String getNom_prov() {
		return nom_prov;
	}

	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}

	public String getEmail_prov() {
		return email_prov;
	}

	public void setEmail_prov(String email_prov) {
		this.email_prov = email_prov;
	}

	public String getTel_prov() {
		return tel_prov;
	}

	public void setTel_prov(String tel_prov) {
		this.tel_prov = tel_prov;
	}

	
	
}
