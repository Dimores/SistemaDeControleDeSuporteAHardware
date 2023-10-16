/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadordehardware;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import view.FrLogin;

/**
 *
 * @author ruiz
 */
public class GerenciadordeHardware {

    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException {
      
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamentoHardware-jpa");
        EntityManager entityManager = factory.createEntityManager();
        FrLogin home = new FrLogin();
        home.setVisible(true);
        entityManager.close();
        factory.close();

    }
}
