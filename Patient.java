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
    public Patient(int airOrOxygenValue, int consciousnessValue, int respirationRange, int sp02, double temperature) {
        this.airOrOxygen = airOrOxygenValue == 0 ? AirOrOxygen.AIR : AirOrOxygen.OXYGEN;
        this.conciousness = consciousnessValue == 0 ? Consciousness.ALERT : Consciousness.CVPU;
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

    @Override
    public String toString() {
        return super.toString();
    }

    public int getScore(){
        int score = 0;
        // Air/Oxygen scoring
        if (this.airOrOxygen == AirOrOxygen.OXYGEN){
            score += 2;
        }
        if (this.conciousness == Consciousness.CVPU){
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
