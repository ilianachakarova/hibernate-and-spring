package entities.hospital;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medications")
public class Medication extends BaseEntity {
    private String name;
    private Set<Patient> patients = new HashSet<>();

    public Medication() {
    }

    public Medication(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "medications_patients",
            joinColumns = @JoinColumn(name = "medication_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){
        this.getPatients().add(patient);
    }
}
