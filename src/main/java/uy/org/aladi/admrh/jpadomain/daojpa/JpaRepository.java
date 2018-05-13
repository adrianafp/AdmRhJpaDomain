package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.repository.Repository;
import uy.org.aladi.admrh.jpadomain.repository.criteria.Range;

public abstract class JpaRepository<T, I extends Serializable> implements Repository<T, I>, Serializable {

     /**
	 * 
	 */
	private static final long serialVersionUID = 5590096556447301542L;
	
	@Autowired
	protected EntityManager entityManager;
        
    Class<T> clazz;

    public JpaRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Transactional(readOnly = true)
    public T findById(I id) {
        return this.entityManager.find(clazz, id);
    }

    @Transactional
    public T save(T object) {
        return this.entityManager.merge(object); 
    }

    @Transactional
    public void delete(T object) {
    	this.entityManager.remove(object);
    }

    @Transactional
    public void delete(T object, I id){
    	this.entityManager.remove(this.findById(id));
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
    	
        return entityManager.createQuery("SELECT c FROM " + clazz.getSimpleName() + " c").getResultList();
    }

    @Transactional(readOnly = true)
    public long countAll() {
        return (Long) entityManager.createQuery("SELECT COUNT(c) FROM " + clazz.getSimpleName() + " c").getSingleResult();
    }

    @Transactional
    public Query applyRange(Query query, Range range) {
        return query.setFirstResult(range.getMinIndex()).setMaxResults(range.length());
    }
}
