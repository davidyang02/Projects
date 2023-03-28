class Car extends Vehicle {

    private int numSeats;
    private boolean isSUV;

    /*
    * Full parameter constructor
    * @param ns number of seats in the car
    * @param is is this car an SUV or not
    */
    Car (int ns, boolean is) {
        super(ns,is);
        numSeats = ns;
        isSUV = is;

    }

    // Accessors for each instance in the Registry class
    public int getNUmSeats() {
        return numSeats;
    }
    public boolean getIsSUV() {
        return isSUV;
    }
    // Mutator for each instance in the Registry class
    public void setNumSeats(int ns){
        numSeats = ns;
    }

    // Used to make the isSUV boolean sound better in the toString
    String result1 = "";

    public void setIsSUV(boolean is) {
    
    // Used to make the isSUV boolean sound better in the toString
        if (isSUV == true){
            result1 = "is";
        }
        if (isSUV == false){
            result1 = "is not";
        }
        isSUV = is;
    }

    // toString method that prints out a string representation thats prints
    // all of the instances of the Car Object
    public String toString(){
        String s = " The car has " + numSeats + " seats and " + result
        + " an SUV ";
        return s;
    }
}