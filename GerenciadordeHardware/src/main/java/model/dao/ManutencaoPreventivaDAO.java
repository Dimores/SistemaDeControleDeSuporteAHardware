/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.*;
import model.interfaces.IDao;
/**
 *
 * @author ruiz
 */
public class ManutencaoPreventivaDAO  implements IDao{
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
        jpql = " SELECT u " + "FROM Servico u WHERE tipo = :MANUTENCAOPREVENTIVA";
        qry = this.entityManager.createQuery(jpql);
        List lst = qry.getResultList();
        this.entityManager.close();
        return (List<Object>) lst;
    }

    @Override
    public Object find(Object obj) {
        ManutencaoPreventiva Procurado = (ManutencaoPreventiva) obj;
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        ManutencaoPreventiva c = this.entityManager.find(ManutencaoPreventiva.class ,Procurado.getIdServico());
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
    /*public Object findByBarCode(String codigo) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = " SELECT c " + " FROM ConcertoComputador c " + " WHERE  c.codigo like :codigo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("codigo", codigo);
        List lst = qry.getResultList();
        this.entityManager.close();
        if(lst.isEmpty()){
            return null;
        }return (DispositivoDeRede) lst.get(0);
       
    }*/

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
        jpql = " DELETE FROM Servico WHERE idServico = :idServico";
        ManutencaoPreventiva p = (ManutencaoPreventiva) obj;
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("idServico", p.getIdServico());
        qry.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
}
