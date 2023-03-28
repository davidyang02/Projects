public class ApartmentBuilding extends MultiUnitBuilding {
    private int tenants;
    private double aptFS;


    /*
     * Full parameter constructor
     * @param lp listing price of Land
     * @param bfs building floor space
     * @param nU number of units
     * @param t number of tenants
     * @param afs floor space per apartment
     */
    ApartmentBuilding (double lP, double bfs, int nU, int t, double afs){
    super(lP, bfs, nU, true);
    tenants = t;
    // Although it is not explicity mentioned in the assignment 
    // I thought that is the apartment floor space per unit was 
    // not a parameter, there would be no way of storing that info
    aptFS = afs;

}
    // Accessors for each instance in the ApartmentBuilding class
    public String getTenants(){
        return tenants;
    }    
    public double getaptFS(){
        return aptFS;
    }


    // Mutator for each instance in the ApartmentBuilding class
    public void setTenants(int t) {
        tenants = t;
    }
    public void setaptFS(double afs){
        aptFS = afs;
    }
    // Calculates the Apartment's Tax
    public void calculateTax(){ 
        double atax = (35 * aptFS * super.getNumUnits());
        System.out.println(atax);
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the Apartment Object
    public String toString(){
        String s = "Office, listing price $" + super.getlistingPrice() 
        + ", " + super.getBuildingFS() + " square meters, " 
        + super.getNumUnits() + " units, " + tenants + " tenants";
        return s;
    }
}
