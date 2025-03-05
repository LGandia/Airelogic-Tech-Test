import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private AirOrOxygen airOrOxygen;
    private final Consciousness consciousness;
    private final int respirationRange;
    private final int sp02;
    private final float temperature;
    private final Double cbg;
    private final Boolean isFasting;

    public int oxygenScore = 0;
    public int consciousnessScore = 0;
    public int respirationScore = 0;
    public int sp02Score = 0;
    public int temperatureScore = 0;
    public int cbgScore = 0;

    // Constructors
    public Patient(int airOrOxygenValue, int consciousnessValue, int respirationRange, int sp02, double temperature, Double cbg, Boolean isFasting) {
        this.airOrOxygen = airOrOxygenValue == 0 ? AirOrOxygen.AIR : AirOrOxygen.OXYGEN;
        this.consciousness = consciousnessValue == 0 ? Consciousness.ALERT : Consciousness.CVPU;
        this.respirationRange = respirationRange;
        this.sp02 = sp02;
        // Temperature - Round to 1 decimal place, allows int/double to be inputted
        this.temperature = Math.round((float) temperature * 10) / 10.0f;
        this.cbg = cbg;
        this.isFasting = isFasting;
    }
    public Patient(int airOrOxygenValue, int consciousnessValue, int respirationRange, int sp02, double temperature) {
        this(airOrOxygenValue, consciousnessValue, respirationRange, sp02, temperature, null, null);
    }
    // Setters
    public void setAirOrOxygen(AirOrOxygen airOrOxygen) {
        airOrOxygen = this.airOrOxygen;
    }

    public void setConsciousness( Consciousness consciousness) {
        consciousness = this.consciousness;
    }

    public void setRespirationRange(int respirationRange) {
        respirationRange = this.respirationRange;
    }

    public void setSp02(int sp02) {
        sp02 = this.sp02;
    }

    public void setTemperature(float temperature) {
        temperature = this.temperature;
    }
    public void setCBG( double cbg ){
        cbg = this.cbg;
    }
    public void setIsFasting( boolean isFasting){
         isFasting = this.isFasting;
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
    public double getCBG(){
        return cbg;
    }
    public boolean getIsFasting(){
        return isFasting;
    }
    // Scores
    public int getOxygenScore() {
        return oxygenScore;
    }

    public int getConsciousnessScore() {
        return consciousnessScore;
    }

    public int getRespirationScore() {
        return respirationScore;
    }

    public int getSp02Score() {
        return sp02Score;
    }

    public int getTemperatureScore() {
        return temperatureScore;
    }
    public int getCbgScore(){
        return cbgScore;
    }

    @Override
    public String toString() {
        return "\nAir or Oxygen: " + airOrOxygen + " Points: " + oxygenScore + "\n" +
                "Consciousness: " + consciousness + " Points: " + consciousnessScore + "\n" +
                "Respiration Range: " + respirationRange + " Points: " + respirationScore + "\n" +
                "SpO2: " + sp02 + " Points: " + sp02Score + "\n" +
                "Temperature: " + temperature + " Points: " + temperatureScore + "\n"+
                "Capillary Blood Glucose: " + (cbg != null ? cbg: "N/A") + " Points: "+cbgScore+"\n"+
                "Is Fasting: "+(isFasting != null ? isFasting : "N/A");
    }
    public void displayStats(){
        System.out.println(toString());
    }
    // Scoring
    public int getScore(){
        int score = 0;

        // Air/Oxygen scoring
        if (this.airOrOxygen == AirOrOxygen.OXYGEN){
            score += 2;
            oxygenScore += 2;
        }
        if (this.consciousness == Consciousness.CVPU){
            score += 3;
            consciousnessScore += 3;
        }

        // Respiration range scoring
        if (respirationRange <= 8) {
            score += 3;
            respirationScore += 3;
        } else if (respirationRange <= 11) {
            score += 1;
            respirationScore += 1;
        } else if (respirationRange >= 21 && respirationRange <= 24) {
            score += 2;
            respirationScore += 2;
        } else if (respirationRange >= 25) {
            score += 3;
            respirationScore += 3;
        }

        // Sp02 scoring
        if (sp02 <= 83) {
            score += 3;
            sp02Score += 3;
        } else if (sp02 <= 85) {
            score += 2;
            sp02Score += 2;
        } else if (sp02 <= 87) {
            score += 1;
            sp02Score += 1;
        } else if (sp02 >= 93) {
            // Checks if patient is on oxygen
            if (this.airOrOxygen == AirOrOxygen.OXYGEN) {
                if (sp02 >= 97) {
                    score += 3;
                    sp02Score += 3;

                } else if (sp02 <= 94) {
                    score += 1;
                    sp02Score += 1;
                } else {
                    score += 2;
                    sp02Score += 2;
                }
            }
        }
        // Temperature scoring
        if (this.temperature <= 35.0){
            score += 3;
            temperatureScore += 3;
        }else if (this.temperature <= 36.0){
            score += 1;
            temperatureScore += 1;
        }else if (this.temperature >= 38.1 && this.temperature <= 39.0){
            score += 1;
            temperatureScore += 1;
        }else if (this.temperature  >= 39.1){
            score += 3;
            temperatureScore += 3;
        }

        if (cbg != null && isFasting != null) {
            if (isFasting) {
                if (cbg <= 3.4){
                    cbgScore = 3;
                    score += 3;
                } else if (cbg <= 3.9){
                    cbgScore = 2;
                    score += 2;
                } else if (cbg >= 6.0){ cbgScore = 3;
                score += 3;
                } else if (cbg >= 5.5){
                    cbgScore = 2;
                    score += 2;
                }
            } else {
                if (cbg <= 4.5) {
                    cbgScore = 3;
                    score += 3;
                } else if (cbg <= 5.8) {
                    cbgScore = 2;
                    score += 2;
                } else if (cbg >= 9.0) {
                    cbgScore = 3;
                    score += 3;
                } else if (cbg >= 7.9) {
                    cbgScore = 2;
                    score += 2;
                }
            }
        }
        return score;
    }

    // Record
    private final List<PatientRecord> records = new ArrayList<>();
    private record PatientRecord (int score, LocalDateTime timestamp){
    }


    public boolean isScoreUp(){
        if (records.size() < 2){ return false;}

        LocalDateTime now = LocalDateTime.now();
        int latestScore = records.get(records.size() - 1).score();

        for (int i = records.size() - 2; i >= 0; i--){
            PatientRecord record = records.get(i);
            if (record.timestamp().isAfter(now.minusHours(24))){
                if ((latestScore - record.score) > 2){
                    return true;
                }
            }else {
                break;
            }
        }
        return false;
    }

    public void addRecordManually(int score, LocalDateTime timestamp){
        records.add(new PatientRecord(score,timestamp));
    }
}
