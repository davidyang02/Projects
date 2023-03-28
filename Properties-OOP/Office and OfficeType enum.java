// The Office type classifications
public enum OfficeType {
    SERVICE, SALES, INDUSTRIAL
}
// Prints string output given the office classification
public class enumOffice {

    OfficeType officeT;

    public enumOffice(OfficeType officeT){
        this.officeT = officeT;
    }
    
    public void usingENumsO(){
        switch (officeT) {
            case SERVICE:
                System.out.println("service");
            break;
            case SALES:
                System.out.println("Sales");
            break;
            case INDUSTRIAL:
                System.out.println("Industrial");
            break;
            default:
                System.out.println("Invalid Entry");
            break;
        }

    }
}

public class Office extends MultiUnitBuilding {
    private OfficeType classification;

      /*
     * Full parameter constructor
     * @param lp listing price of Land
     * @param bfs building floor space
     * @param nU number of units
     * @param e is there an elevator
     * @ param cl office classification
     */
    Office (double lP, double bfs, int nU, boolean e, OfficeType cl) {
        super (lP, bfs, nU, e);
        classification = cl;

    }

    // Accessors for each instance in the Office class
    public String getClassification(){
        return classification;
    }    

    // Mutator for each instance in the Office class
    public void setClassification(OfficeType cl) {
        this.cl = cl;
    }
        // Calculates the Office's Tax
        public void calculateTax(){ 
            double otax = (10 * super.getBuildingFS()) + (20 * super.getNumUnits());
            if (classification == OfficeType.INDUSTRIAL){ 
                otax *= 0.9;
            }
            if (classification == OfficeType.SERVICE) {
                otax *= 0.95;
            }
            System.out.println(otax);
        }
        // toString method that prints out a string representation thats prints
        // all of the instances of the Office Object
        public String toString(){
            String s = "Office, listing price $" + super.getlistingPrice() 
            + ", " + super.getBuildingFS() + " square meters, " + super.getNumUnits() 
            + " units, elevator:" + super.getElevator() + ", classification:" 
            + classification;
            return s;
        }

}