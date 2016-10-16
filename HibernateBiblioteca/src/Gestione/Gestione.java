package Gestione;

//import java.util.Date;
//import java.util.List;
//
//import Biblioteca.Biblioteca;
//import Biblioteca.Libro;
//import Biblioteca.Prestito;
//import Biblioteca.Utente;

public class Gestione {
//	//metodo 1
//	public int registraLibro(Biblioteca b,String titolo,String autore,String serialNumber,int cp){
//
//
//		Libro a=null;//creo variabili locali
//
//		List<Libro> ListaLibri=b.getListaLibri();//prendo la lista libri della biblioteca b
//
//
//
//		int numeroDaRitornare=0;
//		for(Libro l:ListaLibri)
//
//		{
//
//			if(l.getTitolo().equals(titolo)&&l.getAutore().equals(autore)&&l.getSerialNumber().equals(serialNumber)) a=l;
//		}//chiudo for
//
//		if(a==null){
//			Libro libroNuovo=new Libro(titolo,autore,serialNumber,cp,cp);
//			ListaLibri.add(libroNuovo);//se nn è all'interno della lista inserisco il libro nuovo
//
//			numeroDaRitornare=cp;
//		}else
//
//		{
//			int copieTotVecchio=a.getCopieTot();
//			int copieDispVecchio=a.getCopieDisp(); 
//
//			copieTotVecchio+=cp;//incremento di cp
//			copieDispVecchio+=cp;
//			a.setCopieTot(copieTotVecchio);
//			a.setCopieDisp(copieDispVecchio);
//			numeroDaRitornare=copieTotVecchio;
//		}
//
//
//
//
//
//		return numeroDaRitornare;
//
//	}
//
//
//
//
//
//
//
//	//metodo2
//
//	public boolean registraUtente(Biblioteca b,String nome,String cognome){
//
//		boolean risultato=false;
//		Utente utemp=null;
//
//		List<Utente> ListaUtenti=b.getListaUtenti();
//		for(Utente u:ListaUtenti){
//
//			if(u.getNome().equals(nome) && u.getCognome().equals(cognome)){
//				utemp=u;
//
//			}
//		}
//
//		if(utemp==null){
//			Utente uNuovo = new Utente(nome,cognome);
//			ListaUtenti.add(uNuovo);
//			risultato=true;
//		}
//
//
//
//		return risultato;
//
//	}
//
//
//
//
//	//metodo3
//	public boolean prestaLibro(Biblioteca b,String nome,String cognome,String titolo,String autore){
//
//		boolean prestito=false;
//		Utente utemp=null;
//		Libro lp=null;
//		List<Utente> ListaUtenti=b.getListaUtenti();
//		List<Libro> ListaLibri=b.getListaLibri();
//
//		for(Utente u:ListaUtenti){
//			if(u.getNome().equals(nome)&&u.getCognome().equals(cognome))utemp=u;
//		}
//		for(Libro l:ListaLibri){
//			if(l.getTitolo().equals(titolo)&&l.getAutore().equals(autore))lp=l;
//		}
//
//		if(utemp!=null && lp!=null){
//
//			if(utemp.getLibriInPrestito().size()<3){
//				int cd = lp.getCopieDisp();
//
//				if(cd>0){
//
//
//
//					cd-=1;
//					lp.setCopieDisp(cd);
//					Date data=new Date();//inizializzo alla data in cui ho effettuato il prestito Date(0) darebbe 1 gennaio 1970
//					Prestito p=new Prestito(data,utemp,lp);
//					utemp.InserisciPrestito(p);
//
//					b.InserisciPrestito(p);
//					prestito=true;}
//			}
//		}
//
//
//
//
//		return prestito;   
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//	//metodo4
//	public boolean restituisciLibro(Biblioteca b,String nome,String cognome,String titolo,String autore){
//
//		boolean restituzione=false;
//		Utente utemp=null;
//		Prestito p3=null;
//
//
//		for(Utente u:b.getListaUtenti()){
//			if(u.getNome().equals(nome)&&u.getCognome().equals(cognome))utemp=u;
//		}
//		for(Prestito p1:b.getListaPrestiti()){
//			if(p1.getL().getTitolo().equals(titolo)&&p1.getL().getAutore().equals(autore))p3=p1;
//		}
//
//		if(utemp!=null && p3!=null){
//
//
//			int cd = p3.getL().getCopieDisp();
//			int ct=p3.getL().getCopieTot();	
//			Prestito pp=null;
//			if(cd<ct){
//				for(Prestito p:utemp.getLibriInPrestito()){
//					if(p.getL().getTitolo().equals(titolo)&& p.getL().getAutore().equals(autore)) pp=p;
//
//				}
//				if(p3!=null)b.getListaPrestiti().remove(p3);
//				if(pp!=null)utemp.getLibriInPrestito().remove(pp);
//
//				cd+=1;
//
//				p3.getL().setCopieDisp(cd);
//
//				p3.getL().setCopieTot(ct);
//
//				restituzione=true;
//			}
//
//
//
//		}
//
//
//
//
//
//
//		return restituzione;   
//
//
//
//


	}
//}
