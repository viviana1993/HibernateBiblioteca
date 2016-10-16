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
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_utente;
	
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="utente",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set <Prestito> listaPrestiti=new HashSet<Prestito>();
	
	
	@ManyToMany
	private Set <Biblioteca> biblioteche=new HashSet<>();


	public Utente(String nome, String cognome) {
		
		this.nome = nome;
		this.cognome = cognome;
	
	}
	
	public Utente() {
		
		this.nome =" ";
		this.cognome = " ";
	
	}

	public long getId_utente() {
		return id_utente;
	}

	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Set<Prestito> getListaPrestiti() {
		return listaPrestiti;
	}

	public void setListaPrestiti(Set<Prestito> listaPrestiti) {
		this.listaPrestiti = listaPrestiti;
	}

	public Set<Biblioteca> getBiblioteche() {
		return biblioteche;
	}

	public void setBiblioteche(Set<Biblioteca> biblioteche) {
		this.biblioteche = biblioteche;
	}
	
	
	
	
	
}
