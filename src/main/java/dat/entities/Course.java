package dat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String course;
    private String teacherName;
    private String semester;
    private String classroom;
    private String courseStart;

    public Course(String course, String teacherName, String semester, String classroom, String courseStart)
    {
        this.course = course;
        this.teacherName = teacherName;
        this.semester = semester;
        this.classroom = classroom;
        this.courseStart = courseStart;
    }
}
