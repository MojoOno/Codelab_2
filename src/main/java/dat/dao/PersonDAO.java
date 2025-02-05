package dat.dao;


import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PersonDAO
{
    private EntityManagerFactory emf;
    private static PersonDAO INSTANCE;


    private PersonDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public static PersonDAO getInstance(EntityManagerFactory emf)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PersonDAO(emf);
        }
        return INSTANCE;

    }


    public void createPerson(Person person)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }
}
