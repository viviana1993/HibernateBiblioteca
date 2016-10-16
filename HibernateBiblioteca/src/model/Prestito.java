package model;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Prestito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_prestito;
	
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Libro l;
	
	@ManyToOne
	private Biblioteca b;
	
	@Column(name="effettuato")
	private Date dataPrest;
	@Column(name="scadenza")
	private Date dataScad;
	

	public Prestito() {
		this.utente = null;
		this.l = null;
		this.b=null;
		
	}


	public Prestito(Utente utente, Libro l,Biblioteca b, Date dataPrest) {
		
		this.utente = utente;
		this.l = l;
		this.dataPrest = dataPrest;
		this.b=b;
		calcolaScadenza(dataPrest);
		
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public Libro getL() {
		return l;
	}


	public void setL(Libro l) {
		this.l = l;
	}
	
	public long getId_prestito() {
		return id_prestito;
	}
	public void setId_prestito(long id_prestito) {
		this.id_prestito = id_prestito;
	}


	public Biblioteca getB() {
		return b;
	}


	public void setB(Biblioteca b) {
		this.b = b;
	}

	public Date getDataPrest() {
		return dataPrest;
	}


	public void setDataPrest(Date dataPrest) {
		this.dataPrest = dataPrest;
	}


	public Date getDataScad() {
		return dataScad;
	}


	public void setDataScad(Date dataScad) {
		this.dataScad = dataScad;
	}
	
	//creo metodo per calcolare scadenza prestito
	
	private Date calcolaScadenza(Date dataPrest){
		
		Calendar data = Calendar.getInstance();//inizializzo una variaboile calendar
		data.setTime(dataPrest);//passo la data in cui è stato effettuato il prestito
		data.add(Calendar.DATE, 14);//aggiungo 14 giorni
		return dataScad;//ritorno la scadenza
	}
	
}
