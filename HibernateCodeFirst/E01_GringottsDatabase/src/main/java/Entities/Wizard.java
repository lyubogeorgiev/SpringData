package Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wizard")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60)
    @NotNull
    private String lastName;

    @Column(name = "note", length = 1000)
    private String note;

    @Column(name = "age")
    @NotNull
    private int age;

    @OneToOne
    @JoinColumn(name = "magic_wand", referencedColumnName = "id")
    private MagicWand magicWand;

    @OneToMany(mappedBy = "id", targetEntity = Deposit.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Deposit> deposits;
}
