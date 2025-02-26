public class Driver {
    public static void main(String[] args) {
        // patient should give a scoring of 0
        Patient patient0 = new Patient(0, 0, 20, 90, 37.5f);

        // patient1 should give a scoring of 2
        Patient patient1 = new Patient(2, 0, 20, 90, 37.5f);

        // patient2 should give a scoring of 5
        Patient patient2 = new Patient(2, 1, 20, 90, 37.5f);

        // patient3 should give a scoring of 8
        Patient patient3 = new Patient(2, 3, 7, 90, 37.5f);

        // patient4 should give a scoring of 10
        Patient patient4 = new Patient(2, 3, 25, 95, 37.5f);

        // patient4 should give a scoring of 13
        Patient patient5 = new Patient(2, 3, 25, 95, 30.0f);

        //patient0 stats
        System.out.println("Air or Oxygen: " + patient0.getAirOrOxygen());
        System.out.println("Consciousness: " + patient0.getConsciousness());
        System.out.println("Respiration Range: " + patient0.getRespirationRange());
        System.out.println("SpO2: " + patient0.getSp02());
        System.out.println("Temperature: " + patient0.getTemperature());

        // Scores
        System.out.println("Patient 0 Score: " + patient0.getScore());
        System.out.println("Patient 1 Score: " + patient1.getScore());
        System.out.println("Patient 2 Score: " + patient2.getScore());
        System.out.println("Patient 3 Score: " + patient3.getScore());
        System.out.println("Patient 4 Score: " + patient4.getScore());
        System.out.println("Patient 5 Score: " + patient5.getScore());
    }
}
