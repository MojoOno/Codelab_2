package dat.dao;


import dat.entities.Course;
import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDAO
{
    private EntityManagerFactory emf;
    private static CourseDAO INSTANCE;


    private CourseDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public static CourseDAO getInstance(EntityManagerFactory emf)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new CourseDAO(emf);
        }
        return INSTANCE;

    }

    public void create(Course course)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
    }

    public void update(Course course)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }
    }

    public void delete(Course course)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }
    }

    public List<Course> toList()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            String jpql = "SELECT e FROM Course e";
            TypedQuery<Course> query = em.createQuery(jpql, Course.class);
            List<Course> courseList = query.getResultList();
            return courseList;
        }
    }



}
