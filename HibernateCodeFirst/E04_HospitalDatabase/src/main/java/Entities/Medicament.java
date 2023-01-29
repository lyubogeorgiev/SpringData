package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "medicaments", targetEntity = Patient.class)
    private List<Patient> patients;

    public Medicament(){
        this.patients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
