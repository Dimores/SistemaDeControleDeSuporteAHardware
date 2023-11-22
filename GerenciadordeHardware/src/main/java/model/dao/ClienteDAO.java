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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.interfaces.IDao;


public class ClienteDAO implements IDao {
    
    private EntityManager entityManager;
    private Query qry;
    private String jpql;
    
    public ClienteDAO() {
    
    }

    @Override
    public void save(Object obj) {
        
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
      
    }
    
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
        jpql = " SELECT c " + "FROM Usuario c WHERE tipo = :tipo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("tipo", "CLIENTE");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Cliente clienteProcurado = (Cliente) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        Cliente cliente = this.entityManager.find(Cliente.class ,clienteProcurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return cliente;   
    }
    
   
    public Object findbyId(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Usuario u Where id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id",id);
        Object lst = qry.getSingleResult();
        this.entityManager.close();
        if(lst instanceof Cliente){
            return lst;
        }
        return null;
    }

    /**
     * Procura um cliente pelo email, que é o identificador único
     *
     * @param email
     * @return Referencia para o cliente na lstCliente
     */
    public Object findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = "SELECT u FROM Usuario u WHERE u.email like :email AND tipo = :tipo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", email);
        qry.setParameter("tipo", "CLIENTE");
        List<Usuario> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        }
        return (Cliente) lst.get(0);

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
        jpql = " DELETE FROM Usuario WHERE id = :id";
        Cliente cliente = (Cliente) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", cliente.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }


}