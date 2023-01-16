import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        final int employeeId = Integer.parseInt(new Scanner(System.in).nextLine());

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id ORDER BY e.firstName ASC, e.lastName ASC", Employee.class)
                .setParameter("id", employeeId)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s%n%s", e.getFirstName(), e.getLastName(), e.getJobTitle(),
                        e.getProjects().stream()
                                .sorted(Comparator.comparing(Project::getName))
                                .map(Project::getName)
                                .collect(Collectors.joining("\t\n"))));

    }
}
