package model.dao;

import factory.DatabaseJPA;
import model.*;
import java.util.List;
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
        Servico c = this.entityManager.find(Servico.class, Procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;
    }

    public List<Object> findAllByCliente(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Servico u Where cliente_id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    public InstalacaoRede findInstalacaoRedeByCliente(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = "SELECT u FROM Servico u Where u.clienteAtendido.id = :id AND u.tipo = 'INSTALACAOREDE'";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);

        InstalacaoRede instalacaoRedeProcurada = null;
        List<InstalacaoRede> lst = qry.getResultList();
        instalacaoRedeProcurada = lst.get(0);

        this.entityManager.close();

        if (lst instanceof Cliente) {
            return instalacaoRedeProcurada;
        }
        return null;
    }

    public Object findByTecnico(Object obj) {
        // Relatório de manutenção

        return 0;
    }

    public List<Object> findAllInstalacaoRedeConcluidaPorCliente(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = "SELECT u FROM Servico u WHERE cliente_id = :id AND tipo = :tipo AND concluido = true";
        qry = this.entityManager.createQuery(jpql, Servico.class);
        qry.setParameter("id", id);
        qry.setParameter("tipo", "INSTALACAOREDE");
        List lst = qry.getResultList();
        this.entityManager.close();

        return lst;
    }

    public Object findById(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u " + "FROM Servico u Where id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);
        Object lst = qry.getSingleResult();
        this.entityManager.close();
        return lst;
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
        jpql = " DELETE FROM Servico WHERE id = :id";
        Servico p = (Servico) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", p.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    public List<Object> findAllManutencaoPreventivaConcluida() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT u FROM Servico u WHERE tipo = 'MANUTENCAOPREVENTIVA' AND concluido = true";
        qry = this.entityManager.createQuery(jpql);
        List lst = qry.getResultList();
        this.entityManager.close();

        return lst;
    }

}
