public class IllegalVehicle extends Exception {

    /* Constructor for the IllegalVehicle class*/
    // Default message
    public IllegalVehicle() {
        super("Illegal value/s");
    }
    // More specific message
    public IllegalVehicle(string message){
        super(message);
    }
}