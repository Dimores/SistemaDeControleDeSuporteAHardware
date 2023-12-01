/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Peca;
import model.PecaExemplar;
import model.interfaces.IDao;

/**
 *
 * @author diego
 */
public class PecaExemplarDAO implements IDao {

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
        jpql = " SELECT p " + "FROM PecaExemplar p ";
        qry = this.entityManager.createQuery(jpql);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    public List<PecaExemplar> findAllByNome(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT p " + "FROM PecaExemplar p WHERE nome = :nome";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("nome", nome);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<PecaExemplar>) lst;
    }

    public List<PecaExemplar> findAllByIdPeca(Long idPeca) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT p " + "FROM PecaExemplar p WHERE peca_id = :peca_id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("peca_id", idPeca);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<PecaExemplar>) lst;
    }

    @Override
    public Object find(Object obj) {
        PecaExemplar procurado = (PecaExemplar) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        procurado = this.entityManager.find(PecaExemplar.class, procurado.getCodigo());
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
        jpql = " SELECT c " + " FROM PecaExemplar c " + " WHERE  c.codigo like :codigo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("codigo", codigo);
        List lst = qry.getResultList();
        this.entityManager.close();
        if (lst.isEmpty()) {
            return null;
        }
        return (Peca) lst.get(0);

    }

    // Atualizar a lista de exemplares no banco de dados
    public void updateAll(List<PecaExemplar> exemplares) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        for (PecaExemplar exemplar : exemplares) {
            this.entityManager.merge(exemplar);
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    // Salvar uma lista de exemplares no banco de dados
    public void saveAll(List<PecaExemplar> exemplares) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        for (PecaExemplar exemplar : exemplares) {
            this.entityManager.persist(exemplar);
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        jpql = " DELETE FROM PecaExemplar WHERE id = :id";
        PecaExemplar p = (PecaExemplar) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", p.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
