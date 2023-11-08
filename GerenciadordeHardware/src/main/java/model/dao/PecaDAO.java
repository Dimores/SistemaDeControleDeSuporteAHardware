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

public class PecaDAO implements IDao {
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
        jpql = " SELECT u " + "FROM Produto u WHERE tipo = :tipo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("tipo", "PECA");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Peca procurado = (Peca)  obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        procurado = this.entityManager.find(Peca.class ,procurado.getCodigo());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return procurado;   
    }

    /**
     * Procura produtos por codigodebarras, que é o identificador único
     *
     * @param codigo
     * @return Referencia para o cliente na lstCliente
     */
    public Object findByCodigo(String codigo) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT c " + " FROM Produto c " + " WHERE  c.codigo like :codigo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("codigo", codigo);
        List lst = qry.getResultList();
        this.entityManager.close();
        if(lst.isEmpty()){
            return null;
        }return (Peca) lst.get(0);
       
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
        jpql = " DELETE FROM Produto WHERE codigo = :codigo";
        Peca p = (Peca) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("codigo", p.getCodigo());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
    
}
