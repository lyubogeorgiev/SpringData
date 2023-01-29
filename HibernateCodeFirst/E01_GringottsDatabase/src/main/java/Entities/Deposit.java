package Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "group", length = 20)
    private String group;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "interest")
    private BigDecimal interest;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "is_expired")
    private boolean isExpired;
}
