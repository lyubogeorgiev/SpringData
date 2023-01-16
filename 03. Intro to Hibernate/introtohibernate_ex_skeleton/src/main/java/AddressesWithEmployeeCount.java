import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount {
    final private static String ADDRESSES_PRINT_FORMAT = "%s, %s, %d employees%n";
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(address -> System.out.printf(ADDRESSES_PRINT_FORMAT,
                        address.getText(), address.getTown().getName(), address.getEmployees().size()));
    }
}
