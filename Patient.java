public class Patient {
    enum AirOrOxygen {
        AIR(0),
        OXYGEN(2);

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

        // Method to return whether the patient is conscious or alert
        public static Consciousness getConciousness(int value) {
            // if value is 0, then ALERT is returned, else CVPU is returned
            if (value == 0) {
                return ALERT;
            } else {
                return CVPU;
            }
        }
    }

    // Attributes
    private AirOrOxygen airOrOxygen;
    private Consciousness conciousness;
    private int respirationRange;
    private int sp02;
    private float temperature;

    // Constructor
    public Patient(AirOrOxygen airOrOxygen, Consciousness conciousness, int respirationRange, int sp02, float temperature) {
        this.airOrOxygen = airOrOxygen;
        this.conciousness = conciousness;
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
}
