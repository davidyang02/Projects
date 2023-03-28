public class Land extends Property{
    private double numHectares;
 
     /*
      * Full parameter constructor
      * @param lp listing price of Land
      * @param nH number of hectares
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