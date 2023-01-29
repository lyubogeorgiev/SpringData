package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person{

    @Column(name = "average_grade")
    private double averageGrade;

    @Column(name = "attendance")
    private int attendance;

    @ManyToMany(
            mappedBy = "students", targetEntity = Course.class
    )
    private List<Course> courses;

    public Student(){
        this.courses = new ArrayList<>();
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
