public class Cottage extends House {
    private double lakeFrontage;
 
 
        /*
      * Full parameter constructor
      * @param lP listing price
      * @param nBA number of bathrooms
      * @param nBD number of bedrooms
      * @param d depth of the lot
      * @param w width of the lot
      * @param fs floor space
      */
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