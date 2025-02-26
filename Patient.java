public class Patient {
    public enum AirOrOxygen {
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

    public enum Consciousness {
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
    private final AirOrOxygen airOrOxygen;
    private final Consciousness consciousness;
    private final int respirationRange;
    private final int sp02;
    private final float temperature;

    // Constructor
    public Patient(int airOrOxygenValue, int consciousnessValue, int respirationRange, int sp02, double temperature) {
        this.airOrOxygen = airOrOxygenValue == 0 ? AirOrOxygen.AIR : AirOrOxygen.OXYGEN;
        this.consciousness = consciousnessValue == 0 ? Consciousness.ALERT : Consciousness.CVPU;
        this.respirationRange = respirationRange;
        this.sp02 = sp02;
        // Temperature - Round to 1 decimal place, allows int/double to be inputted
        this.temperature = Math.round((float) temperature * 10) / 10.0f;
    }
    // Getters
    public AirOrOxygen getAirOrOxygen() {
        return airOrOxygen;
    }

    public Consciousness getConsciousness() {
        return consciousness;
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

    @Override
    public String toString() {
        return "Air or Oxygen: " + airOrOxygen + "\n" +
                "Consciousness: " + consciousness + "\n" +
                "Respiration Range: " + respirationRange + "\n" +
                "SpO2: " + sp02 + "\n" +
                "Temperature: " + temperature;
    }
    public void displayStats(){
        System.out.println(toString());
    }

    public int getScore(){
        int score = 0;
        // Air/Oxygen scoring
        if (this.airOrOxygen == AirOrOxygen.OXYGEN){
            score += 2;
        }
        if (this.consciousness == Consciousness.CVPU){
            score += 3;
        }

        // Respiration range scoring
        if (respirationRange <= 8) {
            score += 3;
        } else if (respirationRange <= 11) {
            score += 1;
        } else if (respirationRange >= 21 && respirationRange <= 24) {
            score += 1;
        } else if (respirationRange >= 25) {
            score += 3;
        }

        // Sp02 scoring
        if (sp02 <= 83) {
            score += 3;
        } else if (sp02 <= 85) {
            score += 2;
        } else if (sp02 <= 87) {
            score += 1;
        } else if (sp02 >= 93) {
            // Checks if patient is on oxygen
            if (this.airOrOxygen == AirOrOxygen.OXYGEN) {
                if (sp02 >= 97) {
                    score += 3;
                } else if (sp02 <= 94) {
                    score += 1;
                } else {
                    score += 2;
                }
            }
        }
        // Temperature scoring
        if (this.temperature <= 35.0){
            score += 3;
        }else if (this.temperature <= 36.0){
            score += 1;
        }else if (this.temperature >= 38.1 && this.temperature <= 39.0){
            score += 1;
        }else {
            score += 3;
        }

        return score;
    }
}
