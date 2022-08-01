package com.xworkz.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.entity.CarEntity;

@Component
public class CarDAOImpl implements CarDAO {

	public CarDAOImpl() {
		System.out.println("CarDAOImpl created");
	}

	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;

	public boolean saveCar(CarEntity carEntity) {

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(carEntity);
			transaction.commit();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;

	}

	@Override
	public CarEntity findCarByName(String name) {
		System.out.println("Invoked findCarByName() from CarDAOImpl");
		Session session = null;
		CarEntity carEntity = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("CarEntity.findCarByName");
			query.setParameter("NAME", name);
			Object object = query.uniqueResult();
			carEntity = (CarEntity) object;

			if (carEntity != null) {
				return carEntity;
			} else {
				System.out.println("CarEntity not found");
			}
		} catch (HibernateException e) {
			System.out.println("HibernateException");
		}

		finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return carEntity;
	}

//----------getAllCarDetails--------------//

	@Override
	public List<CarEntity> getListOfCarEntity() {
		System.out.println("Invoked getListOfCarEntity()");
		Session session = null;
		List<CarEntity> list = null;

		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("CarEntity.getListOfCarEntity");
			list = query.list();
			if (list.size() > 0 && list != null) {
				return list;
			} else {
				System.out.println("Table is Empty");
			}

		} catch (HibernateException e) {
			System.out.println("HibernateException");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return list;
	}

//----------deleteByName------------------------//	
	@Override
	public boolean deleteByName(String name) {
		Session session = null;
		boolean isDelete=false;
		try {
			System.out.println("Invoked deleteByName()");
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createNamedQuery("CarEntity.deleteByName");
			query.setParameter("DELETE_NAME", name);
			int number = query.executeUpdate();
			if (number > 0) {
				isDelete = true;
			
			}
			transaction.commit();
			System.out.println("Successfully Deleted");
		} catch (HibernateException e) {
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}
		return isDelete;
	}

	@Override
	public boolean updateCarEntity(CarEntity carEntity) {
		Session session = null;
	     boolean update = false;
		try {
		     session = sessionFactory.openSession();
		     Transaction transaction = session.beginTransaction();
		     Query query = session.createNamedQuery("CarEntity.updateCarEntity");     
				query.setParameter("NAME", carEntity.getName());
				query.setParameter("COLOUR", carEntity.getColour());
				query.setParameter("SPEED", carEntity.getSpeed());
				query.setParameter("SEATS", carEntity.getSeats());
				query.setParameter("PRICE", carEntity.getPrice());
				query.setParameter("SetByName", carEntity.getName());
				query.executeUpdate();
				transaction.commit();
				update=true;
				System.out.println("updated in DAOImpl");
		} catch (HibernateException e) {
          
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}
		return update;
		
	}

}
