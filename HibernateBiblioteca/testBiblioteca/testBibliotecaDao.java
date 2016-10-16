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

	}

	//	@Test
	//	public static void Test_2_creoB() {
	//		
	//		
	//		
	//		
	//	}


	//	@Test
	//	public void Test_2_leggoBConId(){
	//		BibliotecaDao bDao=new BibliotecaDao();
	//		assertNotNull(bDao);
	//		Biblioteca b=bDao.leggiBibliotecaConId(id_b);
	//	}

}
