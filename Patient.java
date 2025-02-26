public class Patient {
    enum AirOrOxygen {
        AIR(0), OXYGEN(2);

        // Constructor
        private final int value;

        AirOrOxygen(int value) {
            this.value = value;
        }

        // Getter
        public int getValue() {
            return value;
        }
    }

    enum Consciousness {
        ALERT(0), CVPU(1);
        // Constructor
        private final int value;

        Consciousness(int value) {
            this.value = value;
        }

        // Getter
        public int getValue() {
            return value;
        }


    }

    // Attributes
    private AirOrOxygen airOrOxygen;
    private Consciousness conciousness;
    private int respirationRange;
    private int sp02;
    private float temperature;

    // Constructor
    public Patient(int airOrOxygenValue, int conciousnessValue, int respirationRange, int sp02, float temperature) {
        this.airOrOxygen = airOrOxygenValue == 0 ? AirOrOxygen.AIR : AirOrOxygen.OXYGEN;
        this.conciousness = conciousnessValue == 0 ? Consciousness.ALERT : Consciousness.CVPU;
        this.respirationRange = respirationRange;
        this.sp02 = sp02;
        this.temperature = temperature;
    }
    // Getters
    public AirOrOxygen getAirOrOxygen() {
        return airOrOxygen;
    }

    public Consciousness getConciousness() {
        return conciousness;
    }

    public int getRespirationRange() {
        return respirationRange;
    }

    public int getSp02() {
        return sp02;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getScore(){
        int score = 0;
        if (this.conciousness == Consciousness.CVPU){
            score += 3;
        }
        if (this.airOrOxygen == AirOrOxygen.OXYGEN){
            score += 2;
        }
        return score;
    }
}
