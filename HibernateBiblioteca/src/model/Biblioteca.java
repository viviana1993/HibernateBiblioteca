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

public class Biblioteca {
	//attributi
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_biblioteca;
	
	
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="biblioteche",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Utente> ListaUtenti=new HashSet<Utente>();
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="biblioteche",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Libro> ListaLibri=new HashSet<Libro>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="b",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> ListaPrestiti=new HashSet<Prestito>();

	


	//costruttore
	public Biblioteca(){

		this.nome = "";
	}


	public Biblioteca( String nome) {
		
		this.nome = nome;
	}




	//metodi
	public long getId_biblioteca() {
		return id_biblioteca;
	}


	public void setId_biblioteca(long id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<Utente> getListaUtenti() {
		return ListaUtenti;
	}


	public void setListaUtenti(Set<Utente> listaUtenti) {
		ListaUtenti = listaUtenti;
	}


	public Set<Libro> getListaLibri() {
		return ListaLibri;
	}


	public void setListaLibri(Set<Libro> listaLibri) {
		ListaLibri = listaLibri;
	}
	
	public Set<Prestito> getListaPrestiti() {
		return ListaPrestiti;
	}


	public void setListaPrestiti(Set<Prestito> listaPrestiti) {
		ListaPrestiti = listaPrestiti;
	}
	
	//metodi per inserire libri e utenti

	public void InserisciUtente(Utente u1){
		ListaUtenti.add(u1);

	}
	public void InserisciLibro(Libro l){
		ListaLibri.add(l);

	}

	public void InserisciPrestito(Prestito p){
		ListaPrestiti.add(p);

	}
	
}
