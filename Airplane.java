import java.util.Scanner;
import java.io.IOException;

public class Airplane {

    static Scanner input = new Scanner(System.in);
    static Class firstClass = new Class(5,4);
    static Class economyClass = new Class(30,6);
     
    public static void addPassenger() throws IOException{
        System.out.println("Pick a class for seating (First or Economy) : ");
        
        String option = input.next();

        int spot;
        int passengers;

        switch(option){
            case "First" :
            System.out.println("Nice! (Window, Aisle) : ");
            option = input.next();
            switch(option){
                case "Window" :
                spot = 2;
                break;
                case "Aisle" :
                spot = 1;
                break;
                default :
                System.out.println("Invalid");
                spot = 1;
            }
            System.out.println("How many passengers (One, Two) : ");
            option = input.next();
            switch(option){
                case "One" :
                passengers = 1;
                break;
                case "Two" :
                passengers = 2;
                break;
                default :
                System.out.println("Invalid");
                passengers = 1;
                
            }
            firstClass.addPassenger(spot, passengers);
            break;
            case "Economy" :
            System.out.println("Booo! (Window, Center, Aisle) : ");
            option = input.next();
            switch(option){
                case "Window" :
                spot = 3;
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
            System.out.println("How many passengers (One, Two, Three) : ");
            option = input.next();
            switch(option){
                case "One" :
                passengers = 1;
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
            economyClass.addPassenger(spot, passengers);
            break;
            default :
            System.out.println("Invalid");
        }
    }

    public static Boolean quit() {
        System.out.println("Do you want to continue? (Y/N) : ");
        String option = input.next();
        if (option.equals("N")||option.equals("n")) {
            return false;
        } else return true;
    }
    
    public static void printSeating(){
        firstClass.print();
        economyClass.print();
    }
}
