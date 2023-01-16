import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {
    public static String PRINT_EMPLOYEE_FORMAT = "%S %S from %s - $%.2f%n";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String department = "Research and Development";

//        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :dp " +
                        "ORDER BY e.salary DESC, e.id", Employee.class)
                .setParameter("dp", department)
                .getResultList()
                .forEach(e -> System.out.printf(PRINT_EMPLOYEE_FORMAT,
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

//        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
