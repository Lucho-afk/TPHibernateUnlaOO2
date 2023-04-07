package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cuota;

public class CuotaDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de datos de cuota", he);
	}

	public int agregar(Cuota obj) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(obj).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Cuota objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Cuota traer(long idCuota) throws HibernateException {
		Cuota objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cuota) session.get(Cuota.class, idCuota);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cuota traer(int nroCuota, long idPrestamo) throws HibernateException {
		Cuota objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cuota) session
					.createQuery("from Cuota c where c.nroCuota=" + nroCuota + " and c.idPrestamo=" + idPrestamo)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}
