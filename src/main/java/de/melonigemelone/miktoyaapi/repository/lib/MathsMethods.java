package de.melonigemelone.miktoyaapi.repository.lib;

public class MathsMethods {

    //Überprüft ob die Eingabe ein Integer ist
    public static boolean isInteger(String value) {
        try{
            Integer.parseInt(value);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    //Überprüft ob die Eingabe ein Double ist
    public static boolean isDouble(String value) {
        try{
            Double.parseDouble(value);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    //Überprüft ob die Eingabe ein Float ist
    public static boolean isFloat(String value) {
        try{
            Float.parseFloat(value);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
