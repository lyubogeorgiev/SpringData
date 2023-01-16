import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeesWithSalaryOver5000 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<String> query = entityManager.createQuery(
                "SELECT e.firstName FROM Employee e WHERE e.salary > 50000", String.class);

        List<String> employeeNames = query.getResultList();

        employeeNames.forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
