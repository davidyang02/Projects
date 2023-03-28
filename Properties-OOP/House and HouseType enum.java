// The house type classification
public enum HouseType {
    TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME
}
// Prints string output given the house classification
public class enumHouse {

    HouseType houseT;

    public enumHouse(HouseType houseT){
        this.houseT = houseT;
    }
    
    public void usingENumsO(){        
        switch (houseT) {
            case TOWNHOUSE:
                System.out.println("Townhouse");
            break;
            case DETACHED:
                System.out.println("Detached");
            break;
            case DUPLEX:
                System.out.println("Duplex");
            break;
            case WATERFRONT_HOME:
                System.out.println("Waterfront Home");
            break;
            default:
                System.out.println("Invalid");
            break;
        }}}

public class House extends Property {

   private int numBathroom;
   private int numBedroom;
   private double depth;
   private double width;
   private double floorSpace;
   // Need to add this attribute in order for tostring and 
   // testing to recongnize it as a parameter for the House object
   private HouseType houseT;

    /*
     * Full parameter constructor
     * @param lP listing price
     * @param nBA number of bathrooms
     * @param nBD number of bedrooms
     * @param d depth of the lot
     * @param w width of the lot
     * @param fs floor space
     * @param h is the house type
     */
    House (double lP, double fs, int nBD, int nBA, double w, double d, HouseType hT){
        super(lP);
        numBathroom = nBA;
        numBedroom = nBD;
        depth = d;
        width = w;
        floorSpace = fs;
        houseT = hT;


    }
    // Accessors for each instance in the House class
    public int getnumBathroom(){
        return numBathroom;
    }
    public int getnumBedroom(){
        return numBedroom;
    }
    public double getDepth(){
        return depth;
    }
    public double getWidth(){
        return width;
    }
    public double getFloorSpace(){
        return floorSpace;
    }
    public HouseType gethouseT(){
        return houseT;
    }


    // Mutator for each instance in the House class
    public void setnumBathroom(int nBA) throws BadProperty {
        if (nBa = 0)
            throw BadProperty ("Illegal value");
        numBathroom = nBA;
    }
    public void setnumBedroom(int nBD) throws BadProperty {
        if (nBD = 0)
            throw BadProperty ("Illegal value");
        numBedroom = nBD;
    }
    public void setDepth (double d) { 
        depth = d;
    }
    public void setWide (double w) { 
        width = w;
    }
    public void setFloorSpace (double fs) { 
        floorSpace = fs;
    }
    public void setH (HouseType hT) {
        houseT = hT;
    }
    // Calculates the House's Tax
    public void calculateTax(){ 
        double htax = (1000 + (50*numBedroom) +(10 * floorSpace));
        System.out.println(htax);
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the House Object
    public String toString(){
        String s = "House, listing price $" + super.getlistingPrice()  
        + numBedroom + " Bedrooms, " + numBathroom + " Bathrooms, " 
        + depth + " m deep by " + width + " m, " + floorSpace 
        + " square meters, house classification is  "+ houseT;
        return s;
    }}