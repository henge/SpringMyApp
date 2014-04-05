package jp.springbook.springmyapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MyDataDaoImpl implements MyDataDao<MyData> {

	private static final long serialVersionUID = -7541195027476465749L;
	
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("persistenceUnit");

	@Override
	public List<MyData> getAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from MyData");
		List<MyData> list = query.getResultList();
		manager.close();
		return list;
	}

	@Override
	public void add(MyData data) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(data);
		transaction.commit();
		manager.close();
	}

	@Override
	public void update(MyData data) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(data);
		transaction.commit();
		manager.close();
	}

	@Override
	public void delete(MyData data) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		MyData entity = manager.merge(data);
		manager.remove(entity);
		transaction.commit();
		manager.close();
	}

	@Override
	public void delete(long id) {
		delete(findById(id));
	}

	@Override
	public MyData findById(long id) {
		EntityManager manager = factory.createEntityManager();
		return (MyData) manager.createQuery("from MyData where id = " + id)
				.getSingleResult();
	}

	@Override
	public List<MyData> findByName(String name) {
		EntityManager manager = factory.createEntityManager();
		return (List<MyData>) manager.createQuery(
				"from MyData where name = " + name).getResultList();
	}
}
