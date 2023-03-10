package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "salary_per_hour", nullable = false)
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    private List<Course> courses;

    public Teacher(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
