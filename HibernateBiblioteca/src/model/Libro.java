package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
public class Libro {

	//attributi libro
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_libro;
	
	@Column(name="titolo")
	private String titolo;
	
	@Column(name="autore")
	private String autore;
	
	@Column(name="SN")
	private String serialNumber;
	
	@Column(name="Tot")
	private int copieTot;
	
	@Column(name="Disp")
	private int copieDisp;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="l",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> prestato=new HashSet<Prestito>();

	
	@ManyToMany
	private Set<Biblioteca> biblioteche=new HashSet<Biblioteca>();
	// costruttore vuoto


	public Libro() {
		this.titolo = "";
		this.autore = "";
		this.serialNumber = "";
		this.copieTot = 0;
		this.copieDisp= 0;
	}

	//costruttore completo
	public Libro(String titolo,String autore,String serialNumber,int copieTot,int copieDisp) {
		this.setTitolo(titolo);
		this.setAutore(autore);
		this.setSerialNumber(serialNumber);
		this.setCopieTot(copieTot);
		this.setCopieDisp(copieDisp);
	}
	//metodo

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getCopieTot() {
		return copieTot;
	}

	public void setCopieTot(int copieTot) {
		this.copieTot = copieTot;
	}

	public int getCopieDisp() {
		return copieDisp;
	}

	public void setCopieDisp(int copieDisp) {
		this.copieDisp = copieDisp;
	}

	public long getId_libro() {
		return id_libro;
	}

	public void setId_libro(long id_libro) {
		this.id_libro = id_libro;
	}

	public Set<Prestito> getPrestato() {
		return prestato;
	}

	public void setPrestato(Set<Prestito> prestato) {
		this.prestato = prestato;
	}

	public Set<Biblioteca> getBiblioteche() {
		return biblioteche;
	}

	public void setBiblioteche(Set<Biblioteca> biblioteche) {
		this.biblioteche = biblioteche;
	}

	
	
	

}
