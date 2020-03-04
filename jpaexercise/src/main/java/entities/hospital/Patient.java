package entities.hospital;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String dateOfBirth;
    private String picture;
    private boolean hasMedicalInsurance;
    private Set<Visitation>visitations = new HashSet<>();
    private Set<Diagnose> diagnoses = new HashSet<>();
    private Set<Medication> medications = new HashSet<>();

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, String dateOfBirth, String picture, boolean hasMedicalInsurance) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
        setPicture(picture);
        setHasMedicalInsurance(hasMedicalInsurance);
    }
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
@Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Column(name = "date_of_birth", nullable = false)
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
@Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
@Column(name = "has_medical_insurance")
    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public void addVisitation(Visitation visitation){
        this.getVisitations().add(visitation);
    }
    @OneToMany(mappedBy = "patient", targetEntity = Diagnose.class, cascade = CascadeType.ALL)
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnose(Diagnose diagnose){
        this.getDiagnoses().add(diagnose);
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
    @ManyToMany(mappedBy = "patients",targetEntity = Medication.class, cascade = CascadeType.ALL)
    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(Set<Medication> medications) {
        this.medications = medications;
    }

    public void addMedication(Medication medication){
        this.getMedications().add(medication);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.firstName).append(System.lineSeparator());
        sb.append("Last Name: ").append(this.lastName).append(System.lineSeparator());
        sb.append("DOB: ").append(this.dateOfBirth).append(System.lineSeparator());
        sb.append("Email: ").append(this.email).append(System.lineSeparator());
        sb.append("Pic link:").append(this.picture).append(System.lineSeparator());
        sb.append("Diagnoses: ");
        this.getDiagnoses().forEach(d->sb.append("      " + d.getName()).append(System.lineSeparator()));
        sb.append(System.lineSeparator());
        sb.append("Medications:").append(System.lineSeparator());
        this.getMedications().forEach(medication -> sb.append("     ").append(medication.getName()).append(System.lineSeparator()));
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
