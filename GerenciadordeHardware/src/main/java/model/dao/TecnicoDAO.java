package model.dao;

import factory.DatabaseJPA;
import model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.interfaces.*;

public class TecnicoDAO implements IDao {

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
        qry.setParameter("tipo", "TECNICO");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Tecnico procurado = (Tecnico) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        procurado = this.entityManager.find(Tecnico.class, procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return procurado;
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
        qry.setParameter("tipo", "TECNICO");
        List<Usuario> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        }
        return (Tecnico) lst.get(0);

    }

    public Object findbyId(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Usuario u Where id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);
        Object lst = qry.getSingleResult();
        this.entityManager.close();
        if (lst instanceof Tecnico) {
            return lst;
        }
        return null;
    }

    /**
     * Recebe um Cliente como parametro, procura o Cliente pelo ID Se encontrar,
     * remove ele da lstCliente.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        jpql = " DELETE FROM Usuario WHERE id = :id";
        Tecnico tecnico = (Tecnico) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", tecnico.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

}
