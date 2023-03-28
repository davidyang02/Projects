class CarOwner {

    private String name;
    private int age;
    private int licenseNumber;
    private int yearsDriving;

    /*
    * Full parameter constructor
    * @param na name of the car owner
    * @param a age of the car owner
    * @param l license number of the car owner
    * @param yd number of years the car owner has been driving
    */
    CarOwner (String na, int a, int l, int yd){
        name = na;
        age = a;
        licenseNumber = l;
        yearsDriving = yd;
    }

    
    // Accessors for each instance in the CarOwner class
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getLicenseNumber() {
        return licenseNumber;
    }
    public int getYearsDriving() {
        return yearsDriving;
    }
    
    // Mutator for each instance in the CarOwner class
    public void setName(int na){
        name = na;
    }

    public void setAge(int a) throws GeneralException {

        // If the age of car owner is less than zero, throw an exception
        if (a < 0)
            throw GeneralException("Illegal value!");
        age = a;
    }

    public void setLicenseNumber(int l){
        licenseNumber = l;
    }

    public void setYearsDriving(int yd) throws GeneralException {

        // if the number of years the car owner has driven is less
        // than zero, throw an exception
        if (yd < 0)
            throw GeneralException("Illegal value!");
        yearsDriving = yd;
    }
    // toString method that prints out a string representation thats prints
    // all of the instances of the CarOwner Object
    public String toString(){
        String s = " The car owner's name is " + name +
         ", the owner's age is " + age
         + ", their license number is " + licenseNumber +
          ", and they have driven " + yearsDriving + " years";
            return s;
    }
}