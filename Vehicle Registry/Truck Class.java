class Truck extends Vehicle {

    private boolean isSemi;
    private double loadCapacity;

    /*
    * Full parameter constructor
    * @param ise is this truck an semi or not
    * @param lc the load capacity of the truck
    */
    Truck (boolean ise, double lc) {
        super (ise, lc);
        isSemi = ise;
        loadCapacity = lc;
    }

    // Accessors for each instance in the Truck class
    public boolean getIsSemi() {
        return isSemi;
    }
    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Finds the number of axles on the truck
    public int getNumberAxles() {
    int numberAxles = getNumWheels()/ 2;
        return numberAxles;
    }

    // Used to make the isSemi boolean sound better in the toString
    String result = "";

    // Mutator for each instance in the Truck class
    public void setIsSemi(boolean i){
        
    // Used to make the isSemi boolean sound better in the toString
    if (isSemi == true){
        result = "is";
    }
    if (isSemi == false){
        result = "is not";
    }
        isSemi = i;
    }
    public void setLoadCapacity(double l){
        loadCapacity = l;
    }

    // toString method that prints out a string representation thats prints
    // all of the instances of the Truck Object
    public String toString(){
        String s = " The truck " + result + " a semi and has a load capacity of " 
        + loadCapacity + "pounds";
        return s;
    }
}