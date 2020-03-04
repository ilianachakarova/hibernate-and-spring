package entities;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private long id;

    public BaseEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
