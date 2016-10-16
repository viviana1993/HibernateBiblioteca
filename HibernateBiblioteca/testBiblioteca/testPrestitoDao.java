import static org.junit.Assert.*;

import java.util.Date;

import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.BibliotecaDao;
import dao.LibroDao;
import dao.PrestitoDao;
import dao.UtenteDao;


public class testPrestitoDao {
	static Biblioteca b;
	static Utente u;
	static Libro l;
	static Prestito p;
	
@BeforeClass
	public static void test(){
	UtenteDao uDao=new UtenteDao();//creo utente
	assertNotNull(uDao);
	Utente u=new Utente("ccccc","ccccc");
	assertNotNull(u);
	boolean bool=uDao.creaUtente(u);
	assertTrue(bool);
	
	
	BibliotecaDao bDao=new BibliotecaDao();//creo biblioteca
	assertNotNull(bDao);
	Biblioteca b=new Biblioteca("Viviana");
	assertNotNull(b);
	bool=bDao.creaBiblioteca(b);
	assertTrue(bool);
	
	
	LibroDao lDao=new LibroDao();
	assertNotNull(lDao);
	Libro l=new Libro("aaaaa","aaaaaa","gggg",8,8);
	assertNotNull(l);
	bool=lDao.creaLibro(l);
	assertTrue(bool);
	
	Date date=new Date();
	PrestitoDao pDao=new PrestitoDao();
	assertNotNull(pDao);
	Prestito p=new Prestito(u,l,b,date);
	assertNotNull(p);
	bool=pDao.creaPrestito(p);
	assertTrue(bool);
	
	
}

			@Test
			public void Test_2_leggoPConId(){
				PrestitoDao pDao=new PrestitoDao();
				assertNotNull(pDao);
				Prestito p=pDao.leggiPrestitoConId(4);
				assertNotNull(p);
			}
			@Test
			public void Test_3_leggoPConUBL(){
				
				BibliotecaDao bDao=new BibliotecaDao();
				assertNotNull(bDao);
				Biblioteca b1=bDao.leggiBibliotecaConNome("Viviana");
				assertNotNull(b1);
				
				UtenteDao uDao=new UtenteDao();
				assertNotNull(uDao);
				Utente u1=uDao.leggiUtenteConNomeCognome("ccccc","ccccc");
				assertNotNull(u1);
				
				LibroDao lDao=new LibroDao();
				assertNotNull(lDao);
				Libro l2=lDao.leggiLibroConSN("gggg");
				assertNotNull(l2);
				
				PrestitoDao pDao=new PrestitoDao();
				assertNotNull(pDao);
				Prestito p1=pDao.leggiPrestitoConBibliotecaUtenteLibro(b1, u1, l2);
				assertNotNull(p1);
			}
//			
//			@Test
//			public void Test_4_aggiornaBibl(){
//				BibliotecaDao bDao=new BibliotecaDao();
//				assertNotNull(bDao);
//				Biblioteca b=bDao.leggiBibliotecaConNome("Viviana");
//				boolean bool=bDao.aggiornaBiblioteca("Viviana", "Paki");
//				assertTrue(bool);//verifico di aver aggiornato
//				assertNotEquals(b.getNome(),"Paki");//verifico che il nome della biblioteca non sia rimasto uguale
//				
//			}
//			
//			@Test
//			public void Test_5_eliminaBibl(){
//				BibliotecaDao bDao=new BibliotecaDao();
//				assertNotNull(bDao);
//				boolean bool=bDao.rimuoviBiblioteca("Paki");
//				assertTrue(bool);
//				
	//	}
//	}

}
