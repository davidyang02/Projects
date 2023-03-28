class Registry {

    private Vehicle[] vehicleCollection;
    private int numVehicles;

    /*
    * Full parameter constructor
    * @param va the vehicles in the registry collection
    * @param nv the number of vehicles in the registry
    */
    Registry (String v, int nv) {
        vehicleCollection = v;
        numVehicles = nv;
    }

    // Accessors for each instance in the Registry class
    public String getVehicleCollection() {
        return vehicleCollection;
    }
    public int getNumVehicles() {
        return numVehicles;
    }

    
    // Mutator for each instance in the Registry class
    public void setVehicleCollection(String v){
        vehicleCollection = v;
    }
    public void setNumVehicles(int n){
        numVehicles = n;
    }

    // This method adds a Vehicle into the registry and takes
    // a vehicle parameter
    void addVehicle(Vehicle ad) {

        int vcl = vehicleCollection.length;
        Vehicle[] newVehicleCollection = new Vehicle[n + 1];
        for (int i = 0; i < n; i++){
            newVehicleCollection[i] = vehicleCollection[i];
        }

        newVehicleCollection[vcl] = ad;
        numVehicles++;
    }

    // This method prints the entire registry of vehicles
    void printRegistry(){
        
            for (int i = 0; i < vehicleCollection.length; i++)
            {
                System.out.println(vehicleCollection[i]);
            }
        }

    // This method sums up the odometer readings of each vehicle in Vehicle Collection,
    // and divides it by the total number of vehicles 
    double averageMileage()
    {
        int nod = vehicleCollection.length;
        int sum = 0;
        double average = 0;
        for (int i = 0; i < vehicleCollection.length; i++) {
            sum += vehicleCollection[i].getOdometerReading();
        }
        average = sum/nod;
        return average;
    }

    

    // toString method that prints out a string representation thats prints
    // all of the instances of the Registry Object
    public String toString(){
        String s = " The registry has a collection of " +
         vehicleCollection + " of vehicles and has "
        + numVehicles + " vehicles currently registered in the province";
        return s;
    }
}
