package dat.dao;


import dat.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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

    public void createCourse(Course course)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
    }

    public void updateCourse(Course course)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }

    }
}
