package dat;

import dat.config.HibernateConfig;
import dat.dao.PersonDAO;
import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main
{
    public static void main(String[] args)
    {
        final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        Person person1 = new Person("Franck", "Dux", 69);

        PersonDAO personDAO = PersonDAO.getInstance(emf);

        personDAO.createPerson(person1);


        //Close the database connection
        emf.close();



    }
}