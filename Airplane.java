import java.util.Scanner;
import java.io.IOException;

public class Airplane {

    static Scanner input = new Scanner(System.in);
    static Class firstClass = new Class(5,4); // Creates a new instance of the class with new conditions for seating
    static Class economyClass = new Class(30,6); // Creates a new instance of the class with new conditions for seating
     
    public static void addPassenger() throws IOException{
        
        System.out.println("Pick a class for seating (First or Economy) : "); // Gives you the option for First or Economy class
        
        String option = input.next();

        int spot;
        int passengers;

        switch(option){
            case "First" :
            System.out.println("Nice! (Window, Aisle) : "); // Gives the option for the type of seating after picking the class
            option = input.next();
            switch(option){
                case "Window" :
                spot = 2; // For the algorythm to find the correct seating location
                break;
                case "Aisle" :
                spot = 1;
                break;
                default :
                System.out.println("Invalid");
                spot = 1;
            }
            System.out.println("How many passengers (One, Two) : "); // Gives option for amount of passengers after picking seating
            option = input.next();
            switch(option){
                case "One" :
                passengers = 1; // For the algorythm to know what orientation to add passengers and checking for open seating
                break;
                case "Two" :
                passengers = 2;
                break;
                default :
                System.out.println("Invalid");
                passengers = 1;
                
            }
            // Using the firstClass instance with its specific conditions for adding passengers
            firstClass.addPassenger(spot, passengers); // Uses information from selected options to place the passengers in an open spot
            break;
            case "Economy" :
            System.out.println("Booo! (Window, Center, Aisle) : "); // Gives the option for the type of seating after picking the class
            option = input.next();
            switch(option){
                case "Window" :
                spot = 3; // For the algorythm to find the correct seating location
                break;
                case "Center" :
                spot = 2;
                break;
                case "Aisle" :
                spot = 1;
                break;
                default :
                System.out.println("Invalid");
                spot = 1;
            }
            System.out.println("How many passengers (One, Two, Three) : "); // Gives option for amount of passengers after picking seating
            option = input.next();
            switch(option){
                case "One" :
                passengers = 1; // For the algorythm to know what orientation to add passengers and checking for open seating
                break;
                case "Two" :
                passengers = 2;
                break;
                case "Three" :
                passengers = 3;
                break;
                default :
                System.out.println("Invalid");
                passengers = 1;
                
            }
            // Using the economyClass instance with its specific conditions for adding passengers
            economyClass.addPassenger(spot, passengers); // Uses information from selected options to place the passengers in an open spot
            break;
            default :
            System.out.println("Invalid");
        }
    }
    
    //Precondition : Dont know want to keep going if the user wants to stop adding passengers
    //Postcondition : Returns bool based on users input and exits the loop if requested
    public static Boolean quit() {
        System.out.println("Do you want to continue? (Y/N) : ");
        String option = input.next();
        if (option.equals("N")||option.equals("n")) {
            return false;
        } else return true;
    }
    
    //Precondition : Dont know what the seating looks like and if the program is working properly
    //Postcondition : Prints the current seating of both classes
    public static void printSeating(){
        firstClass.print(); // Prints the all the seating for the firstclass instance
        economyClass.print(); // Prints all the seating for the economyclass instance
    }
}
