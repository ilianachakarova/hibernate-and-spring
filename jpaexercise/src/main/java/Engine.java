import entities.hospital.Medication;
import entities.hospital.Patient;
import entities.hospital.Visitation;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Engine implements Runnable {
private final EntityManager entityManager;
private Scanner scanner;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        Scanner scanner =  new Scanner(System.in);

        //Prombem 4 -> Hospital You can use the following code to create 2 patients: Geogri Georgiev and Pesho Peshov
        //After that use the same names to retreive a detailed record for the patients
        Patient patient1 = new Patient("Georgi","Georgiev", "address1","ggoog@abv.bg","01.01.1995","url:ksfkljfdk",true);
        Patient patient2 = new Patient("Pesho","Peshov", "address2","pepe@abv.bg","02.01.1995","url:ksfkljfdk",true);
        Visitation visitation1 = new Visitation(formattedDate("2020-01-01 15:00"),"Just a regular check");
        visitation1.setPatient(patient1);
        patient1.addVisitation(visitation1);
        Medication medication1 = new Medication("Vitamins Centrum");
        medication1.addPatient(patient1);
        patient1.addMedication(medication1);
        Visitation visitation2
                = new Visitation(formattedDate("2020-03-01 12:00"),"Patient has complaint about breathing difficulty");
        visitation2.setPatient(patient2);
        patient2.addVisitation(visitation2);
        Medication medication2 = new Medication("AstmaHelp");
        medication2.addPatient(patient2);
        patient2.addMedication(medication2);
    // Storing the data into the database
        inTransaction(entityManager, ()->{
            entityManager.persist(patient1);
            entityManager.persist(patient2);
            entityManager.persist(visitation1);
            entityManager.persist(medication1);
        });
       // Retrieve info about patient from the database:
        System.out.println("Welcome to the BGC database");
        System.out.println("To receive a detailed record for a patient, please enter:");
        System.out.println("Patient first Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Patient last name: ");
        String lastName =  scanner.nextLine();

        Patient patient =
        entityManager.createQuery("select p from Patient as p where p.firstName = :firstName and p.lastName =: lastName", Patient.class)
                .setParameter("firstName",firstName).setParameter("lastName", lastName).getSingleResult();
        System.out.println(patient.toString());
    }

    private void inTransaction(EntityManager entityManager, Runnable runnable){
        entityManager.getTransaction().begin();
        runnable.run();
        entityManager.getTransaction().commit();
    }

    private LocalDateTime formattedDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(date, formatter);
        return formatDateTime;
    }
}
