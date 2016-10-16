package dao;

import model.Biblioteca;

import HibernateUtil.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class BibliotecaDao {
	// 1- Create 

	public boolean creaBiblioteca(Biblioteca b){
		boolean res=false;
		Session session=HibernateUtil.openSession();
		Transaction tx=null;

		try{

			tx=session.getTransaction();

			tx.begin();

			session.persist(b); 

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
	public Biblioteca leggiBibliotecaConId(long id_b){
		Biblioteca b=null;
		
		Session session=HibernateUtil.openSession();
		Transaction tx=null;
		try{
			
			tx=session.getTransaction();
			tx.begin();
			b=session.get(Biblioteca.class, id_b);
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return b;
	}
	//3-Read (nome)
	public Biblioteca leggiBibliotecaConNome(String nome) {
		Biblioteca b = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			Query query = session
					.createQuery("from Biblioteca where nome=:nomeInserito ");

			query.setString("nomeInserito", nome);

			b = (Biblioteca) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return b;

	}
	
	
	//4-Update
	public boolean aggiornaBiblioteca(String nomeVecchio,String nomeNuovo){
		boolean bool=false;
		Session session=HibernateUtil.openSession();
		Transaction tx=null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			Query q=session.createQuery("from Biblioteca where nome=:nomeVecchio");
			q.setString("nomeVecchio", nomeVecchio);
			Biblioteca b = (Biblioteca) q.uniqueResult();
			b.setNome(nomeNuovo);
			session.update(b);
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
	
	public boolean rimuoviBiblioteca(String nome){
		boolean bool=false;
		Session session=HibernateUtil.openSession();
		Transaction tx=null;
		Biblioteca b=null;
		try{
			tx=session.getTransaction();
			tx.begin();
			Query q=session.createQuery("from Biblioteca where nome=:nome ");
			q.setString("nome", nome);
			b=(Biblioteca) q.uniqueResult();
			session.delete(b);
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
