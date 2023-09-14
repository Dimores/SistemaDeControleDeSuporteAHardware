
package factory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseJPA {
    
    private EntityManagerFactory factory;

    private static DatabaseJPA INSTANCE = null;

    public static DatabaseJPA getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseJPA();
        }

        return INSTANCE;
    }

    /**
     * Construtor da classe. 
     * - No padrão SINGLETON ele deve ser PRIVADO
     * - Só pode ser chamado pelo método getInstance()
     * - O método getInstance() gerencia a regra SINGLETON, que permite apenas 
     * uma instancia do objeto Database
     */
    private DatabaseJPA() {
        factory = Persistence.createEntityManagerFactory("exemplo-jpa");        
    }
    
    public EntityManager getEntityManager() {        
        return factory.createEntityManager();
    }
    
    public void closeFactory(){
        this.factory.close();
    }
    
}
