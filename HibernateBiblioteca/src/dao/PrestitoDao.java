package dao;

import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;

public class PrestitoDao {
	// 1- Create 

		public boolean creaPrestito(Prestito p){
			boolean res=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();

				session.persist(p); 

				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();

			}finally{
				session.close();
			}
			return res;

		}
		
		//2-Read (id)
		public Prestito leggiPrestitoConId(long id_p){
			Prestito p=null;
			
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			try{
				
				tx=session.getTransaction();
				tx.begin();
				p=session.get(Prestito.class, id_p);
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return p;
		}
		//3-Read (nome)
		public Prestito leggiPrestitoConBibliotecaUtenteLibro(Biblioteca b,Utente u,Libro l) {
			Prestito p = null;
			
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				Query query = session
						.createQuery("from Prestito where b_id_biblioteca=:idBInserito and l_id_libro=:idLinserito and utente_id_utente=:idUInserito");

				query.setLong("idBInserito", b.getId_biblioteca());
				query.setLong("idLInserito", l.getId_libro());
				query.setLong("idUInserito", u.getId_utente());
				p = (Prestito) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return p;

		}
		
		
		//4-Update
		public boolean aggiornaPrestito(Prestito pVecchio,Prestito pNuovo){
			boolean bool=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			
			try{
				tx=session.getTransaction();
				tx.begin();
				Query q=session.createQuery("from Prestito where id=:idVecchio");
				q.setLong("idVecchio", pVecchio.getId_prestito());
				Prestito p= (Prestito) q.uniqueResult();
				p.setL(pNuovo.getL());
				p.setB(pNuovo.getB());
				p.setUtente(pNuovo.getUtente());
				p.setDataPrest(pNuovo.getDataPrest());
				p.setDataScad(pNuovo.getDataScad());
				
				session.update(p);
				tx.commit();
				bool=true;
			}catch (Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			
			return bool;
		}
		
		//5-delete
		
		public boolean rimuoviPrestito(Prestito p){
			boolean bool=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			Prestito p1=null;
			try{
				tx=session.getTransaction();
				tx.begin();
				Query q=session.createQuery("from Prestito where id_prestito=:id ");
				q.setLong("id", p.getId_prestito());
				p1=(Prestito) q.uniqueResult();
				session.delete(p1);
				tx.commit();
				bool=true;
				
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
			   session.close();
			}
			return bool;
			
		}
}
