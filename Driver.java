import java.time.LocalDateTime;

public class Driver {
    public static void main(String[] args) {
        // patient should give a scoring of 0
        Patient patient0 = new Patient(0, 0, 20, 90, 37);

        // patient1 should give a scoring of 2
        Patient patient1 = new Patient(2, 0, 20, 90, 37.5);

        // patient2 should give a scoring of 5
        Patient patient2 = new Patient(2, 1, 20, 90, 37.5);

        // patient3 should give a scoring of 8
        Patient patient3 = new Patient(2, 3, 7, 90, 37.5);

        // patient4 should give a scoring of 10
        Patient patient4 = new Patient(2, 3, 25, 95, 37.5);

        // patient4 should give a scoring of 13
        Patient patient5 = new Patient(2, 3, 25, 95, 30.0);

        // README patients
        Patient READMEpatient1 = new Patient(0,0,15,95,37.1); // 0
        Patient READMEpatient2 = new Patient(2,0,17,95,37.1); // 4
        Patient READMEpatient3 = new Patient(2,1,23,88,38.5); // 8

        // patient0 stats
        System.out.println("\n=====Patient 0 all stats=====");
        patient0.displayStats();

        // display stats individually
        System.out.println("\n=====Patient individual scores=====");
        System.out.println("Patient 3 air/oxygen: "+ patient3.getAirOrOxygen() );
        System.out.println("Patient 1 temperature: "+ patient1.getTemperature() );
        System.out.println("Patient 5 SPO2: "+ patient5.getSp02() );
        System.out.println("Patient 4 respiration range: " + patient4.getRespirationRange());
        System.out.println("Patient 2 consciousness : " + patient2.getConsciousness());

        // Scores
        System.out.println("\n=====Patient scores=====");
        System.out.println("Patient 0 Score: " + patient0.getScore());
        System.out.println("Patient 1 Score: " + patient1.getScore());
        System.out.println("Patient 2 Score: " + patient2.getScore());
        System.out.println("Patient 3 Score: " + patient3.getScore());
        System.out.println("Patient 4 Score: " + patient4.getScore());
        System.out.println("Patient 5 Score: " + patient5.getScore());

        // README scores
        System.out.println("\n===== README Patient scores=====");
        System.out.println("Patient 1 Score: " + READMEpatient1.getScore());
        System.out.println("Patient 2 Score: " + READMEpatient2.getScore());
        System.out.println("Patient 3 Score: " + READMEpatient3.getScore());

        READMEpatient1.displayStats();
        READMEpatient2.displayStats();
        READMEpatient3.displayStats();

        //cbg + fasting
        Patient patient9 = new Patient(2, 1, 20, 90, 37.5, 3.9, false);
        patient9.displayStats();
        System.out.println("Patient CBG score: " + patient9.getScore());

        //24 hour warning
        Patient patientTime = new Patient(0,0,12,95,37.5, 5.0, false);
        patientTime.addRecordManually(patientTime.getScore(), LocalDateTime.now().minusHours(25));
        patientTime.
        patientTime.addRecordManually(patientTime.getScore(), LocalDateTime.now().minusHours(20));
        patientTime.addRecordManually(patientTime.getScore(), LocalDateTime.now().minusHours(10));
        patientTime.addRecordManually(patientTime.getScore(), LocalDateTime.now().minusHours(5));
        patientTime.addRecordManually(patientTime.getScore(), LocalDateTime.now());

    }
}
