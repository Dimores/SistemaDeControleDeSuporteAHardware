/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;
import model.Gerente;
import model.Tecnico;
import model.Usuario;
import model.interfaces.IDao;

/**
 *
 * @author ruiz
 */
public class GerenteDAO implements IDao {
    
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
        jpql = " SELECT u " + "FROM Usuario u WHERE tipo =: tipo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("tipo", "GERENTE");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Gerente Procurado = (Gerente) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        Gerente c = this.entityManager.find(Gerente.class ,Procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;   
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
        qry.setParameter("tipo", "GERENTE");
        List<Usuario> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        }
        return (Gerente) lst.get(0);

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
        Gerente g = (Gerente) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", g.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
