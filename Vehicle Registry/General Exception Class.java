// This class is used for exceptions that are not explicitly
// stated to use the IllegalVehicle Exception
public class GeneralException extends Exception {

    /* Constructor for the GeneralException class */
    // Default message
    public GeneralException() {
        super("Illegal value");
    }
    // More specific message
    public GeneralException(String message){
        super(message);
    }
}