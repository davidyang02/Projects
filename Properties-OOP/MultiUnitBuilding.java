public class MultiUnitBuilding extends Property {
    private int numUnits;
    private boolean elevator;
    private double buildingFS;

    /*
     * Full parameter constructor
     * @param lp listing price of Land
     * @param bfs building floor space
     * @param nU number of units
     * @param e is there an elevator
     */
    MultiUnitBuilding (double lP, double bfs, int nU, boolean e) {
        super(lP);
        buildingFS = bfs;
        numUnits = nU;
        elevator = e;
    }

    // Accessors for each instance in the MultiUnitBuilding class
    public double getBuildingFS(){
        return buildingFS;
    }    
    public int getNumUnits(){
        return numUnits;
    } 
    public boolean getElevator(){
        return elevator;
    } 

    // Mutator for each instance in the MultiUnitBuilding class
    public void setBuildingFS(double bfs) throws BadProperty{
        if (bfs <= 0)
        throw BadProperty (" Illegal Value");
        buildingFS = bfs;
    }
    public void setNumUnits(int nU) throws BadProperty{
        if (nU <= 0)
        throw BadProperty (" Illegal Value");
        numUnits = nU;
    }
    public void setElevator(boolean e) {
        elevator = e;
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the MultiUnitBuilding Object
    public String toString(){
        String s = "Multi-Unit Building, listing price $" + super.getlistingPrice() 
        + ", " + buildingFS + " square meters, " + numUnits 
        + " units, elevator:" + elevator;
        return s;
    }

}