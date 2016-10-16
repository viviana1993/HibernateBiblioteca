import static org.junit.Assert.*;
import model.Biblioteca;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.BibliotecaDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //eseguo i test in ordine alfabetico
public class testBibliotecaDao {


	@Test
	public void Test_1_creoB() {
		BibliotecaDao bDao=new BibliotecaDao();
		assertNotNull(bDao);
		Biblioteca b=new Biblioteca("Viviana");
		assertNotNull(b);
		boolean bool=bDao.creaBiblioteca(b);
		assertTrue(bool);
		Biblioteca b1=new Biblioteca("aaaa");
		assertNotNull(b1);
		boolean bool1=bDao.creaBiblioteca(b1);
		assertTrue(bool1);
		Biblioteca b2=new Biblioteca("bbbbb");
		assertNotNull(b2);
		boolean bool2=bDao.creaBiblioteca(b2);
		assertTrue(bool2);
		Biblioteca b3=new Biblioteca("cccc");
		assertNotNull(b3);
		boolean bool3=bDao.creaBiblioteca(b3);
		assertTrue(bool3);

	}


		@Test
		public void Test_2_leggoBConId(){
			BibliotecaDao bDao=new BibliotecaDao();
			assertNotNull(bDao);
			Biblioteca b=bDao.leggiBibliotecaConId(1);
			assertNotNull(b);
		}
		@Test
		public void Test_3_leggoBConNome(){
			BibliotecaDao bDao=new BibliotecaDao();
			assertNotNull(bDao);
			Biblioteca b=bDao.leggiBibliotecaConNome("Viviana");
			assertNotNull(b);
		}
		
		@Test
		public void Test_4_aggiornaBibl(){
			BibliotecaDao bDao=new BibliotecaDao();
			assertNotNull(bDao);
			Biblioteca b=bDao.leggiBibliotecaConNome("Viviana");
			boolean bool=bDao.aggiornaBiblioteca("Viviana", "Paki");
			assertTrue(bool);//verifico di aver aggiornato
			assertNotEquals(b.getNome(),"Paki");//verifico che il nome della biblioteca non sia rimasto uguale
			
		}
		
		@Test
		public void Test_5_eliminaBibl(){
			BibliotecaDao bDao=new BibliotecaDao();
			assertNotNull(bDao);
			boolean bool=bDao.rimuoviBiblioteca("Paki");
			assertTrue(bool);
			
		}
}
