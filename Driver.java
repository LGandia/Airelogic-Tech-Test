public class Driver {
    public static void main(String[] args) {
        Patient.AirOrOxygen airOrOxygen = Patient.AirOrOxygen.OXYGEN;
        Patient.Consciousness consciousness = Patient.Consciousness.ALERT;

        // Create a Patient object
        Patient patient = new Patient(airOrOxygen, consciousness, 20, 95, 37.5F);

        // Print the details of the patient
        System.out.println("Air or Oxygen: " + patient.getAirOrOxygen());
        System.out.println("Consciousness: " + patient.getConciousness());
        System.out.println("Respiration Range: " + patient.getRespirationRange());
        System.out.println("SpO2: " + patient.getSp02());
        System.out.println("Temperature: " + patient.getTemperature());
    }
}
