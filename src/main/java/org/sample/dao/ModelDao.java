package org.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public abstract class ModelDao<T> {

	private Class<T> clazz;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public ModelDao() {
		this.clazz = getClassName();
	}
	public abstract Class<T> getClassName();
	
	public T create(T object){
		entityManager.persist(object);
		return object;
	}
	
	public T read(Object id){
		return entityManager.find(clazz, id);
	}
	
	public T update(T object){
		return entityManager.merge(object);
	}
	
	public Object delete(Object id){
		T object = this.read(id);
		entityManager.remove(object);
		return id;
	}
	
	public List<T> list(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		cq.from(clazz);
		return entityManager.createQuery(cq).getResultList();
	
	}
	
	
}
