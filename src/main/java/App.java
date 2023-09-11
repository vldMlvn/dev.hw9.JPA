import criteria.Query;
import criteria.ResidentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import util.WriteToFile;

import java.util.List;

public class App {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        List<ResidentInfo> residents = Query.getResidentsWithCriteria(em);

        WriteToFile.write(residents.toString());
        System.out.println(residents);

        em.close();
        emf.close();
    }
}
