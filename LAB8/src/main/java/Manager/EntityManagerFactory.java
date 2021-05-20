package Manager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Map;

public class EntityManagerFactory {
    private static EntityManager man=null;
    static
    {

        EntityManagerFactory ent= Persistence.createEntityManagerFactory("MyApplicationPu",properties);
        man= ent.createEntityManager();
        man.getTransaction().begin();
    }
    public static EntityManager getMan() {
        return man;
    }
}
