package entities.hospital;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Visitation extends BaseEntity {
    private LocalDateTime date;
    private String comments;
    private Patient patient;

    public Visitation() {
    }
    public Visitation (LocalDateTime date, String comments){
        this.setDate(date);
        this.setComments(comments);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
