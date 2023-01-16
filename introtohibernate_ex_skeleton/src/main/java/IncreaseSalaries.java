import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final List<String> departmentsList = Arrays.asList("Information Services", "Marketing", "Tool Design", "Engineering");
        final String departments = String.join(", ", departmentsList);

        entityManager.createQuery("UPDATE Employee AS e SET e.salary = e.salary * 1.12 WHERE e.firstName = 'Roberto'")
                .executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.department.name IN('Information Services', 'Marketing', 'Tool Design', 'Engineering')", Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s %s ($%.2f)%n", e.getDepartment().getName(), e.getFirstName(), e.getLastName(), e.getSalary()));

        entityManager.close();
    }
}
