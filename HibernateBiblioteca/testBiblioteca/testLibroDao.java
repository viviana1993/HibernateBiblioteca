


import static org.junit.Assert.*;
import model.Libro;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.LibroDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //eseguo i test in ordine alfabetico
public class testLibroDao {

	@Test
	public void Test_1_creoL() {
		LibroDao lDao=new LibroDao();
		assertNotNull(lDao);
		Libro l=new Libro("aaaaa","aaaaaa","gggg",8,8);
		assertNotNull(l);
		boolean bool=lDao.creaLibro(l);
		assertTrue(bool);
		Libro l1=new Libro("bbbbb","bbbb","bb444",8,8);
		assertNotNull(l1);
		boolean bool1=lDao.creaLibro(l1);
		assertTrue(bool1);
		Libro l2=new Libro("cccc","cccc","33333rf",8,8);
		assertNotNull(l2);
		boolean bool2=lDao.creaLibro(l2);
		assertTrue(bool2);


	}


	@Test
	public void Test_2_leggoLibroConId(){
		LibroDao lDao=new LibroDao();
		assertNotNull(lDao);
		Libro l=lDao.leggiLibroConId(1);
		assertNotNull(l);
		assertEquals("gggg", l.getSerialNumber());
	}
	@Test
	public void Test_3_leggoLibroConSN(){
		LibroDao lDao=new LibroDao();
		assertNotNull(lDao);
		Libro l=lDao.leggiLibroConSN("33333rf");
		assertNotNull(l);
		assertEquals(3, l.getId_libro());
	}

	@Test
	public void Test_4_aggiornaLibro(){
		LibroDao lDao=new LibroDao();
		assertNotNull(lDao);
		Libro lv=lDao.leggiLibroConSN("gggg");//libro vecchio
		Libro ln=new Libro("aaaaa","rrr","rrr",8,6);
		boolean bool=lDao.aggiornaLibro(lv,ln);
		assertTrue(bool);
		Libro l=lDao.leggiLibroConSN("rrr");
		assertNotNull(l);
		assertEquals(lv.getId_libro(), l.getId_libro());
		assertNotEquals(lv.getAutore(), l.getAutore());
		assertNotEquals(lv.getSerialNumber(), l.getSerialNumber());
		assertNotEquals(lv.getCopieDisp(), l.getCopieDisp());
		
	}
			
			@Test
			public void Test_5_eliminaLibro(){
				LibroDao lDao=new LibroDao();
				assertNotNull(lDao);
				Libro l=new Libro("ffff","ffff","fff",5,5);
				assertNotNull(l);
				boolean bool1=lDao.creaLibro(l);
				assertTrue(bool1);
				
				boolean bool2=lDao.rimuoviLibro("fff");
				assertTrue(bool2);
				
			}

}
