package Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass()
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    public Person(){}
}
