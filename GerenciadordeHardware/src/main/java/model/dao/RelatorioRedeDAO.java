package model.dao;

import factory.DatabaseJPA;
import model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.interfaces.IDao;

public class RelatorioRedeDAO implements IDao {

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
        jpql = " SELECT u " + "FROM Relatorio u WHERE tipo = : tipo ";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("tipo", "RELATORIOREDE");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        Relatorio Procurado = (Relatorio) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        Relatorio c = this.entityManager.find(Relatorio.class, Procurado.getIdRelatorio());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;
    }

    public List<Object> findByCliente(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Relatorio u Where cliente_id = :id AND tipo = :tipoRelatorio";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);
        qry.setParameter("tipoRelatorio", "RELATORIOREDE");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    public List<Object> findAllByCliente(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Relatorio u Where cliente_id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    public Object findByTecnico(Object obj) {
        // Relatório de manutenção

        return 0;
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
        jpql = " DELETE FROM Relatorio WHERE id = :id";
        Relatorio p = (Relatorio) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", p.getIdRelatorio());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
