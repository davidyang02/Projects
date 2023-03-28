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