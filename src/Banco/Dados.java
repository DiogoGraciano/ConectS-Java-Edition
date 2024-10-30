
package Banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Dados {
    private static EntityManager manager = null;
    //
    public static EntityManager getManager(){
        if (manager == null){
            EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("ConectS");
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
