import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;

public class BadProperty extends Exception{
    // More specific message
    public BadProperty(String message){
        super(message);
    }
}




public abstract class Property extends Comparable<Property> implements Property<Property> {

  private double listingPrice;

    /*
     * Full parameter constructor
     * @param l listing price of the property
     */
    Property (double lP){
        listingPrice = lP;
    }
    // Accessors for each instance in the Property class
    public double getlistingPrice(){
        return listingPrice;
    }
    // Mutator for each instance in the Property class
    public void setlistingPrice(double lP) throws BadProperty {
        if (lP < 0)
            throw BadProperty ("Illegal Value");
        listingPrice = lP;
    }
    // Abstract method to calculate a property's Tax
    public abstract void calculateTax();



    public int compareTo(Property a, Property b) {


        int compareValue = a.compareTo(b);
        double difference = null;
        if (compareValue == 0){
            System.out.println(a + " and " + b + " are the same price" );}
        else if (compareValue < 0) {
            difference = (b.getlistingPrice() - a.getlistingPrice());
            System.out.println(b + " is $" + difference + ",000 more expensive than " + a);}
        else
            difference = (a.getlistingPrice() - b.getlistingPrice());
            System.out.println(a + " is $" + difference + ",000 more expensive than " + b);
    }

}
     


// The house type classification
public enum HouseType {
    TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME
}


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
        }
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
    }

}
public class Cottage extends House {
   private double lakeFrontage;

   Cottage ( double lP, double fs, int nBD, int nBA, double w, double d, double lf) {
    super(lP, fs, nBD, nBA, w, d, HouseType.WATERFRONT_HOME);
    lakeFrontage = lf;
   }
    // Accessors for each instance in the Cottage class
    public double getLakeFrontage(){
        return lakeFrontage;
    }
    
    // Mutator for each instance in the Cottage class
    public void setLakeFrontage(double lf) throws BadProperty{
        if (lf <= 0)
            throw BadProperty (" Illegal Value");
        lakeFrontage = lf;
    }
    // Calculates the Cottage's Tax
    public void calculateTax(){ 
        double ctax = (2000 + (2 * lakeFrontage));
        System.out.println(ctax);
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the Cottage Object
    public String toString(){
    String s = "Cottage, listing price $" + super.getlistingPrice() + ", "
    + super.getnumBedroom() + " Bedrooms, " + super.getnumBathroom() + " Bathrooms, " 
    + super.getDepth() + " m deep by " + super.getWidth() + " m, " + super.getFloorSpace() 
    + " square meters, lake frontage is "+ lakeFrontage + " m, house classification is  "+ HouseType.h;
    return s;
    }
}

public class Land extends Property{
   private double numHectares;

    /*
     * Full parameter constructor
     * @param lp listing price of Land
     * @param nH numberof hectares
     */
    Land (double lP, double nH){
        super(lP);
        numHectares = nH;
    }

    // Accessors for each instance in the Land class
    public double getnumHectares(){
        return numHectares;
    }
    
    // Mutator for each instance in the Land class
    public void setnumHectares(double nH) throws BadProperty{
        if (nH <= 0)
        throw BadProperty (" Illegal Value");
        numHectares = nH;
    }
    // Calculates the Land's Tax
    public void calculateTax(){ 
        double ltax = (100 * numHectares);
        System.out.println(ltax);
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the Land Object
    public String toString(){
        String s = "Land, listing price $" + super.getlistingPrice() 
        + ", " + numHectares + " hectares";
        return s;
    }
}
public class Farm extends Land {
   private String crop;

    /*
     * Full parameter constructor
     * @param lp listing price of Land
     * @param nH numberof hectares
     */
    Farm (double lP, double numHectares, String c) {
        super(lP, numHectares);
        crop = c;
    }

    // Accessors for each instance in the Farm class
    public String getCrop(){
        return crop;
    }
    
    // Mutator for each instance in the Farm class
    public void setCrop(String c) throws BadProperty{
        if (c = null)
        throw BadProperty (" Illegal Value");
        crop = c;
    }
    // Calculates the Farm's Tax
    public void calculateTax(){ 
        double ftax = (2 * super.getnumHectares());
        System.out.println(ftax);
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the Farm Object
    public String toString(){
        String s = "Farm, listing price $" + super.getlistingPrice() + ", " 
        + super.getnumHectares() + " hectares, crop is " + crop;
        return s;
    }

}
public class MultiUnitBuilding extends Property {
    private int numUnits;
    private boolean elevator;
    private double buildingFS;

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
public class ApartmentBuilding extends MultiUnitBuilding {
    private int tenants;
    private double aptFS;

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


public class Test {
    public static void main(String[]args){

        ArrayList<Property> propertyDB = new ArrayList<Property>();

            Property prop1 = new Office(120, 3, 4, true, classification.SERVICE);

            propertyDB.add (prop1);

            Property prop2 = new Farm(250, 3400, "vegetables");
            propertyDB.add(prop2);
            System.out.println(compareTo(prop1,prop2));

            Property prop3 = new Farm(120, 3, "grass");

            propertyDB.add (prop3);

            Property prop4 = new Farm(250, 3400, "vegetables");
            propertyDB.add(prop4);
            System.out.println(compareTo(prop3,prop4));
            
}}