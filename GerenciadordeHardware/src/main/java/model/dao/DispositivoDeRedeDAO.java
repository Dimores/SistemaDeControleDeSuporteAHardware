/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.DispositivoDeRede;
import model.interfaces.IDao;

/**
 *
 * @author ruiz
 */
public class DispositivoDeRedeDAO implements IDao {

    private EntityManager entityManager;
    private Query qry;
    private String jpql;

    @Override
    public void save(Object obj) {

        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
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
        qry.setParameter("tipo", "DISPOSITIVODEREDE");
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        DispositivoDeRede Procurado = (DispositivoDeRede) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        DispositivoDeRede c = this.entityManager.find(DispositivoDeRede.class, Procurado.getId());
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return c;
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
        if (lst.isEmpty()) {
            return null;
        }
        return (DispositivoDeRede) lst.get(0);

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
        jpql = " DELETE FROM Produto WHERE id = :id";
        DispositivoDeRede p = (DispositivoDeRede) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", p.getId());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
