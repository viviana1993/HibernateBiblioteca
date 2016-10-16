package dao;

import model.Biblioteca;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;

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
	
	
//	public Biblioteca leggiBibliotecaConId(long id_b){
//		Biblioteca b=null;
//		
//		Session session=HibernateUtil.openSession();
//		Transaction tx=null;
//		try{
//			
//			tx=session.getTransaction();
//			tx.begin();
//			b=session.get(Biblioteca.class, id_b);
//			tx.commit();
//			
//		}catch(Exception ex){
//			tx.rollback();
//		}finally{
//			session.close();
//		}
//		
//		return b;
//	}

}
