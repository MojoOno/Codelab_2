package dat.dao;


import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

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


    public void create(Person person)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    public void update(Person person)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        }
    }

    public void delete(Person person)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        }
    }

    public List<Person> toList()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            String jpql = "SELECT e FROM Person e";
            TypedQuery<Person> query = em.createQuery(jpql, Person.class);
            List<Person> personList = query.getResultList();
            return personList;
        }
    }

}
