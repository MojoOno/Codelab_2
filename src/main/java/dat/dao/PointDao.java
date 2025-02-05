package dat.dao;

import dat.entities.Point;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class PointDao
{
    private EntityManager em;

    public PointDao(EntityManager em)
    {
        this.em = em;
    }

    // Store 1000 Point objects in the database:
    public void insertIntoDB()
    {
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++)
        {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
    }

    // Find the number of Point objects in the database:
    public long count()
    {
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        return Long.parseLong(q1.getSingleResult().toString());
    }

    // Find the average X value:
    public double average()
    {
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        return Double.parseDouble(q2.getSingleResult().toString());
    }

    // Returns all points in DB
    public List<Point> getAll()
    {
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        return query.getResultList();
    }

}
