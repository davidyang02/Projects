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
