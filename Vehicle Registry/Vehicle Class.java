public class Main {
    public static void main(String[] args)
    {

    }
}

public class Vehicle {


    private int registrationNumber;
    private String owner;
    private int odometerReading;
    private String make;
    private String model;
    private int year;
    private int numWheels;
    private String plateNumber;


    /*
    * Full parameter constructor
    * @param r registration number of the vehicle
    * @param ow name of the owner of the vehicle
    * @param od odmeter reading indicating the mileage of the vehicle
    * @param ma make of the vehicle
    * @param mo model of the vehicle
    * @param y year the vehicle was produced
    * @param n number of wheel the vehicle has
    * @param p plate number of the vehicle
    */
    Vehicle (int r, String ow, int od, String ma, String mo, int y, int n, String p){
        registrationNumber = r;
        owner = ow;
        odometerReading = od;
        make = ma;
        model = mo;
        year = y;
        numWheels = n;
        plateNumber = p;

    }
    // Accessors for each instance in the Vehicle class
    public int getRegistrationNumber(){
        return registrationNumber;
    }
    public int getOwner(){
        return owner;
    }
    public int getodometerReading(){
        return odometerReading;
    }
    public String getMake(){
        return make;
    }
    public int getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public int getNumWheels(){
        return numWheels;
    }
    public String getPlateNumber(){
        return plateNumber;
    }

    // Mutator for each instance in the Vehicle class
    public void setRegistrationNumber(int r){
        registrationNumber = r;
    }
    public void setOwner(String ow){
        owner = ow;
    }


    public void setOdemeterReading (int od) throws GeneralException {
        // Create an array to storage odemeter values, so that past 
        // readings can be compares with new ones
        int orStorage[] =+ od;
        int orSR = orStorage.length - 1;
        int orSS = orStorage.length - 2;
        // If there is only one reading in the array orSR will be index 1 and
        // orSR will be index -1, which end up being the same value, 
        // thus the bottom if statement will not be affected

        if (orStorage[orSR] > orStorage[orSS])
            throw new GeneralException("Illegal mileage - nice try!");
        odometerReading = od;
    }
    public void setMake (String ma){
        make = ma;
    }
    public void setModel (String mo){
        model = mo;
    }
    public void setYear (int y) throws GeneralException {
        // Throws an exception if the vehicle was made before 1980
        if (y < 1980)
            throw new GeneralException("Illegal year - you need ot buy a newer vehicle!");
        year = y;
    }





    public void setNumWheels (int n) throws GeneralException {

        // Throws an exception if the number of wheels on the vehicle is less than two
        if (n < 2)
            throw new GeneralException(" Illegal number of wheels - buy a unicycle!");
        numWheels = n;
    }
    public void setPlateNumber (String p) throws GeneralException {

        // Checks is the length of the String p is seven, if the first four
        // units of the input are letters, and if the next three are
        // digits. Throws an exception if otherwise
        int pLength = p.length;

        int countc = 0;
        int countn = 0;
        for( int i = 0; i < 4; i++){
            if(p.isLetter(i) == true)
                countc++;}
        for( int i = 4; i < 7; i++){
            if(p.isDigit(i) == true)
                countn++;
        }
        if (countc != 4 || countn != 3 || pLength != 7)
            throw GeneralException (" Illegal license plate!");
        plateNumber = p;
    }

    // toString method that prints out a string representation thats prints
    // all of the instances of the Vehicle Object
    public String toString(){
        String s = " The vehicle's registration number is " + 
        registrationNumber + ", the owner is " + owner
        + ", the odometer reading shows " + odometerReading +
        " km, the make of the vehicle is " + make +
        ", the model is a " + model + ", the year of production is " 
        + year +", the number of wheels the vehicle has is " + numWheels +
            ", and the plate number is " + plateNumber;
        return s;
    }
}