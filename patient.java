class patient {
    private enum AirOrOxygen{
        AIR(0),
        OXYGEN(2);

        // Constructor
        private final int value;
        AirOrOxygen(int value){
            this.value = value;
        }

        // Getter
        public int getValue(){
            return value;
        }
    }

    private enum Conciousness{
        ALERT(0), CVPU(1);

        // Constructor
        private final int value;
        Conciousness(int value) {
            this.value = value;
        }
        // Getter
        public int getValue(){
            return value;
        }

        // Method to return whether the patient is conscious or alert
        public static Conciousness getConciousness(int value){
            // if value is 0, then ALERT is returned, else CVPU is returned
            if (value == 0){
                return ALERT;
            }else {
                return CVPU;
            }
        }
    }
}
