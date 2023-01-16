import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner =  new Scanner(System.in);

        String lastName = scanner.nextLine();

        entityManager.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        entityManager.persist(newAddress);

        int count = entityManager.createQuery("UPDATE Employee e SET e.address = :na WHERE e.lastName = :ln")
                .setParameter("na", newAddress)
                .setParameter("ln", lastName)
                .executeUpdate();

        if (count > 0){
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().rollback();
        }

        entityManager.close();

        System.out.println(count);
    }
}
