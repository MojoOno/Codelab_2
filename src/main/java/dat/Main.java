package dat;

import dat.config.HibernateConfig;
import dat.dao.CourseDAO;
import dat.dao.PersonDAO;
import dat.entities.Course;
import dat.entities.Person;
import jakarta.persistence.EntityManagerFactory;

public class Main
{
    public static void main(String[] args)
    {
        final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

//        Person person1 = new Person("Franck", "Dux", 69);
//
//        PersonDAO personDAO = PersonDAO.getInstance(emf);
//
//        personDAO.createPerson(person1);


        Person student1 = new Person("Karl", "Kylije", 42);
        PersonDAO personDAO = PersonDAO.getInstance(emf);
        personDAO.createPerson(student1);

        Course course1 = new Course("Cooking", "Gordon Ramsey", "1. semester", "3.3", "Kl 16:20");
        CourseDAO courseDAO = CourseDAO.getInstance(emf);
        courseDAO.createCourse(course1);
        course1.setSemester("2.Semester");
        courseDAO.updateCourse(course1);





        //Close the database connection
        emf.close();
    }
}