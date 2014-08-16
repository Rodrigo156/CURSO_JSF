
package br.com.projeto.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Funcionario
 */
public class HibernateDAO<T> implements IntefaceDAO<T>,Serializable{
    
    private static final long serialVersionUID=1L;
   
    private Session session;
    private Class<T>classes;

    public HibernateDAO(Session session, Class<T> classes) {
        this.session = session;
        this.classes = classes;
    }

    @Override
    public void save(T entity) {
       session.save(entity);
    }

    @Override
    public void update(T entity) {
       session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
       session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T)session.get(classes, id);
        return entity;
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {     
        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> listAll() {
        List<T> entitys = (List<T>)session.createCriteria(classes).list();
        return  entitys;
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }
    
    
    
}
