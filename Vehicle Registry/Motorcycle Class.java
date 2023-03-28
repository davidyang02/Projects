class Motorcycle extends Vehicle {

    /*
    * Full parameter constructor
    * There are not instances in this class
    */
    Motorcycle () {
        // Since there are no new instances for the Motorcycle
        // class, I thought that having an empty super made the most sense.
        // If this is wrong, please let me know
        super ();
    }

    // toString method that prints out a string representation thats prints
    // all of the instances of the Motorcycle Object
    public String toString(){
        String s = "This is a Motorcyle";
        return s;

    }
}