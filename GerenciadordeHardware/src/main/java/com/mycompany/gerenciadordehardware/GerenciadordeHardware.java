/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadordehardware;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.RelatorioRede;
import view.FrLogin;
import view.dlgCadastrarPeca;
import utils.Criptografia;

/**
 *
 * @author ruiz
 */
public class GerenciadordeHardware {

    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException {
        FrLogin home = new FrLogin();
        home.setVisible(true);  
        Criptografia crip = new Criptografia();
        
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");;
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        //String idRelatorio, String dataRelatorio, String descricao, String tipoRede, String nomeCliente, String nomeTecnico
        RelatorioRede rd = new RelatorioRede("27/07/2008", "relatorio top", "tipo A", "Pedro", "Gabriel braia");
        entityManager.merge(rd);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        factory.close();*/
    }
}
