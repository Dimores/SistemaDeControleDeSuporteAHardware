/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.FeedBack;
import model.interfaces.IDao;

/**
 *
 * @author ruiz
 */
public class FeedBackDAO implements IDao {
    private EntityManager entityManager;
    private Query qry;
    private String jpql;
    @Override
    public void save(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        jpql = " DELETE FROM FeedBack WHERE id = :id";
        FeedBack g = (FeedBack) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", g.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public Object find(Object obj) {
        FeedBack procurado = (FeedBack) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        FeedBack c = this.entityManager.find(procurado.getClass(), procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;   
    }

    
    @Override
    public void update(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public List<Object> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM FeedBack u ";
        qry = this.entityManager.createQuery(jpql);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }
    
    public List<Object>findAllByClient(Long id){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM FeedBack u Where clientID = :id";
        qry = this.entityManager.createQuery(jpql);
         qry.setParameter("id",id);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }
    
}
