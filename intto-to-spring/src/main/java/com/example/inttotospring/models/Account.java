package com.example.inttotospring.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NonNull
    @Column()
    private BigDecimal balance;

    @ManyToOne
    @NonNull
    private User user;

    public boolean equals(Object o){
        if(this == o)return true;
        if(!(o instanceof Account))return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
