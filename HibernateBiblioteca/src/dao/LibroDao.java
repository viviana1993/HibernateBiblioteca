 package dao;

import model.Libro;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import HibernateUtil.HibernateUtil;

public class LibroDao {
	// 1- Create 

		public boolean creaLibro(Libro l){
			boolean res=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();

				session.persist(l); 

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
		public Libro leggiLibroConId(long id_l){
			Libro l=null;
			
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			try{
				
				tx=session.getTransaction();
				tx.begin();
				l=session.get(Libro.class, id_l);
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return l;
		}
		//3-Read (SN)
		public Libro leggiLibroConSN(String sn) {
			Libro l= null;

			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				Query query = session
						.createQuery("from Libro where SN=:SNInserito ");

				query.setString("SNInserito", sn);

				l = (Libro) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return l;

		}
		
		
		//4-Update
		public boolean aggiornaLibro(Libro libroVecchio,Libro libroNuovo){
			boolean bool=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			
			try{
				tx=session.getTransaction();
				tx.begin();
				Query q=session.createQuery("from Libro where id_libro=:idVecchio");
				q.setLong("idVecchio", libroVecchio.getId_libro());
				Libro l = (Libro) q.uniqueResult();
				
				l.setTitolo(libroNuovo.getTitolo());
				l.setAutore(libroNuovo.getAutore());
				l.setSerialNumber(libroNuovo.getSerialNumber());
				l.setCopieDisp(libroNuovo.getCopieDisp());
				l.setCopieTot(libroNuovo.getCopieTot());
				
				session.update(l);
				
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
		
		public boolean rimuoviLibro(String sn){
			boolean bool=false;
			Session session=HibernateUtil.openSession();
			Transaction tx=null;
			
			try{
				tx=session.getTransaction();
				tx.begin();
				Query q=session.createQuery("from Libro where SN=:SNInserito");
				q.setString("SNInserito", sn);
				Libro l=(Libro) q.uniqueResult();
				session.delete(l);
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
