public class Driver {
    public static void main(String[] args) {
        // Use integers to create a Patient object
        Patient patient = new Patient(0, 2, 20, 95, 37.7f);

        System.out.println("Air or Oxygen: " + patient.getAirOrOxygen());
        System.out.println("Consciousness: " + patient.getConciousness());
        System.out.println("Respiration Range: " + patient.getRespirationRange());
        System.out.println("SpO2: " + patient.getSp02());
        System.out.println("Temperature: " + patient.getTemperature());

        int score = patient.getScore();
        System.out.println("Patient Score: " + score);
    }
}
