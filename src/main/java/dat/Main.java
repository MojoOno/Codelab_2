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
        Person student2 = new Person("John", "Yje", 22);
        Person student3 = new Person("Sven", "Larsen", 69);
        PersonDAO personDAO = PersonDAO.getInstance(emf);

        //Puts the students above into DB
        personDAO.create(student1);
        personDAO.create(student2);
        personDAO.create(student3);

        //Updates the last name of student 2 and puts it into DB
        student2.setLastName("Hansen");
        personDAO.update(student2);

        //Deletes student 3 from DB
        personDAO.delete(student3);


        Course course1 = new Course("Cooking", "Gordon Ramsey", "1. semester", "3.3", "Kl 16:20");
        Course course2 = new Course("Programming", "Jon", "3. semester", "3.3", "Kl 09:00");
        Course course3 = new Course("History", "John Dillermand", "4. semester", "3.3", "Kl 10:20");
        CourseDAO courseDAO = CourseDAO.getInstance(emf);

        //Puts courses into DB
        courseDAO.create(course1);
        courseDAO.create(course2);
        courseDAO.create(course3);

        //Updates the semester for Course 1
        course1.setSemester("2.Semester");
        courseDAO.update(course1);

        //Deletes course 3 from DB
        courseDAO.delete(course3);

        System.out.println(personDAO.toList());
        System.out.println(courseDAO.toList());


        //Close the database connection
        emf.close();
    }
}