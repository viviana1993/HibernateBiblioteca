import static org.junit.Assert.*;

import model.Utente;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.UtenteDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //eseguo i test in ordine alfabetico
public class testUtenteDao {

	@Test
	public void Test_1_creoU() {
		UtenteDao uDao=new UtenteDao();
		assertNotNull(uDao);
		Utente u=new Utente("Viviana","Vacirca");
		assertNotNull(u);
		boolean bool=uDao.creaUtente(u);
		assertTrue(bool);
		Utente u1=new Utente("Pako","Pako");
		assertNotNull(u1);
		boolean bool1=uDao.creaUtente(u1);
		assertTrue(bool1);

	}


		@Test
		public void Test_2_leggoUConId(){
			UtenteDao uDao=new UtenteDao();
			assertNotNull(uDao);
			Utente u=uDao.leggiUtenteConId(1);
			assertNotNull(u);
		}
		@Test
		public void Test_3_leggoUConNomeCognome(){
			UtenteDao uDao=new UtenteDao();
			assertNotNull(uDao);
			Utente u=uDao.leggiUtenteConNomeCognome("Viviana","Vacirca");
			assertNotNull(u);
		}
		
		@Test
		public void Test_4_aggiornaUtente(){
			UtenteDao uDao=new UtenteDao();
			assertNotNull(uDao);
			Utente uVecchio=uDao.leggiUtenteConNomeCognome("Viviana","Vacirca");
			Utente uNuovo=new Utente("aaaaaa","aaaaa");
			boolean bool=uDao.aggiornaUtente(uVecchio, uNuovo);
			assertTrue(bool);//verifico di aver aggiornato
			
		}
		
		@Test
		public void Test_5_eliminaUtente(){
			UtenteDao uDao=new UtenteDao();
			assertNotNull(uDao);
			Utente u=uDao.leggiUtenteConNomeCognome("aaaaaa","aaaaa");
			boolean bool=uDao.rimuoviUtente(u);
			assertTrue(bool);
			
		}

}
