package model.dao;

import factory.DatabaseJPA;
import factory.Persistencia;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.interfaces.IDao;

public class ServicoDAO implements IDao {

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
        jpql = " SELECT u " + "FROM Servico u";
        qry = this.entityManager.createQuery(jpql);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Servico Procurado = (Servico) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        Servico c = this.entityManager.find(Servico.class ,Procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;   
    }


    public Object findByCliente(Object obj) {
        // Relatorio de rede
        
        return 0;
    }
    
    
    public Object findByTecnico(Object obj) {
        // Relatório de manutenção
        
        return 0;
    }

    /**
     * Recebe um Cliente como parametro, procura o Cliente pelo ID Se
     * encontrar, remove ele da lstCliente.
     *
     * @param obj
     * @return
     */

    @Override
    public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        jpql = " DELETE FROM Servico WHERE id = :id";
        Servico p = (Servico) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", p.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
